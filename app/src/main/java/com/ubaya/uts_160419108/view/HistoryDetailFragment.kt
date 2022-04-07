package com.ubaya.uts_160419108.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.util.loadImage
import com.ubaya.uts_160419108.viewmodel.DonationDetailViewModel
import com.ubaya.uts_160419108.viewmodel.HistoryDetailViewModel
import kotlinx.android.synthetic.main.fragment_donation_detail.*
import kotlinx.android.synthetic.main.fragment_history_detail.*

class HistoryDetailFragment : Fragment() {
    private lateinit var historyDetail: HistoryDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyDetail = ViewModelProvider(this).get(HistoryDetailViewModel::class.java)
        historyDetail.getIdHistory(HistoryDetailFragmentArgs.fromBundle(requireArguments()).idHistory)

        ObserveDetailViewModel()
    }

    fun ObserveDetailViewModel(){
        historyDetail.historyLD.observe(viewLifecycleOwner, Observer {
            txtHistDetailDate.setText(it.tanggal)
            txtHistDetailTime.setText(it.time)
            txtHistDetailMoney.setText(it.nominal)
            txtHistDetailStatus.setText(it.status)
            txtHistDetailVia.setText(it.via)
            txtHistDetailFund.setText(it.tujuan)
        })
    }
}