package com.bwei.xme;

import android.app.Application;
import android.util.Log;

import com.bwei.xme.exception.CrashHandler;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by muhanxi on 17/6/4.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        CrashReport.initCrashReport(getApplicationContext(), "baf4712ebd", true);


        FormatStrategy formatStrategy = CsvFormatStrategy.newBuilder()
                .tag("custom")
                .build();

        Logger.addLogAdapter(new DiskLogAdapter(formatStrategy));

        Logger.addLogAdapter(new AndroidLogAdapter());

    }
}
