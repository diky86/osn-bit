package com.example.woonho.osnbit.fragment

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.OrderActivity
import com.example.woonho.osnbit.R

class TraderFragment : Fragment() {
    private val TAG = "TraderFragment"

    private val ARG_TITLE = "argTitle"
    private val ARG_PRICE = "argPrice"
    private val ARG_COIN_COLOR = "argCoinColor"
    private val ARG_COIN_PERCENT = "argCoinPercent"

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

        DataSet().run {
            coinNameKor = "빗플"
            coinNameEng = "BFT/KRW"
            price = "175"
            percent = "7.77%"
            tradeTotalCnt = "117,262백만"
            color = 1
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "오피셜시그니처"
            coinNameEng = "OSN/KRW"
            price = "55.5"
            percent = "50.44%"
            tradeTotalCnt = "551,262백만"
            color = 1
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "비트코인"
            coinNameEng = "BTC/KRW"
            price = "3,885,000"
            percent = "0.44%"
            tradeTotalCnt = "44,262백만"
            color = 1
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "이더리움"
            coinNameEng = "ETH/KRW"
            price = "104,450"
            percent = "-1.09%"
            tradeTotalCnt = "19,987백만"
            color = 0
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "리플"
            coinNameEng = "XRP/KRW"
            price = "349"
            percent = "2.05%"
            tradeTotalCnt = "26,616백만"
            color = 1
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "비트코인캐시"
            coinNameEng = "BCH/KRW"
            price = "118,150"
            percent = "-1.87%"
            tradeTotalCnt = "22,446백만"
            color = 0
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "오미세고"
            coinNameEng = "OMG/KRW"
            price = "1,460"
            percent = "-1.35%"
            tradeTotalCnt = "106백만"
            color = 0
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "트론"
            coinNameEng = "TRX/KRW"
            price = "15.1"
            percent = "1.34%"
            tradeTotalCnt = "5,270백만"
            color = 1
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "이더리움클래식"
            coinNameEng = "ETC/KRW"
            price = "4,225"
            percent = "-2.87%"
            tradeTotalCnt = "330백만"
            color = 0
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "라이트코인"
            coinNameEng = "LTC/KRW"
            price = "29,080"
            percent = "1.93%"
            tradeTotalCnt = "248백만"
            color = 1
            list.add(this)
        }
        DataSet().run {
            coinNameKor = "스텔라루멘"
            coinNameEng = "XLM/KRW"
            price = "136"
            percent = "3.82%"
            tradeTotalCnt = "5,417백만"
            color = 1
            list.add(this)
        }
//        DataSet().run {
//            coinNameKor = "골렘"
//            coinNameEng = "GNT/KRW"
//            price = "76.7"
//            percent = "2.95%"
//            tradeTotalCnt = "160백만"
//            color = 1
//            list.add(this)
//        }
//        DataSet().run {
//            coinNameKor = "아더"
//            coinNameEng = "ARDR/KRW"
//            price = "60.5"
//            percent = "0.02%"
//            tradeTotalCnt = "22백만"
//            color = 1
//            list.add(this)
//        }
        DataSet().run {
            coinNameKor = "퀀텀"
            coinNameEng = "QTUM/KRW"
            price = "1,800"
            percent = "0.84%"
            tradeTotalCnt = "556백만"
            color = 1
            list.add(this)
        }
//        DataSet().run {
//            coinNameKor = "파워렛저"
//            coinNameEng = "POWR/KRW"
//            price = "181"
//            percent = "10.11%"
//            tradeTotalCnt = "364백만"
//            color = 1
//            list.add(this)
//        }
//        DataSet().run {
//            coinNameKor = "비트코인골드"
//            coinNameEng = "BTG/KRW"
//            price = "30,240"
//            percent = "8.33%"
//            tradeTotalCnt = "139백만"
//            color = 1
//            list.add(this)
//        }
//        DataSet().run {
//            coinNameKor = "스토리지"
//            coinNameEng = "STORJ/KRW"
//            price = "357"
//            percent = "-4.05%"
//            tradeTotalCnt = "133백만"
//            color = 0
//            list.add(this)
//        }
//        DataSet().run {
//            coinNameKor = "디크레드"
//            coinNameEng = "DCR/KRW"
//            price = "45,830"
//            percent = "-3.19%"
//            tradeTotalCnt = "76백만"
//            color = 0
//            list.add(this)
//        }
        DataSet().run {
            coinNameKor = "지캐시"
            coinNameEng = "ZEC/KRW"
            price = "131,300"
            percent = "3.55%"
            tradeTotalCnt = "30백만"
            color = 1
            list.add(this)
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
            return dataList?.size ?: 0
        }

        @TargetApi(Build.VERSION_CODES.M)
        @SuppressLint("ResourceAsColor")
        override fun onBindViewHolder(vh: ViewHolder, position: Int) {

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

            vh.itemContainer.setOnClickListener {
                val i = Intent(context, OrderActivity::class.java)
                i.putExtra(ARG_TITLE, dataList!![position].coinNameKor)
                i.putExtra(ARG_PRICE, dataList!![position].price)
                i.putExtra(ARG_COIN_COLOR, dataList!![position].color)
                i.putExtra(ARG_COIN_PERCENT, dataList!![position].percent)
                startActivity(i)
            }
        }

        private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val itemContainer = itemView.findViewById(R.id.trader_item_container) as View
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