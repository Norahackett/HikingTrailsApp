package org.wit.hikingtrail.views.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.wit.hikingtrail.databinding.ActivityHikingtrailMapsBinding
import org.wit.hikingtrail.databinding.ContentHikingtrailMapsBinding
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailModel

class HikingtrailMapView : AppCompatActivity() , GoogleMap.OnMarkerClickListener{

    private lateinit var binding: ActivityHikingtrailMapsBinding
    private lateinit var contentBinding: ContentHikingtrailMapsBinding
    lateinit var app: MainApp
    lateinit var presenter: HikingtrailMapPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = application as MainApp
        binding = ActivityHikingtrailMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        presenter = HikingtrailMapPresenter(this)

        contentBinding = ContentHikingtrailMapsBinding.bind(binding.root)

        contentBinding.mapView.onCreate(savedInstanceState)
        contentBinding.mapView.getMapAsync{
            GlobalScope.launch(Dispatchers.Main) {
                presenter.doPopulateMap(it)
            }
        }
    }
    override fun onMarkerClick(marker: Marker): Boolean {
        GlobalScope.launch(Dispatchers.Main) {
            presenter.doMarkerSelected(marker)
        }
        return true
    }
    fun showHikingtrail(hikingtrail: HikingtrailModel) {
        contentBinding.currentTitle.text = hikingtrail.title
        contentBinding.currentDescription.text = hikingtrail.description
        Picasso.get()
            .load(hikingtrail.image)
            .into(contentBinding.imageView2)
    }

    override fun onDestroy() {
        super.onDestroy()
        contentBinding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        contentBinding.mapView.onLowMemory()
    }

    override fun onPause() {
        super.onPause()
        contentBinding.mapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        contentBinding.mapView.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        contentBinding.mapView.onSaveInstanceState(outState)
    }


}
