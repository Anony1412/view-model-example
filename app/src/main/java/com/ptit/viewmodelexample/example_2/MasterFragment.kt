package com.ptit.viewmodelexample.example_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ptit.viewmodelexample.R
import kotlinx.android.synthetic.main.fragment_master.*

class MasterFragment : Fragment() {

    private var viewModel: MasterViewModel? = null
    private val masterAdapter = MasterAdapter { onItemSelected(it) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initViewModel()
        return inflater.inflate(R.layout.fragment_master, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewItem.adapter = masterAdapter
    }

    private fun initViewModel() {
        activity?.let {
            viewModel = ViewModelProvider(it).get(MasterViewModel::class.java).apply {
                data.observe(
                    it,
                    Observer { masterAdapter.addData(it) }
                )
            }
        }
    }

    private fun onItemSelected(item: String) {
        viewModel?.selectedItem?.value = item
        Log.d("TAG", item)
    }

    companion object {
        fun newInstance() = MasterFragment()
    }
}
