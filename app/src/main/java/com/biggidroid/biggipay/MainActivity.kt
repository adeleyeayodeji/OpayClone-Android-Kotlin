package com.biggidroid.biggipay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.biggidroid.biggipay.databinding.ActivityMainBinding
import com.biggidroid.biggipay.pages.HomePage
import com.biggidroid.biggipay.pages.RewardsPage

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //set content view
        setContentView(binding.root)

        //bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            bottomNavChange(item)
        }
    }

    private fun bottomNavChange(item: MenuItem): Boolean {
        when (binding.bottomNavigation.selectedItemId) {
            R.id.navigation_home -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, HomePage())
                }
            } //end of home
            R.id.navigation_rewards -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, RewardsPage())
                }
            } //end of wallet
        }
        return true

    }
}