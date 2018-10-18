package com.example.woonho.osnbit.fragment

import android.annotation.TargetApi
import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.R

class InvestHistoryFragment : Fragment() {
    private val TAG = "InvestHistoryFragment"

    companion object {
        fun newInstance(): Fragment {
            InvestHistoryFragment().run {
                return this
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_invest_history_fragment, container, false)
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = ArrayList<DataSet>()

        DataSet().run {
            coinNameKor = "에이다"
            coinNameEng = "ADA"
            evaluationPlusMinus = "-392,657"
            revenuePercent = "-71.85%"
            color = 0
            ownCnt = "1,772.00000000"
            evaluationPrice = "153,809"
            buyingAvgPrice = "308"
            buyingPrice = "546,468"
            list.add(this)
        }

        DataSet().run {
            coinNameKor = "비트코인"
            coinNameEng = "BTC"
            evaluationPlusMinus = "13,392,657"
            revenuePercent = "1.85%"
            color = 1
            ownCnt = "234"
            evaluationPrice = "113,153,809"
            buyingAvgPrice = "12,000,211"
            buyingPrice = "123,546,468"
            list.add(this)
        }

        DataSet().run {
            coinNameKor = "이오스"
            coinNameEng = "EOS"
            evaluationPlusMinus = "-1,232,657"
            revenuePercent = "-51%"
            color = 0
            ownCnt = "1,211"
            evaluationPrice = "12,133,859"
            buyingAvgPrice = "11,234,865"
            buyingPrice = "12,536,777"
            list.add(this)
        }

        DataSet().run {
            coinNameKor = "트론"
            coinNameEng = "TRX"
            evaluationPlusMinus = "-657"
            revenuePercent = "-0.85%"
            color = 0
            ownCnt = "1,772,234,523"
            evaluationPrice = "1,154,812"
            buyingAvgPrice = "27.70"
            buyingPrice = "546,234,134"
            list.add(this)
        }

        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        val adapter = InvestHistoryAdapter(context)

        adapter.setData(list)
        recyclerView.adapter = adapter
        val lm = LinearLayoutManager(context)

        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }

    private inner class InvestHistoryAdapter(val context: Context) : RecyclerView.Adapter<InvestHistoryAdapter.ItemViewHolder>() {

        private var dataList: ArrayList<DataSet>? = null
        fun setData(list: ArrayList<DataSet>) {
            dataList = list
        }

        override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
            return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.invest_history_list_item, parent, false))
        }

        override fun getItemCount(): Int {
            return dataList?.size ?: 0
        }

        @TargetApi(Build.VERSION_CODES.M)
        override fun onBindViewHolder(vh: ItemViewHolder, position: Int) {

            vh.run {
                tvCoinNameKor.text = dataList!![position].coinNameKor
                tvCoinNameEng.text = dataList!![position].coinNameEng
                tvValuationPercent.text = dataList!![position].evaluationPlusMinus
                tvRevenuePercent.text = dataList!![position].revenuePercent
                if (dataList!![position].color == 0) {
                    tvValuationPercent.setTextColor(context.getColor(R.color.blue))
                    tvRevenuePercent.setTextColor(context.getColor(R.color.blue))
                } else {
                    tvValuationPercent.setTextColor(context.getColor(R.color.red))
                    tvRevenuePercent.setTextColor(context.getColor(R.color.red))
                }
                tvCoinNameEng2.text = dataList!![position].coinNameEng
                tvCoinCnt.text = dataList!![position].ownCnt
                tvValuationPrice.text = dataList!![position].evaluationPrice
                tvBuyingAvgPrice.text = dataList!![position].buyingAvgPrice
                tvBuyingPrice.text = dataList!![position].buyingPrice
            }
        }

        private inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvCoinNameKor = itemView.findViewById(R.id.tv_coin_name) as TextView
            val tvCoinNameEng = itemView.findViewById(R.id.tv_coin_name_eng) as TextView
            val tvValuationPercent = itemView.findViewById(R.id.tv_valuation_percent) as TextView
            val tvRevenuePercent = itemView.findViewById(R.id.tv_revenue_percent) as TextView
            val tvCoinNameEng2 = itemView.findViewById(R.id.tv_coin_name_eng2) as TextView
            val tvCoinCnt = itemView.findViewById(R.id.tv_coin_cnt) as TextView
            val tvValuationPrice = itemView.findViewById(R.id.tv_valuation_price) as TextView
            val tvBuyingAvgPrice = itemView.findViewById(R.id.tv_buying_average_price) as TextView
            val tvBuyingPrice = itemView.findViewById(R.id.tv_buying_price) as TextView
        }
    }

    private class DataSet {
        var coinNameKor: String = ""
        var coinNameEng: String = ""
        var evaluationPlusMinus: String = ""
        var color = 0
        var revenuePercent: String = ""
        var ownCnt: String = ""
        var evaluationPrice: String = ""
        var buyingAvgPrice: String = ""
        var buyingPrice: String = ""
    }
}