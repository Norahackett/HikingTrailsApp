package org.wit.hikingtrail.views.hikingtraillist
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.hikingtrail.R
import org.wit.hikingtrail.adapters.HikingtrailAdapter
import org.wit.hikingtrail.adapters.HikingtrailListener
import org.wit.hikingtrail.databinding.ActivityHikingtrailListBinding
import org.wit.hikingtrail.main.MainApp
import org.wit.hikingtrail.models.HikingtrailModel
import org.wit.placemark.views.hikingtraillist.HikingtrailListPresenter

class HikingtrailListView : AppCompatActivity(), HikingtrailListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivityHikingtrailListBinding
    lateinit var presenter: HikingtrailListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHikingtrailListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)
        presenter = HikingtrailListPresenter(this)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        loadHikingtrails()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> { presenter.doAddHikingtrail() }
            R.id.item_map -> { presenter.doShowHikingtrailsMap() }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onHikingtrailClick(hikingtrail: HikingtrailModel) {
        presenter.doEditHikingtrail(hikingtrail)

    }

    private fun loadHikingtrails() {
        binding.recyclerView.adapter = HikingtrailAdapter(presenter.getHikingtrails(), this)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}