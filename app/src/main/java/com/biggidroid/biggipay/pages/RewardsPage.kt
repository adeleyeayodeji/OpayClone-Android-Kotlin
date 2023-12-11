package com.biggidroid.biggipay.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.biggidroid.biggipay.R

/**
 * A simple [Fragment] subclass.
 * Use the [RewardsPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class RewardsPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rewards_page, container, false)
    }
}