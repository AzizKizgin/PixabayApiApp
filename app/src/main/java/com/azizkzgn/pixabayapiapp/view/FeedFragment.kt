package com.azizkzgn.pixabayapiapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azizkzgn.pixabayapiapp.R
import com.azizkzgn.pixabayapiapp.adapter.PhotoAdapter
import com.azizkzgn.pixabayapiapp.model.Photo
import com.azizkzgn.pixabayapiapp.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val adapter = PhotoAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
        viewModel.refreshData()

        feed_recycler_view.layoutManager = LinearLayoutManager(context)
        feed_recycler_view.adapter = adapter

        observeLiveData()
    }

    fun observeLiveData(){
        viewModel.datas.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.updateList(it.hits as List<Photo.Hit>)
            }
        })
    }

}