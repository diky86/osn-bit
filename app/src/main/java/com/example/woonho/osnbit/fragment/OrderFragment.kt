package com.example.woonho.osnbit.fragment

import android.annotation.TargetApi
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.R
import java.io.Serializable

class OrderFragment : Fragment() {
    private val TAG = "OrderFragment"
    private val ARG_TITLE = "argTitle"
    private val ARG_DATA = "argData"

    private var coinTitle: String = ""
    private lateinit var data: CoinData

    companion object {
        fun newInstance(coinData: CoinData, title: String): Fragment {
            OrderFragment().run {
                Bundle().let { arg ->
                    arg.putSerializable(ARG_DATA, coinData)
                    arg.putString(ARG_TITLE, title)
                    arguments = arg
                }
                data = coinData
                coinTitle = title
                return this
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable(ARG_DATA, data)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.sub_order_fragment, container, false)
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view.findViewById(R.id.tv_title_bar) as TextView).apply {
            text = coinTitle
        }

        (view.findViewById(R.id.tv_coin_current_price) as TextView).apply {
            text = data.coinPirce
            if (data.coinColor == 0) {
                setTextColor(context.getColor(R.color.blue))
            } else {
                setTextColor(context.getColor(R.color.red))
            }
        }

        (view.findViewById(R.id.tv_coin_price) as TextView).apply {
            text = data.coinPirce
        }

        (view.findViewById(R.id.tv_coin_percent) as TextView).apply {
            text = data.coinPercent
            if (data.coinColor == 0) {
                setTextColor(context.getColor(R.color.blue))
            } else {
                setTextColor(context.getColor(R.color.red))
            }
        }

        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        val orderAdapter = OrderAdapter(context)
        val lm = LinearLayoutManager(context)

        val price = data.coinPirce.replace(",", "").toLong()
        val percent = data.coinPercent
                .replace(".", "")
                .substring(0, data.coinPercent.length.minus(2)).toLong()

        val dataList = setDataList(price, percent)

        orderAdapter.setData(dataList)
        recyclerView.adapter = orderAdapter
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }

    private fun setDataList(price: Long, percent: Long): ArrayList<CoinData> {
        val list = ArrayList<CoinData>()

        val priceStandard: Long
        val percentStand: Long

        when {
            price < 1000 -> {
                priceStandard = 1
                percentStand = 5
            }
            price < 10000 -> {
                priceStandard = 10
                percentStand = 4
            }
            price < 100000 -> {
                priceStandard = 100
                percentStand = 2
            }
            else -> {
                priceStandard = 1000
                percentStand = 1
            }
        }

        for (i in 0 until 10) {
            CoinData().run {
                coinPirce = String.format("%,d", (price + priceStandard * (10 - i)))
                coinPercent = setPercentText((percent + percentStand * (10 - i)).toString())
                coinColor = 1
                list.add(this)
            }
        }

        CoinData().run {
            coinPirce = String.format("%,d", price)
            coinPercent = setPercentText(percent.toString())
            coinColor = 2
            list.add(this)
        }

        for (i in 0 until 10) {
            CoinData().run {
                coinPirce = String.format("%,d", (price - priceStandard * (i + 1)))
                coinPercent = setPercentText((percent - percentStand * (i + 1)).toString())
                coinColor = 0
                list.add(this)
            }
        }
        return list
    }

    private fun setPercentText(number: String): String {
        val size = number.length
        return number.substring(0, size.minus(2)) +
                "." + number.substring(size.minus(2), size) + "%"
    }

    private inner class OrderAdapter(context: Context): RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

        private var dataList = ArrayList<CoinData>()

        fun setData(list: ArrayList<CoinData>) {
            dataList = list
        }

        @TargetApi(Build.VERSION_CODES.M)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.order_price_item, parent, false))
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        @TargetApi(Build.VERSION_CODES.M)
        override fun onBindViewHolder(vh: ViewHolder, position: Int) {
            vh.tvPrice.text = dataList[position].coinPirce
            vh.tvPercent.text = dataList[position].coinPercent

            if (dataList[position].coinColor == 0) {
                vh.tvPrice.setTextColor(context.getColor(R.color.blue))
                vh.tvPercent.setTextColor(context.getColor(R.color.blue))
                vh.priceContainer.setBackgroundColor(context.getColor(R.color.blue_10))
                vh.percentContainer.setBackgroundColor(context.getColor(R.color.blue_10))

            } else if (dataList[position].coinColor == 1) {
                vh.tvPrice.setTextColor(context.getColor(R.color.red))
                vh.tvPercent.setTextColor(context.getColor(R.color.red))
                vh.priceContainer.setBackgroundColor(context.getColor(R.color.red_10))
                vh.percentContainer.setBackgroundColor(context.getColor(R.color.red_10))

            } else {
                vh.tvPrice.setTextColor(context.getColor(R.color.black))
                vh.tvPercent.setTextColor(context.getColor(R.color.black))
                vh.priceContainer.setBackgroundColor(context.getColor(R.color.black_10))
                vh.percentContainer.setBackgroundColor(context.getColor(R.color.black_10))
            }
        }

        private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val priceContainer = itemView.findViewById(R.id.price_container) as View
            val percentContainer = itemView.findViewById(R.id.percent_container) as View
            val tvPrice = itemView.findViewById(R.id.tv_price) as TextView
            val tvPercent = itemView.findViewById(R.id.tv_percent) as TextView
        }
    }

    class CoinData : Serializable {
        var coinColor: Int = 0
        var coinPirce: String = ""
        var coinPercent: String = ""
    }
}