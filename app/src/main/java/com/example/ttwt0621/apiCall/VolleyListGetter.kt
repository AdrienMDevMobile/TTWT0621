package com.example.ttwt0621.apiCall

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ttwt0621.data.ImagePreview
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class VolleyListGetter @Inject constructor(private val queue: RequestQueue, private val gson: Gson) : IListGetter {
    override suspend fun getListPreview(): ArrayList<ImagePreview> {

        val URL :String = URLs.BASE_URL
        val typeImagePreviewList = object: TypeToken<ArrayList<ImagePreview>>() {}.type

        return suspendCoroutine { continuation ->
            try {
                val success = Response.Listener<JSONObject> { response ->
                    continuation.resume(gson.fromJson(response.toString(), typeImagePreviewList ))
                }
                val jsonObjectRequest =
                    JsonObjectRequest(Request.Method.GET, URL, null, success, error("Error"))

                queue.add(jsonObjectRequest)
            } catch (e: Exception) {
                e.printStackTrace()
                        continuation.resumeWithException(e)
            }
        }
    }
}
