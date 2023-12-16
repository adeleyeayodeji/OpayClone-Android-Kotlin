package com.biggidroid.biggipay.pages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.biggidroid.biggipay.R
import com.biggidroid.biggipay.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
    private var _binding: FragmentHomePageBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init home inner page
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_home, HomeInnerPage())
        }

        //bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            handleNavigationSelection(item)
        }
    }

    private fun handleNavigationSelection(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_home -> {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragment_container_home, HomeInnerPage())
                }
                true
            }

            R.id.navigation_rewards -> {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragment_container_home, RewardsPage())
                }
                true
            }

            else -> false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}