package com.example.woonho.osnbit;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;

import com.example.woonho.osnbit.fragment.OrderFragment;

public class OrderActivity extends AppCompatActivity {

    private final String TAG = "OrderActivity";

    private final String ARG_TITLE = "argTitle";
    private final String ARG_PRICE = "argPrice";
    private final String ARG_COIN_COLOR = "argCoinColor";
    private final String ARG_COIN_PERCENT = "argCoinPercent";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.order_activity_main);

        Intent i = getIntent();
        int color = i.getIntExtra(ARG_COIN_COLOR, 0);
        String title = i.getStringExtra(ARG_TITLE);
        String coinPercent = i.getStringExtra(ARG_COIN_PERCENT);
        String price = i.getStringExtra(ARG_PRICE);

        OrderFragment.CoinData coinData = new OrderFragment.CoinData();
        coinData.setCoinColor(color);
        coinData.setCoinPirce(price);
        coinData.setCoinPercent(coinPercent);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.order_main_fragment, OrderFragment.Companion.newInstance(coinData, title));
        ft.commit();
    }
}
