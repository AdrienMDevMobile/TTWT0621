package com.example.ttwt0621

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.ttwt0621.apiCall.IListGetter
import com.example.ttwt0621.apiCall.VolleyListGetter
import com.example.ttwt0621.data.ImagePreview
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    //private val timerViewModel: MainViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    //private lateinit var viewAdapter: ImagePreviewAdapter

    //private var coroutineScope = this.ActivityScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by viewModels()

        //A faire si plus de temps : passer le listGetter dans le ViewModel pour réduire dépendance
        val listGetter : IListGetter = VolleyListGetter(Volley.newRequestQueue(this), Gson())

        val searchText = findViewById<EditText>(R.id.et_search)

        recyclerView = findViewById<RecyclerView>(R.id.rv_preview_list).apply {
            this.setHasFixedSize(true)
        }

        /*
        val previewImageLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = previewImageLayoutManager*/

        val searchButton = findViewById<Button>(R.id.btnSearch)
        searchButton.setOnClickListener { view ->
            //Utiliser scope autre que GlobalScope
            viewModel.startSearch(searchText.text.toString(), listGetter)
        }

        viewModel.getListPreview().observe(this, {
            val viewAdapter = ImagePreviewAdapter(it)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = viewAdapter
        })


    }

}