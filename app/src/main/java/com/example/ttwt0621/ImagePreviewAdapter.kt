package com.example.ttwt0621

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.example.ttwt0621.data.ImagePreview
import com.example.ttwt0621.image.MyImageLoader
import kotlin.properties.Delegates


class ImagePreviewAdapter(private val list : ArrayList<ImagePreview>)
    : CBClicked, RecyclerView.Adapter<ImagePreviewAdapter.ViewHolder>()
     {

    override fun  onCreateViewHolder(parent: ViewGroup, viewType : Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image_list, parent, false)

        return ViewHolder(view, this)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePreview = list.get(position)
        holder.textImagePreview.setText(imagePreview.tags)
        holder.currentPosition = position
        MyApplication.instance.imageLoader.loadImage(holder.image, imagePreview.previewURL)
        holder.checkBox.isChecked = imagePreview.isChecked
    }

    override fun CBClicked(position: Int, value: Boolean) {
        list.get(position).isChecked = value
    }


    class ViewHolder(itemView : View, adapter:CBClicked): RecyclerView.ViewHolder(itemView){

        val textImagePreview : TextView
        val image : NetworkImageView
        var currentPosition : Int =-1
        val checkBox : CheckBox

        init{
            textImagePreview = itemView.findViewById(R.id.tvImagePreview)
            image = itemView.findViewById(R.id.img_preview)
            checkBox = itemView.findViewById(R.id.cBImagePreview)
            checkBox.setOnCheckedChangeListener{view, checked ->
                adapter.CBClicked(currentPosition, checked)
            }
        }

    }
}
interface CBClicked{
    fun CBClicked(position : Int, value:Boolean)
}