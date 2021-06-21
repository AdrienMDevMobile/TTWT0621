package com.example.ttwt0621

import android.app.Application
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.ttwt0621.apiCall.IListGetter
import com.example.ttwt0621.apiCall.VolleyListGetter
import com.example.ttwt0621.image.MyImageLoader
import com.google.gson.Gson

class MyApplication : Application() {
    private var mRequestQueue: RequestQueue? = null
    private var mImageLoader: MyImageLoader? = null
    private var mListGetter : IListGetter? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val requestQueue: RequestQueue
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(applicationContext)
                Log.i("init", "requestqueue")
            }
            return mRequestQueue!!
        }
    val imageLoader: MyImageLoader
        get() {
            if (mImageLoader == null) {
                mImageLoader =  MyImageLoader(requestQueue)
                Log.i("init", "imageloader")

            }
            return mImageLoader!!
        }
    val listGetter: IListGetter
        get(){
            if(mListGetter == null){
                Log.i("init", "listGetter")
                mListGetter = VolleyListGetter(requestQueue, Gson())
            }
            return mListGetter!!
        }


    companion object {
       // val TAG = AppController::class.java.simpleName

        @get:Synchronized
        lateinit var instance: MyApplication
            private set
    }
}