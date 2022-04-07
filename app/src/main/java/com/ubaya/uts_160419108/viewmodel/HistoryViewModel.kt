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
import com.ubaya.uts_160419108.model.Donation
import com.ubaya.uts_160419108.model.History
import com.ubaya.uts_160419108.util.GlobalData
import org.json.JSONObject

class HistoryViewModel(application: Application): AndroidViewModel(application) {
    val historyLD = MutableLiveData<List<History>>()
    val historyLoadErrorLD = MutableLiveData<Boolean>()
    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        historyLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/notgk90/6bca1da3cf649f787ac56d9abd88467b/raw/323093375d656118ab013ac73e75a356f93755c0/history.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val data = JSONObject(response).getJSONArray("history").toString()
                val sType = object : TypeToken<List<History>>() { }.type
                val result = Gson().fromJson<List<History>>(data, sType)
                historyLD.value = result
                GlobalData.globalHistory = result as ArrayList<History>

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                historyLoadErrorLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}