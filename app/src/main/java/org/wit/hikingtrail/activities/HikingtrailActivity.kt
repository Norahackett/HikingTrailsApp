package org.wit.hikingtrail.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.wit.hikingtrail.databinding.ActivityHikingtrailBinding
import org.wit.hikingtrail.models.HikingtrailModel
import timber.log.Timber
import timber.log.Timber.i

class HikingtrailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHikingtrailBinding
    var hikingtrail = HikingtrailModel()
    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHikingtrailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("HikingTrail Activity started..")
        binding.btnAdd.setOnClickListener() {
            val hikingtrailTitle = binding.hikingtrailTitle.text.toString()
            if (hikingtrailTitle.isNotEmpty()) {
                i("add Button Pressed: $hikingtrailTitle")
            } else {
                Snackbar
                    .make(it, "Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}