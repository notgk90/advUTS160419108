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
import com.ubaya.uts_160419108.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_donation_detail.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var profileVM: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileVM = ViewModelProvider(this).get(ProfileViewModel::class.java)

        ObserveDetailViewModel()
    }

    fun ObserveDetailViewModel(){
        profileVM.profileLD.observe(viewLifecycleOwner, Observer {
            txtProfileName.setText(it.name)
            txtProfileEmail.setText(it.email)
            txtProfileDob.setText(it.dob)
        })
    }
}