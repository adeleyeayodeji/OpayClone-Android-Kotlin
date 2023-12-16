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
import com.biggidroid.biggipay.databinding.FragmentHomeInnerPageBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeInnerPage.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeInnerPage : Fragment() {
    private var _binding: FragmentHomeInnerPageBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //init view binding
        _binding = FragmentHomeInnerPageBinding.inflate(inflater, container, false)
        //set content view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homePageButton.setOnClickListener {
            goToEarnPage(it)
        }
    }

    fun goToEarnPage(view: View) {
        //goto earn page with animation from bottom to top
        Log.d("HomePage", "goToEarnPage: ")
        val earnPage = EarnPage()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.replace(R.id.fragment_container, earnPage)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}