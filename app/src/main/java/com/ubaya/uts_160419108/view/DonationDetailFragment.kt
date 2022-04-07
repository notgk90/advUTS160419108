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
import kotlinx.android.synthetic.main.fragment_donation_detail.*

class DonationDetailFragment : Fragment() {
    private lateinit var donationDetail: DonationDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donation_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        donationDetail = ViewModelProvider(this).get(DonationDetailViewModel::class.java)
        donationDetail.getIdDonation(DonationDetailFragmentArgs.fromBundle(requireArguments()).idDonation)

        ObserveDetailViewModel()
    }

    fun ObserveDetailViewModel(){
        donationDetail.donationLD.observe(viewLifecycleOwner, Observer {
            txtDetailJudul.setText(it.name)
            txtDetailDana.setText(it.money)
            txtDetailDesc.setText(it.description)
            txtDetailTarget.setText(it.target)
            txtDetailFundraiser.setText(it.fundraiser)
            imgDetailDonasi.loadImage(it.photo.toString())
        })
    }
}