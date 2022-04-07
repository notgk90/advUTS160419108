package com.ubaya.uts_160419108.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.model.Donation
import com.ubaya.uts_160419108.util.loadImage
import kotlinx.android.synthetic.main.donation_list_item.view.*

class DonationListAdapter(val donationList:ArrayList<Donation>):
    RecyclerView.Adapter<DonationListAdapter.DonationViewHolder>() {
    class DonationViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.donation_list_item, parent, false)

        return DonationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonationViewHolder, position: Int) {
        holder.view.txtFundraiser.text = donationList[position].fundraiser
        holder.view.txtJudul.text = donationList[position].name
        holder.view.txtDana.text = donationList[position].money
        holder.view.imgDonasi.loadImage(donationList[position].photo.toString())

        holder.view.btnDetail.setOnClickListener {
            val action = DonationListFragmentDirections.actionDetailDonationFragment(donationList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return donationList.size
    }

    fun updateDonationList(newDonationList: List<Donation>) {
        donationList.clear()
        donationList.addAll(newDonationList)
        notifyDataSetChanged()
    }

}