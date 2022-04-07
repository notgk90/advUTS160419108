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
import com.ubaya.uts_160419108.model.Faq
import com.ubaya.uts_160419108.util.GlobalData
import org.json.JSONObject

class FaqViewModel(application: Application): AndroidViewModel(application) {
    val faqLD = MutableLiveData<List<Faq>>()
    val faqLoadErrorLD = MutableLiveData<Boolean>()
    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        faqLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/notgk90/3101f6f3b183660462a0a5630735061e/raw/bcfa4d76c46c010270b8d91008db0cb5eca7208e/faq.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val data = JSONObject(response).getJSONArray("faq").toString()
                val sType = object : TypeToken<List<Faq>>() { }.type
                val result = Gson().fromJson<List<Faq>>(data, sType)
                faqLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                faqLoadErrorLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}