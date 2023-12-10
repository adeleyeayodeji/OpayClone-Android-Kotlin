package com.biggidroid.biggipay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.biggidroid.biggipay.databinding.ActivityMainBinding
import com.biggidroid.biggipay.pages.HomePage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //set content view
        setContentView(binding.root)

        // Navigate to HomePage fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomePage())
        transaction.commit()
    }
}