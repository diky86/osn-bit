package com.example.woonho.osnbit.fragment

import android.annotation.TargetApi
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.R

class AssetFragment : Fragment() {
    private val TAG = "AssetFragment"

    companion object {
        fun newInstance(): Fragment {
            AssetFragment().run {
                return this
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_asset_fragment, container, false)
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = ArrayList<DataSet>()

        DataSet().run {
            coinName = "원화"
            ownCnt = "142,000,000"
            priceKrw = "0 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "빗플"
            ownCnt = "163,024.25"
            priceKrw = "29,661,000 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "비트코인"
            ownCnt = "12.48"
            priceKrw = "80,510,000 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "오피셜시그니처"
            ownCnt = "412,781.28"
            priceKrw = "31,829,000 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "이더리움"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "리플"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "비트코인캐시"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "오미세고"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "트론"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "이더리움클래식"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "라이트코인"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "스텔라루멘"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "퀀텀"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }

        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        val adapter = AssetAdapter(context)

        adapter.setData(list)
        recyclerView.adapter = adapter
        val lm = LinearLayoutManager(context)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
    }

    private inner class AssetAdapter(val context: Context) : RecyclerView.Adapter<AssetAdapter.ItemViewHolder>() {

        private var dataList: ArrayList<DataSet>? = null

        fun setData(list: ArrayList<DataSet>) {
            dataList = list
        }
        override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
            return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.asset_list_item, parent, false))
        }

        override fun getItemCount(): Int {
            return dataList?.size ?: 0
        }

        override fun onBindViewHolder(vh: ItemViewHolder, position: Int) {

            vh.tvCoinName.text = dataList!![position].coinName
            if (dataList!![position].isReady) {
                vh.tvReady.visibility = View.VISIBLE
            } else {
                vh.tvReady.visibility = View.GONE
            }
            vh.tvOwnCnt.text = dataList!![position].ownCnt
            vh.tvPriceKrw.text = dataList!![position].priceKrw
            if (position == 0) {
                vh.tvPriceKrw.visibility = View.GONE
            } else {
                vh.tvPriceKrw.visibility = View.VISIBLE
            }
        }

        private inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvCoinName = itemView.findViewById(R.id.tv_coin_name) as TextView
            val tvOwnCnt = itemView.findViewById(R.id.tv_own_cnt) as TextView
            val tvPriceKrw = itemView.findViewById(R.id.tv_price_krw) as TextView
            val tvReady = itemView.findViewById(R.id.tv_ready) as TextView
        }
    }

    private class DataSet {
        var coinName = ""
        var ownCnt = ""
        var priceKrw = ""
        var isReady = false
    }
}