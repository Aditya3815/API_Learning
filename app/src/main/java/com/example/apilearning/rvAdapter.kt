package com.example.apilearning

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class rvAdapter(val context: Context, var userInfo: userinfo):RecyclerView.Adapter<rvAdapter.ViewHolder>(){

     class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userImage:ImageView = itemView.findViewById(R.id.imageView)
        val userText: TextView = itemView.findViewById(R.id.txtGithub)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_itemapi, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userInfo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide
            .with(context)
            .load(userInfo[position].avatar_url)
            .into(holder.userImage)
        holder.userText.text = userInfo[position].login
    }
}

