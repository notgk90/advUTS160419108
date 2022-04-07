package com.ubaya.uts_160419108.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.model.Feed
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedAdapter(val feedList:ArrayList<Feed>):
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    class FeedViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.feed_item, parent, false)

        return FeedAdapter.FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.view.txtFeedName.text = feedList[position].nama
        holder.view.txtFeedDate.text = feedList[position].tanggal
        holder.view.txtFeedFund.text = feedList[position].tujuan
        holder.view.txtFeedMessage.text = feedList[position].pesan
        holder.view.txtFeedMoney.text = feedList[position].nominal
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    fun updateFeedList(newFeedList: List<Feed>) {
        feedList.clear()
        feedList.addAll(newFeedList)
        notifyDataSetChanged()
    }
}