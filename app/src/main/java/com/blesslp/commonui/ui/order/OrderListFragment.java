package com.blesslp.commonui.ui.order;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blesslp.commonui.ui.order.adapters.OrderItemAdapter;
import com.blesslp.commonui.widget.recyclerview.RecyclerViewDivider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.commonui.R;

import java.util.Arrays;

/**
 * 订单列表页
 */
public class OrderListFragment extends Fragment {

    private static final String TAG_STATUS = "TAG_STATUS";
    private String orderStatus;

    public static OrderListFragment newInstance(String orderStatus) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle args = new Bundle();
        args.putString(TAG_STATUS, orderStatus);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            orderStatus = getArguments().getString(TAG_STATUS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
    }

    //======================================================================================
    //================================测试UI======================================
    //======================================================================================


    private RecyclerView mRecyclerView;
    private OrderItemAdapter mAdapter;

    private void initRecyclerView(View contentView) {
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.lRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new OrderItemAdapter();
        mAdapter.bindToRecyclerView(mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getContext(), OrderDetailsActivity.class));
            }
        });

        mAdapter.setGroupItemClickListener(new OrderItemAdapter.OnGroupItemClickListener() {
            @Override
            public void onGroupItemClick(int parentPosition, int childrenPosition) {
                Toast.makeText(getContext(), String.format("外部:%d , 内部:%d", parentPosition, childrenPosition), Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setNewData(Arrays.asList(new String[(int) (Math.random() * 5 + 1)]));
    }


}
