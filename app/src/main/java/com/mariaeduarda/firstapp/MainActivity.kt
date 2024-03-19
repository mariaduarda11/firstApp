package com.mariaeduarda.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.mariaeduarda.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //:private var _bindingLinear: LinearBinding? = null
    //:private  val bindingLinear: LinearBinding get() = _bindingLinear!!
    private var _binding: ActivityMainBinding? = null
    private  val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//




        }
    }
