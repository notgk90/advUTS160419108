package com.ubaya.uts_160419108.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.uts_160419108.model.Donation
import com.ubaya.uts_160419108.model.History
import com.ubaya.uts_160419108.util.GlobalData

class HistoryDetailViewModel(application: Application): AndroidViewModel(application) {
    val historyLD = MutableLiveData<History>()
    fun getIdHistory(historyID:String){
        for(i in GlobalData.globalHistory){
            if(i.id == historyID){
                historyLD.value = i
            }
        }
    }
}