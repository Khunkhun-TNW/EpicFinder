package com.example.fibonaccifunc.activity

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.fibonaccifunc.R
import com.example.fibonaccifunc.databinding.ActivityMainBinding
import com.example.fibonaccifunc.fragment.FragmentMain

class ActivityMain : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        this.supportFragmentManager
            .beginTransaction()
            .add(R.id.functionContainer, FragmentMain())
            .commit()
    }
}