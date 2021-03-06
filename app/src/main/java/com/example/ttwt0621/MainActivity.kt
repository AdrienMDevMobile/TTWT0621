package com.example.ttwt0621

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.ttwt0621.apiCall.IListGetter
import com.example.ttwt0621.apiCall.VolleyListGetter
import com.example.ttwt0621.data.ImagePreview
import com.example.ttwt0621.image.MyImageLoader
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by viewModels()

        val searchText = findViewById<EditText>(R.id.et_search)


        recyclerView = findViewById<RecyclerView>(R.id.rv_preview_list).apply {
            this.setHasFixedSize(true)
        }

        val searchButton = findViewById<Button>(R.id.btnSearch)
        searchButton.setOnClickListener { view ->
            viewModel.startSearch(searchText.text.toString(), MyApplication.instance.listGetter)
        }

        viewModel.getListPreview().observe(this, {
            val viewAdapter = ImagePreviewAdapter(it)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = viewAdapter
        })

        //Chercher comment bien faire le onclicklistener. Tout ce travail devrait etre fait par la VM. Pas l'activité.
        findViewById<Button>(R.id.btnGo).setOnClickListener { view ->
            val intent = Intent(this, ShowPicturesActivity::class.java)
            intent.putStringArrayListExtra(ShowPicturesActivity.LIST_IMAGE_EXTRA, viewModel.getCheckedURLList())
            this.startActivity(intent)
        }

    }

}