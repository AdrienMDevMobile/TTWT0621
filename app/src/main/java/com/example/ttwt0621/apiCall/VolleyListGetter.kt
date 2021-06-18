package com.example.ttwt0621.apiCall

import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ttwt0621.data.ImagePreview
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class VolleyListGetter(private val queue: RequestQueue, private val gson: Gson) : IListGetter {
    override suspend fun getListPreview(): ArrayList<ImagePreview> {

        val URL :String = URLs.BASE_URL
        val typeImagePreviewList = object: TypeToken<ArrayList<ImagePreview>>() {}.type

        Log.i("url", URL)

        return suspendCancellableCoroutine  { continuation ->

            try {

                val success = Response.Listener<JSONObject> { response ->
                    if (continuation.isActive) {
                        Log.i("response", response.toString())
                        continuation.resume(gson.fromJson(response.toString(), typeImagePreviewList ))
                    }
                }

                // Error Listner
                val error = Response.ErrorListener {
                    if (continuation.isActive) {
                        continuation.resume(ArrayList<ImagePreview>())
                    }
                }


                val jsonObjectRequest =
                    JsonObjectRequest(Request.Method.GET, URL, null, success, error)

                queue.add(jsonObjectRequest)
            } catch (e: Exception) {
                e.printStackTrace()
                        continuation.resumeWithException(e)
            }
        }
    }
}
