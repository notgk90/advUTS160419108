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

class DonationDetailViewModel(application: Application):AndroidViewModel(application) {
    val donationLD = MutableLiveData<Donation>()
    fun getIdDonation(donationID:String){
        for(i in GlobalData.globalDonation){
            if(i.id == donationID){
                donationLD.value = i
            }
        }
    }
}