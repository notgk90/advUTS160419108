package com.ubaya.uts_160419108.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.uts_160419108.model.Feed
import org.json.JSONObject

class FeedViewModel(application: Application): AndroidViewModel(application)  {
    val feedLD = MutableLiveData<List<Feed>>()
    val feedLoadErrorLD = MutableLiveData<Boolean>()
    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        feedLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/notgk90/d3b00e7b275c83413aaf06c8d27821b8/raw/f928a140fd8648c3d593b4eea9793eb59eb857a9/feed.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val data = JSONObject(response).getJSONArray("feeds").toString()
                val sType = object : TypeToken<List<Feed>>() { }.type
                val result = Gson().fromJson<List<Feed>>(data, sType)
                feedLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                feedLoadErrorLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}