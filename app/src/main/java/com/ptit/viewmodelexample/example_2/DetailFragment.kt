package com.ptit.viewmodelexample.example_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ptit.viewmodelexample.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var viewModel: MasterViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initViewModel()
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel?.selectedItem?.observe(
                it,
                Observer { textItemDetail.text = it }
            )
        }
    }

    private fun initViewModel() {
        activity?.let { viewModel = ViewModelProvider(it).get(MasterViewModel::class.java) }
    }

    companion object {
        fun newInstance() = DetailFragment()
    }
}
