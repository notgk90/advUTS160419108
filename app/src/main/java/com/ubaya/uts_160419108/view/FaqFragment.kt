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
import com.ubaya.uts_160419108.viewmodel.FaqViewModel
import com.ubaya.uts_160419108.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_donation_list.*

class FaqFragment : Fragment() {
    private lateinit var viewModel: FaqViewModel
    private val faqListAdapter  = FaqAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_faq, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FaqViewModel::class.java)
        viewModel.refresh()

        observeViewModel()
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = faqListAdapter
    }

    fun observeViewModel(){
        viewModel.faqLD.observe(viewLifecycleOwner, Observer {
            faqListAdapter.updateFeedList(it)
        })
    }
}