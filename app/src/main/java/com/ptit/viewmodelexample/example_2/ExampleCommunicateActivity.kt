package com.ptit.viewmodelexample.example_2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ptit.viewmodelexample.R

class ExampleCommunicateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sencond)

        initView()
    }

    private fun initView() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameMaster, MasterFragment.newInstance())
            .add(R.id.frameDetail, DetailFragment.newInstance())
            .commit()
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, ExampleCommunicateActivity::class.java)
    }
}
