package com.example.ttwt0621

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.example.ttwt0621.data.ImagePreview
import com.example.ttwt0621.image.MyImageLoader

class ImageFullAdapter (private val list : ArrayList<String>)
    : RecyclerView.Adapter<ImageFullAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_full_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageFullURL = list.get(position)
        MyApplication.instance.imageLoader.loadImage(holder.image, imageFullURL)
        //myImageLoader.loadImage(holder.image, imageFullURL)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        val image: NetworkImageView

        init {
            image = itemView.findViewById(R.id.img_full)
        }
    }
}
