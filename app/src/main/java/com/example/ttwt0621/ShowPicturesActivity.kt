package com.example.ttwt0621

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ShowPicturesActivity : AppCompatActivity() {
    companion object{
        val LIST_IMAGE_EXTRA = "com.example.ttwt0621.LIST_IMAGE_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_pictures)

        val intent = getIntent()
        val listImages = intent.getStringArrayListExtra(LIST_IMAGE_EXTRA)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_full_image).apply {
            this.setHasFixedSize(true)
        }

        if (listImages != null) {
            val viewAdapter = ImageFullAdapter(listImages)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = viewAdapter

        }
    }
}