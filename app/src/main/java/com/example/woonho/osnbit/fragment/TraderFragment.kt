package com.example.woonho.osnbit.fragment

import android.annotation.SuppressLint
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

        for (i in 0 until 2) {
            DataSet().run {
                coinNameKor = "비트코인"
                coinNameEng = "BTC/KRW"
                price = "6,729,000"
                percent = "-0.31%"
                tradeTotalCnt = "26,853백만"
                color = 0
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "이더리움"
                coinNameEng = "ETH/KRW"
                price = "233,750"
                percent = "0.64%"
                tradeTotalCnt = "12,460백만"
                color = 1
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "리플"
                coinNameEng = "XRP/KRW"
                price = "505"
                percent = "0.40%"
                tradeTotalCnt = "46,552백만"
                color = 1
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "비트코인캐시"
                coinNameEng = "BCH/KRW"
                price = "510,000"
                percent = "1.24%"
                tradeTotalCnt = "3,030백만"
                color = 1
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "트론"
                coinNameEng = "TRX/KRW"
                price = "27,30"
                percent = "-3.19%"
                tradeTotalCnt = "8,222백만"
                color = 0
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "이오스"
                coinNameEng = "EOS/KRW"
                price = "6,045"
                percent = "-1.47%"
                tradeTotalCnt = "7,783백만"
                color = 0
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "이더리움클래식"
                coinNameEng = "ETC/KRW"
                price = "10,910"
                percent = "-0.64%"
                tradeTotalCnt = "925백만"
                color = 0
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "라이트코인"
                coinNameEng = "LTC/KRW"
                price = "61,330"
                percent = "2.28%"
                tradeTotalCnt = "252백만"
                color = 1
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "에이다"
                coinNameEng = "ADA/KRW"
                price = "84,40"
                percent = "60.68%"
                tradeTotalCnt = "4,876백만"
                color = 1
                list.add(this)
            }
            DataSet().run {
                coinNameKor = "블록틱스"
                coinNameEng = "TIX/KRW"
                price = "233"
                percent = "-0.87%"
                tradeTotalCnt = "4,327백만"
                color = 0
                list.add(this)
            }
        }

        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        val adapter = TraderAdapter(context)

        adapter.setData(list)
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

        @TargetApi(Build.VERSION_CODES.M)
        @SuppressLint("ResourceAsColor")
        override fun onBindViewHolder(vh: ViewHolder, position: Int) {

            Log.d(TAG, "woonho position = $position")

            vh.tvCoinNameEng.text = dataList!![position].coinNameEng
            vh.tvCoinNameKor.text = dataList!![position].coinNameKor
            vh.tvPrice.text = dataList!![position].price
            vh.tvPercent.text = dataList!![position].percent

            if (dataList!![position].color == 0) {
                vh.tvPrice.setTextColor(context.getColor(R.color.blue))
                vh.tvPercent.setTextColor(context.getColor(R.color.blue))
            } else {
                vh.tvPrice.setTextColor(context.getColor(R.color.red))
                vh.tvPercent.setTextColor(context.getColor(R.color.red))
            }

            vh.tvTradeTotalCnt.text = dataList!![position].tradeTotalCnt

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
        var color: Int = 0
    }
}