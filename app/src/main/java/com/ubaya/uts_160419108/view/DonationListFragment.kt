package com.ubaya.uts_160419108.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.viewmodel.DonationViewModel
import kotlinx.android.synthetic.main.fragment_donation_list.*

class DonationListFragment : Fragment() {

    private lateinit var viewModel: DonationViewModel
    private val donationListAdapter  = DonationListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donation_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DonationViewModel::class.java)
        viewModel.refresh()

        observeViewModel()
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = donationListAdapter
    }

    fun observeViewModel(){
        viewModel.donationsLD.observe(viewLifecycleOwner, Observer {
            donationListAdapter.updateDonationList(it)
        })
    }
}