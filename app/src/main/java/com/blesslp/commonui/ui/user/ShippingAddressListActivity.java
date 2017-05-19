package com.blesslp.commonui.ui.user;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.blesslp.commonui.ui.base.TranslucentActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cnsunrun.commonui.R;

import java.util.Arrays;

public class ShippingAddressListActivity extends TranslucentActivity {

    private RecyclerView mRecyclerView;
    private ShippingAddressListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address_list);

        initRecyclerView();
        initAdapterData();
    }

    private void initAdapterData() {
        mAdapter.setNewData(Arrays.asList(new String[2]));
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.lRecyclerView);
        mAdapter = new ShippingAddressListAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }

    static class ShippingAddressListAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

        public ShippingAddressListAdapter() {
            super(R.layout.item_shipping_address);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
        }
    }
}
