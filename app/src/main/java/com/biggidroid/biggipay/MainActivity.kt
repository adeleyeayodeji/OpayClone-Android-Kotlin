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
            handleNavigationSelection(item)
        }
    }

    private fun handleNavigationSelection(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragment_container, HomePage())
                }
                true
            }

            R.id.navigation_rewards -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragment_container, RewardsPage())
                }
                true
            }

            else -> false
        }
    }
}