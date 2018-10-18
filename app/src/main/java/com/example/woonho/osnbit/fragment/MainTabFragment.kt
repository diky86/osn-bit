package com.example.woonho.osnbit.fragment

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.R

class MainTabFragment : Fragment(), View.OnClickListener {
    private val TAG = "MainTabFragment"

    companion object {
        fun newInstance(): Fragment {
            MainTabFragment().run {
                return this
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_tab_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    private fun initView(v: View) {

        // 거래소
        val btnTrader = v.findViewById(R.id.btn_trader) as TextView
        btnTrader.setOnClickListener {
            val fm = fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_layout, TraderFragment.newInstance())
            ft.commit()
        }

        // 코인정보
        val btnCoinInfo = v.findViewById(R.id.btn_coin_info) as TextView
        btnCoinInfo.setOnClickListener(this)

        // 투자내역
        val btnInvestHistory = v.findViewById(R.id.btn_invest_history) as TextView
        btnInvestHistory.setOnClickListener {
            val fm = fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_layout, InvestHistoryFragment.newInstance())
            ft.commit()
        }

        // 입출금
        val btnAsset = v.findViewById(R.id.btn_asset) as TextView
        btnAsset.setOnClickListener(this)

        // 내정보
        val btnMyInfo = v.findViewById(R.id.btn_my_info) as TextView
        btnMyInfo.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        val fm = fragmentManager
        val ft = fm.beginTransaction()

        when (v.tag) {
//            R.id.btn_trader -> {
//                ft.replace(R.id.fragment_layout, TraderFragment.newInstance())
//                ft.commit()
//            }
            R.id.btn_coin_info -> { ft.replace(R.id.fragment_layout, TraderFragment.newInstance()) }
            R.id.btn_invest_history -> { ft.replace(R.id.fragment_layout, TraderFragment.newInstance()) }
            R.id.btn_asset -> { ft.replace(R.id.fragment_layout, TraderFragment.newInstance()) }
            R.id.btn_my_info -> { ft.replace(R.id.fragment_layout, TraderFragment.newInstance()) }
        }

        ft.commit()
    }
}