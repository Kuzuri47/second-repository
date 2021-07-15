package com.example.imageretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageretrofit.R
import com.example.imageretrofit.data.Movies
import com.example.imageretrofit.data.Result
import org.w3c.dom.Text

class MyRecyclerViweAdapter(val context:Context,val movieList:List<Result>):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflator = LayoutInflater.from(parent.context)
            val listitem = inflator.inflate(R.layout.image_item_layout, parent, false)
        return MyViewHolder(listitem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = movieList[position]
        holder.movieTextView.text = list.title
        Glide
            .with(context)
            .load("https://image.tmdb.org/t/p/w500"+list.backdrop_path)
            //.fitCenter()
            .into(holder.myImageView);
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
class MyViewHolder(val view: View):RecyclerView.ViewHolder(view){


        val myImageView = view.findViewById<ImageView>(R.id.my_image_view)
        val movieTextView = view.findViewById<TextView>(R.id.my_text_view)


}