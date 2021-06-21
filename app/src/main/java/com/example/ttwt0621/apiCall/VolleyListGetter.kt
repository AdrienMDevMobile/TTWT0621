package com.example.ttwt0621.apiCall

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ttwt0621.data.ImagePreview
import com.example.ttwt0621.data.PreviewList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class VolleyListGetter(private val queue: RequestQueue, private val gson: Gson) : IListGetter {
    override suspend fun getListPreview(textSearch:String): PreviewList {

        val URL :String = URLs.BASE_URL + URLs.SEARCH_FIELD + textSearch
        val typePreviewList = object:TypeToken<PreviewList>(){}.type

        return suspendCancellableCoroutine  { continuation ->

            try {

                val success = Response.Listener<JSONObject> { response ->
                    if (continuation.isActive) {
                        continuation.resume(gson.fromJson(response.toString(), typePreviewList ))
                    }
                }

                val error = Response.ErrorListener {
                    if (continuation.isActive) {
                        continuation.resume(PreviewList(0,0, ArrayList()))
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
