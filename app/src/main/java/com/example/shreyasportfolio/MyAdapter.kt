package com.example.shreyasportfolio

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (var eduArrayList: List<edu>, var context : Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.eachedu, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem=eduArrayList[position]
        holder.edutitle.text=currentItem.edu
        holder.eduimg.setImageResource(currentItem.img)
    }

    override fun getItemCount(): Int {
        return eduArrayList.size
    }
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val edutitle = itemView.findViewById<TextView>(R.id.edutv)
        val eduimg = itemView.findViewById<ShapeableImageView>(R.id.eduimg)


    }
}