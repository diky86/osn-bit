package com.example.woonho.osnbit.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.R
import java.io.Serializable

class OrderFragment : Fragment() {
    private val TAG = "OrderFragment"
    private val ARG_PRICE = "argPrice"
    private val ARG_TITLE = "argTitle"
    private val ARG_COLOR = "argColor"
    private val ARG_DATA = "argData"

    private var currentPrice: String = ""
    private var color: Int = 0
    private var title: String = ""

    private lateinit var data: CoinData

    companion object {
        fun newInstance(coinData: CoinData, title: String): Fragment {
            OrderFragment().run {

                Bundle().let { arg ->
                    arg.putSerializable(ARG_DATA, coinData)
                    arg.putString(ARG_TITLE, title)
//                    arg.putInt(ARG_COLOR, color)
                    arguments = arg
                }
                return this
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        title = savedInstanceState?.getString(ARG_PRICE) ?: "코인명"
        data = savedInstanceState?.getSerializable(ARG_DATA) as CoinData
//        currentPrice = savedInstanceState?.getString(ARG_TITLE) ?: "100"
//        color = savedInstanceState?.getInt(ARG_COLOR) ?: 0
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable(ARG_DATA, data)
//        outState?.putString(ARG_PRICE, currentPrice)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.sub_order_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById(R.id.tv_title_bar) as TextView).apply {
            text = title
        }



    }

    class CoinData : Serializable {
        var coinColor: Int = 0
        var coinPirce: String = ""
        var coinPercent: String = ""
    }
}