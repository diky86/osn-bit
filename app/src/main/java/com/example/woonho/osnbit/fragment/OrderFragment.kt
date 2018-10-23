package com.example.woonho.osnbit.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class OrderFragment : Fragment() {
    private val TAG = "OrderFragment"
    private val ARG_PRICE = "argPrice"

    private var currentPrice: String = ""

    companion object {
        fun newInstance(currentPrice: String): Fragment {
            OrderFragment().run {

                Bundle().let { arg ->
                    arg.putString(ARG_PRICE, currentPrice)
                    arguments = arg
                }
                return this
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        if (outState != null) {
            outState.putString(ARG_PRICE, currentPrice)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }



}