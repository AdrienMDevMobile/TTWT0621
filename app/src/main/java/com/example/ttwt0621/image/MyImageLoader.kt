package com.example.ttwt0621.image

import android.annotation.SuppressLint
import android.graphics.Bitmap
import com.android.volley.toolbox.ImageLoader
import androidx.collection.LruCache
import com.android.volley.RequestQueue
import com.android.volley.toolbox.NetworkImageView

class MyImageLoader (requestQueue: RequestQueue) {
    private val imageLoader: ImageLoader

    init {
        imageLoader = ImageLoader(requestQueue,
            object : ImageLoader.ImageCache {
                private val cache: LruCache<String, Bitmap> = LruCache<String, Bitmap>(20)
                override fun getBitmap(url: String): Bitmap? {
                    return cache.get(url)
                }

                override fun putBitmap(url: String, bitmap: Bitmap) {
                    cache.put(url, bitmap)
                }
            })
    }

    @SuppressLint("ResourceAsColor")
    fun loadImage(imageHolder : NetworkImageView, url : String) {

        if (url == "") {
            imageHolder.setImageResource(android.R.drawable.ic_dialog_alert)
            return
        }
        imageLoader.get(url, ImageLoader.getImageListener(imageHolder,
            android.R.drawable.ic_menu_report_image, android.R.drawable.ic_dialog_alert))
        imageHolder.setImageUrl(url, imageLoader)

    }
}