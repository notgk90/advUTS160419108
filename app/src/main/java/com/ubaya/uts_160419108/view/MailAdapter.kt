package com.ubaya.uts_160419108.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_160419108.R
import com.ubaya.uts_160419108.model.Mail
import kotlinx.android.synthetic.main.mail_item.view.*

class MailAdapter(val mailList:ArrayList<Mail>):
    RecyclerView.Adapter<MailAdapter.MailViewHolder>() {
    class MailViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.mail_item, parent, false)

        return MailAdapter.MailViewHolder(view)
    }

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        holder.view.txtMailDate.text = mailList[position].tanggal
        holder.view.txtMailMessage.text = mailList[position].pesan
        holder.view.txtMailSender.text = mailList[position].pengirim
    }

    override fun getItemCount(): Int {
        return mailList.size
    }

    fun updateMailList(newMailList: List<Mail>) {
        mailList.clear()
        mailList.addAll(newMailList)
        notifyDataSetChanged()
    }
}