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
import com.ubaya.uts_160419108.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_donation_list.*

class FeedFragment : Fragment() {
    private lateinit var viewModel: FeedViewModel
    private val feedListAdapter  = FeedAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refresh()

        observeViewModel()
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = feedListAdapter
    }

    fun observeViewModel(){
        viewModel.feedLD.observe(viewLifecycleOwner, Observer {
            feedListAdapter.updateFeedList(it)
        })
    }
}