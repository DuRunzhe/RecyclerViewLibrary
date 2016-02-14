package com.ldzs.pulltorefreshrecyclerview.ui.drag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.ldzs.pulltorefreshrecyclerview.R;
import com.ldzs.pulltorefreshrecyclerview.adapter.SimpleAdapter;
import com.ldzs.pulltorefreshrecyclerview.data.Date;
import com.ldzs.recyclerlibrary.DragRecyclerView;
import com.ldzs.recyclerlibrary.anim.SlideInLeftAnimator;

/**
 * Created by cz on 16/1/27.
 */
public class DynamicDragActivity extends AppCompatActivity {
    private DragRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        setTitle(getIntent().getStringExtra("title"));
        mRecyclerView = (DragRecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setItemAnimator(new SlideInLeftAnimator());
        mRecyclerView.getItemAnimator().setAddDuration(300);
        mRecyclerView.getItemAnimator().setRemoveDuration(300);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new SimpleAdapter(this, R.layout.grid_text_item, Date.createItems(this, 100)));
        mRecyclerView.setLongPressDrawEnable(true);
        mRecyclerView.addDynamicView(Date.getHeaderItemView(this), 3);
        mRecyclerView.addDynamicView(Date.getHeaderItemView(this), 10);
        mRecyclerView.setOnDragItemEnableListener(position -> true);
    }


}
