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

class TraderFragment : Fragment() {
    private val TAG = "TraderFragment"

    companion object {
        fun newInstance(): Fragment {
            TraderFragment().run {
                return this
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_trader_fragment, container, false)
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = ArrayList<DataSet>()

        for (i in 0 until 3) {
            DataSet().run {
                coinNameKor = "리플"
                coinNameEng = "XRP/KRW"
                price = "505"
                percent = "6.68%"
                tradeTotalCnt = "118.515백만"
                list.add(this)
            }
        }

        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        val adapter = TraderAdapter(context)
        if (list != null) {
            adapter.setData(list)
        }
        recyclerView.adapter = adapter
        val lm = LinearLayoutManager(context)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }

    private inner class TraderAdapter(val context: Context) : RecyclerView.Adapter<TraderAdapter.ViewHolder>() {

        private var dataList: ArrayList<DataSet>? = null

        fun setData(list: ArrayList<DataSet>) {
            dataList = list
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.trader_list_item, parent, false))
        }

        override fun getItemCount(): Int {
            Log.d(TAG, "woonho size = ${dataList?.size}")
            return dataList?.size ?: 0
        }

        override fun onBindViewHolder(vh: ViewHolder, position: Int) {

            vh.tvCoinNameEng.text = dataList!![0].coinNameEng
            vh.tvCoinNameKor.text = dataList!![0].coinNameKor
            vh.tvPrice.text = dataList!![0].price
            vh.tvPercent.text = dataList!![0].percent
            vh.tvTradeTotalCnt.text = dataList!![0].tradeTotalCnt

        }

        private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvCoinNameKor = itemView.findViewById(R.id.tv_coin_name_kor) as TextView
            val tvCoinNameEng = itemView.findViewById(R.id.tv_coin_name_eng) as TextView
            val tvPrice = itemView.findViewById(R.id.tv_price) as TextView
            val tvPercent = itemView.findViewById(R.id.tv_percent) as TextView
            val tvTradeTotalCnt = itemView.findViewById(R.id.tv_trade_total_cnt) as TextView
        }
    }

    private class DataSet {
        var coinNameKor: String = ""
        var coinNameEng: String = ""
        var price: String = ""
        var percent: String = ""
        var tradeTotalCnt: String = ""
    }
}