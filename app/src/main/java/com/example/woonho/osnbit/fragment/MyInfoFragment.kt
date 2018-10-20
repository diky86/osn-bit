package com.example.woonho.osnbit.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.woonho.osnbit.R

class MyInfoFragment : Fragment() {
    private val TAG = "MyInfoFragment"

    companion object {
        fun newInstance(): Fragment {
            MyInfoFragment().run {
                return this
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_my_info_fragment, container, false)
    }
}