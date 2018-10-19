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
            ownCnt = "961,444"
            priceKrw = "0 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "비트코인"
            ownCnt = "363.2352"
            priceKrw = "1,532,235 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "이더리움"
            ownCnt = "961.2"
            priceKrw = "235,243 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "이더리움클래식"
            ownCnt = "8111"
            priceKrw = "8,657,456 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "에이다"
            ownCnt = "1,772.00000000"
            priceKrw = "149,734 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "가스"
            ownCnt = "961"
            priceKrw = "35,234 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "블록틱스"
            ownCnt = "1,123"
            priceKrw = "13,234,353 KRW"
            isReady = false
            list.add(this)
        }
        DataSet().run {
            coinName = "시프트"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "팩텀"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "헤이븐"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "지코인"
            ownCnt = "0"
            priceKrw = "0 KRW"
            isReady = true
            list.add(this)
        }
        DataSet().run {
            coinName = "유빅"
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