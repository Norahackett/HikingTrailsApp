package org.wit.hikingtrail.activities

import android.content.Intent
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

class HikingtrailListActivity : AppCompatActivity(), HikingtrailListener {
    lateinit var app: MainApp
    private lateinit var binding: ActivityHikingtrailListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHikingtrailListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = HikingtrailAdapter(app.hikingtrails.findAll(),this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, HikingtrailActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        binding.recyclerView.adapter?.notifyDataSetChanged()
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onHikingtrailClick(hikingtrail: HikingtrailModel) {
        val launcherIntent = Intent(this, HikingtrailActivity::class.java)
        launcherIntent.putExtra("hikingtrail_edit", hikingtrail)
        startActivityForResult(launcherIntent,0)
    }
}