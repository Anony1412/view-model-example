package com.ptit.viewmodelexample.example_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MasterViewModel: ViewModel() {

    var selectedItem = MutableLiveData<String>()
    val data = MutableLiveData<List<String>>()

    init {
        initData()
    }

    private fun initData() {
        data.value = mutableListOf<String>().apply {
            add("hihi")
            add("haha")
            add("asdfa")
            add("sdfsdf")
            add("dfsdf")
            add("hihsdfsdfi")
            add("htht")
        }
    }
}
