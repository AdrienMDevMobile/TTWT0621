package com.example.ttwt0621

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.ttwt0621.image.MyImageLoader


class ShowPicturesActivity : AppCompatActivity() {
    companion object{
        val LIST_IMAGE_EXTRA = "com.example.ttwt0621.LIST_IMAGE_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_pictures)

        val requestQueue = Volley.newRequestQueue(this)
        val myImageLoader = MyImageLoader(requestQueue)

        val intent = getIntent()
        val listImages = intent.getStringArrayListExtra(LIST_IMAGE_EXTRA)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_full_image).apply {
            this.setHasFixedSize(true)
        }

        if (listImages != null) {
            val viewAdapter = ImageFullAdapter(listImages, myImageLoader)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = viewAdapter

            for(a in listImages){
                Log.i("imageaafficher", a)
            }
        }
    }
}