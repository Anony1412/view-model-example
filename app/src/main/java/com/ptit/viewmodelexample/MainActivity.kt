package com.ptit.viewmodelexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ptit.viewmodelexample.example_1.CountNumberWithViewModelActivity
import com.ptit.viewmodelexample.example_2.ExampleCommunicateActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        buttonEx1Activity.setOnClickListener {
            startActivity(CountNumberWithViewModelActivity.getIntent(this))
        }

        buttonEx2Activity.setOnClickListener {
            startActivity(ExampleCommunicateActivity.getIntent(this))
        }
    }
}
