package com.example.ttwt0621

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.android.volley.toolbox.Volley
import com.example.ttwt0621.apiCall.IListGetter
import com.example.ttwt0621.apiCall.VolleyListGetter
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //private val timerViewModel: MainViewModel by viewModels()

    //private var coroutineScope = this.ActivityScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listGetter : IListGetter = VolleyListGetter(Volley.newRequestQueue(this), Gson())

        GlobalScope.launch(Dispatchers.IO){
            val toTest = listGetter.getListPreview()
            for(a in toTest){
                Log.i("Info", a.tags)
            }
        }

    }
}