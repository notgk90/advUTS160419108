package com.ubaya.uts_160419108.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.model.Faq
import com.ubaya.uts_160419108.model.Feed
import kotlinx.android.synthetic.main.faq_item.view.*
import kotlinx.android.synthetic.main.feed_item.view.*

class FaqAdapter(val faqList:ArrayList<Faq>):
    RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {
    class FaqViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.faq_item, parent, false)

        return FaqAdapter.FaqViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.view.txtQuestion.text = faqList[position].question
        holder.view.txtAnswer.text = faqList[position].answer
    }

    override fun getItemCount(): Int {
        return faqList.size
    }

    fun updateFeedList(newFaqList: List<Faq>) {
        faqList.clear()
        faqList.addAll(newFaqList)
        notifyDataSetChanged()
    }

}