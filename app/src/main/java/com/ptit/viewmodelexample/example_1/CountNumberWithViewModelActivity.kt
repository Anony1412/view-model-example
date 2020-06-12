package com.ptit.viewmodelexample.example_1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ptit.viewmodelexample.R
import kotlinx.android.synthetic.main.activity_count.*

class CountNumberWithViewModelActivity : AppCompatActivity(), View.OnClickListener {

    private var viewModel: CountNumberViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        initViewModel()
        registerLiveDataListener()
        initListener()
    }

    private fun initListener() {
        buttonPlusA.setOnClickListener(this)
        buttonPlusB.setOnClickListener(this)
    }

    private fun registerLiveDataListener() {

        viewModel?.teamAScore?.observe(this,
            Observer { t -> textPointA.text = t.toString() })

        viewModel?.teamBScore?.observe(this,
            Observer { t -> textPointB.text = t.toString() })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CountNumberViewModel::class.java)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonPlusA -> increasePointTeamA()
            R.id.buttonPlusB -> increasePointTeamB()
        }
    }

    private fun increasePointTeamA() {
        viewModel?.increasePointTeamA(3)
    }

    private fun increasePointTeamB() {
        viewModel?.increasePointTeamB(3)
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, CountNumberWithViewModelActivity::class.java)
    }
}
