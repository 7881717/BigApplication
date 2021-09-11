package com.example.bigapplication.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bigapplication.R

class CustomRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var flagImageView: ImageView? = null
        var largeTextView: TextView? = null
        var smallTextView: TextView? = null

        init {
            flagImageView = itemView.findViewById(R.id.imageViewFlag)
            largeTextView = itemView.findViewById(R.id.textViewLarge)
            smallTextView = itemView.findViewById(R.id.textViewSmall)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when (position % 5) {
            0 -> holder.flagImageView?.setImageResource(R.drawable.argentina)
            1 -> holder.flagImageView?.setImageResource(R.drawable.brazilia)
            2 -> holder.flagImageView?.setImageResource(R.drawable.chile)
            3 -> holder.flagImageView?.setImageResource(R.drawable.columbia)
            4 -> holder.flagImageView?.setImageResource(R.drawable.uruguai)
        }
        holder.largeTextView?.text = names[position]
        holder.smallTextView?.text = "кот"
    }

    override fun getItemCount() = names.size
}