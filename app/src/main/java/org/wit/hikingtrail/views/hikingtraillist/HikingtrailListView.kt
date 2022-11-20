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
import org.wit.hikingtrail.views.hikingtraillist.HikingtrailListPresenter
import timber.log.Timber.i

class HikingtrailListView : AppCompatActivity(), HikingtrailListener {

    lateinit var app: MainApp
    lateinit var binding: ActivityHikingtrailListBinding
    lateinit var presenter: HikingtrailListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        i("Recycler View Loaded")
        super.onCreate(savedInstanceState)
        binding = ActivityHikingtrailListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)
        presenter = HikingtrailListPresenter(this)
        //app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter =
            HikingtrailAdapter(presenter.getHikingtrails(), this)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        //update the view
        binding.recyclerView.adapter?.notifyDataSetChanged()
        i("recyclerView onResume")
        super.onResume()
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

}