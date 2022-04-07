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
import com.ubaya.uts_160419108.model.Profile
import org.json.JSONObject

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    val profileLD = MutableLiveData<Profile>()
    private val TAG = "volleyTag"

    fun fetch(){
        val profile1 = Profile("I GD. Gilang Kusuma", "gilangkusuma90@gmail.com", "10 Agustus 2000")
        profileLD.value = profile1
    }

}