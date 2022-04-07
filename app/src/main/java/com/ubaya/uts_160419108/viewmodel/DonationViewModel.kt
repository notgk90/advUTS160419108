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
import com.ubaya.uts_160419108.util.GlobalData
import org.json.JSONObject

class DonationViewModel(application: Application):AndroidViewModel(application) {
    val donationsLD = MutableLiveData<List<Donation>>()
    val donationLoadErrorLD = MutableLiveData<Boolean>()
    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        donationLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://gist.githubusercontent.com/notgk90/79a9b08b1b4e5343f854c7e1ad3bb434/raw/0b3737f5d6c304b4e544ec2b1ef24936f91690bc/donation.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val data = JSONObject(response).getJSONArray("donations").toString()
                val sType = object : TypeToken<List<Donation>>() { }.type
                val result = Gson().fromJson<List<Donation>>(data, sType)
                donationsLD.value = result
                GlobalData.globalDonation = result as ArrayList<Donation>

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                donationLoadErrorLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}