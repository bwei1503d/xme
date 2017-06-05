package com.bwei.xme.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.AbsListView;
import android.widget.ListView;

import com.bwei.xme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhanxi on 17/6/4.
 */

public class ListViewActivity extends Activity {

    private ListView listView;

    public List<ItemBean> list = new ArrayList<ItemBean>();
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        listView = (ListView) findViewById(R.id.listview_id);


        for(int i=0;i<100;i++){
            ItemBean itemBean = new ItemBean();
            itemBean.setText(i+"");
            itemBean.setIschecked(false);
            list.add(itemBean);
        }

        adapter = new ListAdapter(this,list);
        listView.setAdapter(adapter);




        // 点击加载更多
//         自动加载  自动分页
//        手动加载   手动分页
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                System.out.println("scrollState = " + scrollState);

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

//                System.out.println("firstVisibleItem = " + firstVisibleItem);
//                System.out.println("visibleItemCount = " + visibleItemCount);
//                System.out.println("totalItemCount = " + totalItemCount);


            }
        });

    }
}
