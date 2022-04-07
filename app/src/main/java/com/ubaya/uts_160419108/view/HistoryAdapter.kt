package com.ubaya.uts_160419108.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.model.Donation
import com.ubaya.uts_160419108.model.History
import com.ubaya.uts_160419108.util.loadImage
import kotlinx.android.synthetic.main.donation_list_item.view.*
import kotlinx.android.synthetic.main.history_item.view.*

class HistoryAdapter(val historyList:ArrayList<History>):
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.history_item, parent, false)

        return HistoryAdapter.HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.view.txtHistoryDate.text = historyList[position].tanggal
        holder.view.txtHistoryFund.text = historyList[position].tujuan
        holder.view.txtHistoryMoney.text = historyList[position].nominal

        holder.view.btnHistoryDetail.setOnClickListener {
            val action = HistoryFragmentDirections.actionHistoryDetailFragment(historyList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    fun updateHistoryList(newHistoryList: List<History>) {
        historyList.clear()
        historyList.addAll(newHistoryList)
        notifyDataSetChanged()
    }
}