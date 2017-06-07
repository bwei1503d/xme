package com.bwei.xme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bwei.xme.alipay.PayDemoActivity;
import com.bwei.xme.amap.AMapActivity;
import com.bwei.xme.amap.AMapUtils;
import com.bwei.xme.anim.AnimActivity;
import com.bwei.xme.autolayout.AutoLayout;
import com.bwei.xme.customview.CustomImageView;
import com.bwei.xme.customview.FlowActivity;
import com.bwei.xme.customview.ImageViewerActivity;
import com.bwei.xme.exception.ReportActivity;
import com.bwei.xme.ketang.CircleActivity;
import com.bwei.xme.ketang.PhotoViewActivity;
import com.bwei.xme.listview.ListViewActivity;
import com.bwei.xme.zxing.ZxingActivity;
import com.orhanobut.logger.Logger;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        AMapUtils.getInstance(getApplicationContext()).start();

       


    }

    public void error(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int a =  7 / 0 ;
            }
        }).start();
    }


    public void  go(View view){
        startActivity(new Intent(this, PhotoViewActivity.class));

    }

}
