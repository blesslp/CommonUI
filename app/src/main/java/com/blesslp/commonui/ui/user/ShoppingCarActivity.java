package com.blesslp.commonui.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blesslp.commonui.ui.base.TranslucentActivity;
import com.blesslp.commonui.ui.user.adapters.MultiItemHolder;
import com.blesslp.commonui.ui.user.adapters.ShoppingCarMultiTypeAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.cnsunrun.commonui.R;

import java.util.Arrays;
import java.util.List;

public class ShoppingCarActivity extends TranslucentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);
        initRecyclerView();
    }

    private RecyclerView mRecyclerView;
    private ShoppingCarMultiTypeAdapter mAdapter;
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.lRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        List lst = Arrays.asList(
                new MultiItemHolder(1,MultiItemHolder.ITEM_SHOPPINGCAR, Arrays.asList(new String[5])),
                new MultiItemHolder(2,MultiItemHolder.ITEM_FAVORITE, Arrays.asList(new String[5]))
        );
        mAdapter = new ShoppingCarMultiTypeAdapter(lst);
        mAdapter.bindToRecyclerView(mRecyclerView);

    }
}
