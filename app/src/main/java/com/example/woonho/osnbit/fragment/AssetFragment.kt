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
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "비트코인"
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "원화"
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "원화"
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "원화"
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "원화"
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "원화"
            price = "961,444"
            list.add(this)
        }
        DataSet().run {
            coinName = "원화"
            price = "961,444"
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

        override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }


        private inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvCoinName = itemView.findViewById(R.id.tv_coin_name) as TextView
            val tvPrice = itemView.findViewById(R.id.tv_price) as TextView
        }
    }

    private class DataSet {
        var coinName = ""
        var price = ""
    }
}