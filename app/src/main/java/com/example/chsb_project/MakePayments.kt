package com.example.chsb_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chsb_project.databinding.ActivityMakePaymentsBinding

class MakePayments : AppCompatActivity() {
    private lateinit var binding: ActivityMakePaymentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMakePaymentsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}