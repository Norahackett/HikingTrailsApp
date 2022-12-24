package org.wit.hikingtrail.views.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar
import org.wit.hikingtrail.R
import org.wit.hikingtrail.databinding.ActivityLoginBinding


class LoginView : AppCompatActivity() {
    lateinit var presenter: LoginPresenter
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        presenter = LoginPresenter(this)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_login)


        binding.progressBar.visibility = View.GONE

        binding.signUp.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if (email == "" || password == "") {
                showSnackBar("please provide email and password")
            } else {
                presenter.doSignUp(email, password)
            }
        }

        binding.logIn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if (email == "" || password == "") {
                showSnackBar("please provide email and password")
            } else {
                presenter.doLogin(email, password)
            }
        }


    }

    fun showSnackBar(message: CharSequence) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .show()
    }

    fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }


    private fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("Light","Dark","System default")
        val checkedItem = 0

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    delegate.applyDayNight()

                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }

            }
        }

        val dialog = builder.create()
        dialog.show()
    }

}
