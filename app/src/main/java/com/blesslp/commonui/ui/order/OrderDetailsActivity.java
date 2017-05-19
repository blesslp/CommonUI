package com.blesslp.commonui.ui.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blesslp.commonui.ui.base.TranslucentActivity;
import com.blesslp.commonui.ui.order.adapters.OrderDetailsItemAdapter;
import com.cnsunrun.commonui.R;

/**
 * 订单详情
 */
public class OrderDetailsActivity extends TranslucentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        initRecyclerView();
        initHeaderAndFooter();
        attachDemoData();
    }

    private void attachDemoData() {
        mAdapter.addData("");
    }

    private void initHeaderAndFooter() {
        mAdapter.addHeaderView(getLayoutInflater().inflate(R.layout.item_shipping_address_only, mRecyclerView,false));
        mAdapter.addFooterView(getLayoutInflater().inflate(R.layout.item_order_detail_infobar, mRecyclerView,false));
    }

    private RecyclerView mRecyclerView;
    private OrderDetailsItemAdapter mAdapter;
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recvProductItem);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new OrderDetailsItemAdapter();
        mAdapter.bindToRecyclerView(mRecyclerView);
    }


}
