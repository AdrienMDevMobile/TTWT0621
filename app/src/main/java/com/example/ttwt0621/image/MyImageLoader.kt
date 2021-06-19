package com.example.ttwt0621.image

import android.annotation.SuppressLint
import android.graphics.Bitmap
import com.android.volley.toolbox.ImageLoader
import androidx.collection.LruCache
import com.android.volley.RequestQueue
import com.android.volley.toolbox.NetworkImageView

class MyImageLoader (private val requestQueue: RequestQueue) {
    private val imageLoader: ImageLoader

    init {
        //requestQueue = getRequestQueue()
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
            //Toast.makeText(this, "Please enter a URL", Toast.LENGTH_LONG).show()
            imageHolder.setImageResource(android.R.drawable.ic_dialog_alert)
            return
        }
        //val imageLoader = context?.let { it1 -> ImageVolleyLoader.getInstance(it1)?.imageLoader }
        imageLoader.get(url, ImageLoader.getImageListener(imageHolder,
            android.R.drawable.ic_menu_report_image, android.R.drawable.ic_dialog_alert))
        imageHolder.setImageUrl(url, imageLoader)

    }
}