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
import com.ubaya.uts_160419108.model.Mail
import org.json.JSONObject

class MailViewModel(application: Application): AndroidViewModel(application) {
    val mailLD = MutableLiveData<List<Mail>>()
    val mailLoadErrorLD = MutableLiveData<Boolean>()
    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        mailLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/notgk90/7983e3501f9571cd413d2116455f63c4/raw/a56098532af1b3949def80b918500e773e0b5564/mail.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val data = JSONObject(response).getJSONArray("mail").toString()
                val sType = object : TypeToken<List<Mail>>() { }.type
                val result = Gson().fromJson<List<Mail>>(data, sType)
                mailLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                mailLoadErrorLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}