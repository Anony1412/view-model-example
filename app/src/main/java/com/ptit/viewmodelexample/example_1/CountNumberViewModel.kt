package com.ptit.viewmodelexample.example_1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountNumberViewModel : ViewModel() {

    var teamAScore = MutableLiveData<Int>()
    var teamBScore = MutableLiveData<Int>()

    fun increasePointTeamA(point: Int) {
        Log.d("TAG", "${teamAScore.value}")
        teamAScore.value = teamAScore.value?.plus(point)
    }

    fun increasePointTeamB(point: Int) {
        Log.d("TAG", "${teamAScore.value}")
        teamBScore.value = teamBScore.value?.plus(point)
    }

    init {
        teamAScore.value = 0
        teamBScore.value = 0
    }
}
