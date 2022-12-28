package org.wit.hikingtrail.views.login
import android.content.Intent
import android.provider.Settings.Global.getString
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import org.wit.hikingtrail.R
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailFireStore
import org.wit.hikingtrail.views.hikingtraillist.HikingtrailListView



class LoginPresenter (val view: LoginView) {
    private lateinit var loginIntentLauncher: ActivityResultLauncher<Intent>
    var app: MainApp = view.application as MainApp
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var fireStore: HikingtrailFireStore? = null

    init {
        registerLoginCallback()
        if (app.hikingtrails is HikingtrailFireStore) {
            fireStore = app.hikingtrails as HikingtrailFireStore
        }

    }


    fun doLogin(email: String, password: String) {
        view.showProgress()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(view) { task ->
            if (task.isSuccessful) {
                if (fireStore != null) {
                    fireStore!!.fetchHikingtrails {
                        view?.hideProgress()
                        val launcherIntent = Intent(view, HikingtrailListView::class.java)
                        loginIntentLauncher.launch(launcherIntent)
                    }
                } else {
                    view?.hideProgress()
                    val launcherIntent = Intent(view, HikingtrailListView::class.java)
                    loginIntentLauncher.launch(launcherIntent)
                }
            } else {
                view?.hideProgress()
                view.showSnackBar("Login failed: ${task.exception?.message}")
            }
            view.hideProgress()
        }

    }

    fun doSignUp(email: String, password: String) {
        view.showProgress()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(view) { task ->
            if (task.isSuccessful) {
                fireStore!!.fetchHikingtrails {
                    view?.hideProgress()
                    val launcherIntent = Intent(view, HikingtrailListView::class.java)
                    loginIntentLauncher.launch(launcherIntent)
                }
            } else {
                view.showSnackBar("Login failed: ${task.exception?.message}")
            }
            view.hideProgress()
        }
    }

    private fun registerLoginCallback() {
        loginIntentLauncher =
            view.registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { }
    }
}



