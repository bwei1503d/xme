package com.bwei.xme.amap;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by muhanxi on 17/5/29.
 */

public class AMapUtils {

    public static AMapUtils aMapUtils ;

    public  static Context mContext ;
    public static AMapUtils getInstance(Context context){
        if(aMapUtils == null){
            aMapUtils = new AMapUtils();
            mContext = context;
        }

        return  aMapUtils;
    }


//    /声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener ;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
//初始化AMapLocationClientOption对象
    private AMapUtils(){

    }



    public void start(){

        mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {


                System.out.println("aMapLocation = " + aMapLocation.getLatitude() + " " + aMapLocation.getLongitude());

                System.out.println("aMapLocation = " + aMapLocation.getCity() +  "  " + aMapLocation.getProvince() + aMapLocation.getStreet());

            }
        };
        mLocationClient = new AMapLocationClient(mContext);
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setHttpTimeOut(20000);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
//启动定位
        mLocationClient.startLocation();

    }


}
