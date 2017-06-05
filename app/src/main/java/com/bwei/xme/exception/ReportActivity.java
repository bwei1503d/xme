package com.bwei.xme.exception;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bwei.xme.MainActivity;
import com.bwei.xme.R;

import static com.bwei.xme.amap.AMapUtils.mContext;

public class ReportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    public void report(View view){

//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);


        finish();
    }

}
