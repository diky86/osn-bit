package com.example.woonho.osnbit.fragment

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woonho.osnbit.R

class MainTabFragment : Fragment() {
    private val TAG = "MainTabFragment"

    companion object {
        fun newInstance(): Fragment {
            MainTabFragment().run {
                return this
            }
        }
    }

    private lateinit var btnTrader: TextView
    private lateinit var btnInvestHistory: TextView
    private lateinit var btnAsset: TextView
    private lateinit var btnMyInfo: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_tab_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }

    private fun initView(v: View) {

        val fm = fragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragment_layout, TraderFragment.newInstance())
        ft.commit()

        // 거래소
        btnTrader = v.findViewById(R.id.btn_trader) as TextView
        btnTrader.tag = 0
        btnTrader.setOnClickListener {
            setTextBold(btnTrader)
            val fm = fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_layout, TraderFragment.newInstance())
            ft.commit()
        }

        // 투자내역
        btnInvestHistory = v.findViewById(R.id.btn_invest_history) as TextView
        btnInvestHistory.tag = 1
        btnInvestHistory.setOnClickListener {
            setTextBold(btnInvestHistory)
            val fm = fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_layout, InvestHistoryFragment.newInstance())
            ft.commit()
        }

        // 입출금
        btnAsset = v.findViewById(R.id.btn_asset) as TextView
        btnAsset.tag = 2
        btnAsset.setOnClickListener {
            setTextBold(btnAsset)
            val fm = fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_layout, AssetFragment.newInstance())
            ft.commit()
        }

        // 내정보
        btnMyInfo = v.findViewById(R.id.btn_my_info) as TextView
        btnAsset.tag = 3
        btnMyInfo.setOnClickListener {
            setTextBold(btnMyInfo)
            val fm = fragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragment_layout, MyInfoFragment.newInstance())
            ft.commit()
        }

    }

    private fun setTextBold(view: TextView) {

        val viewGroup = arrayOf(btnTrader, btnInvestHistory, btnAsset, btnMyInfo)
        for (v in viewGroup) {
            if (v.tag == view.tag) {
                v.setTypeface(view.typeface, Typeface.BOLD)
                v.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
            } else {
                v.typeface = Typeface.DEFAULT
                v.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15f)
            }
        }
    }

}