package org.wit.hikingtrail.views.hikingtraillist


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.wit.hikingtrail.R

import org.wit.hikingtrail.databinding.CardHikingtrailBinding
import org.wit.hikingtrail.models.HikingtrailModel




interface HikingtrailListener {
    fun onHikingtrailClick(hikingtrail: HikingtrailModel)
}

class HikingtrailAdapter constructor(private var hikingtrails: List<HikingtrailModel>,
                                   private val listener: HikingtrailListener) :
    RecyclerView.Adapter<HikingtrailAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardHikingtrailBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val hikingtrail = hikingtrails[holder.adapterPosition]
        holder.bind(hikingtrail, listener)


    }

    override fun getItemCount(): Int = hikingtrails.size

    class MainHolder(private val binding : CardHikingtrailBinding) :
        RecyclerView.ViewHolder(binding.root) {




        fun bind(hikingtrail: HikingtrailModel, listener: HikingtrailListener) {
            binding.hikingtrailTitle.text = hikingtrail.title
            binding.description.text = hikingtrail.description
            binding.difficulty.text = hikingtrail.difficulty
            binding.rating.text= hikingtrail.rating
            binding.date.text= hikingtrail.date


            //binding.favIcon.



              //  if(hikingtrail.favourite)
                //    R.drawable.ic_fav_on
              //  else
               //     R.drawable.ic_fav_off

            //binding.favIcon.setOnClickListener{ listener.onHikingtrailClick(hikingtrail) }

            if (hikingtrail.image != ""){
                Picasso.get()
                    .load(hikingtrail.image)
                    .resize(200, 200)
                    .into(binding.imageIcon)
            }
            binding.root.setOnClickListener { listener.onHikingtrailClick(hikingtrail) }
        }
    }
}
