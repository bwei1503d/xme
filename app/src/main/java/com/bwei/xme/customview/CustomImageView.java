package com.bwei.xme.customview;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 * Created by muhanxi on 17/5/28.
 */


/**
 * 自定义imageview 缩放
 *
 * http://www.cnblogs.com/qiengo/archive/2012/06/30/2570874.html#code
 *
 * http://blog.csdn.net/xiaanming/article/details/42833893
 */
public class CustomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener,ViewTreeObserver.OnGlobalLayoutListener{


    ScaleGestureDetector scaleGestureDetector ;

    Matrix matrix = new Matrix();

    boolean onces ;

    public CustomImageView(Context context) {
        this(context,null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        scaleGestureDetector = new ScaleGestureDetector(context,this);






    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {


        scaleGestureDetector.onTouchEvent(event);

        return true;
    }


    @Override
    public boolean onScale(ScaleGestureDetector detector) {

        float scaleFactor = detector.getScaleFactor() ;
        System.out.println("detector = " + detector.getScaleFactor());
        matrix.postScale(scaleFactor, scaleFactor,detector.getFocusX(),
        detector.getFocusY());
        setImageMatrix(matrix);


        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        // 必须返回true
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }

    float initScale ;
    float midScale ;
    float maxScale;

    @Override
    public void onGlobalLayout() {

        if(!onces) {
            onces = true;
            matrix.set(getMatrix());



            int width = getWidth() ;
            int height = getHeight() ;

            int dw = getDrawable().getIntrinsicWidth();
            int dh = getDrawable().getIntrinsicHeight() ;



            float scale = 1.0f;

//            如果仅仅是图片宽度比view宽度大，则应该将图片按宽度缩小
            if(dw>width&&dh<height)
            {
                scale = width*1.0f/dw;
            }
            //如果图片和高度都比view的大，则应该按最小的比例缩小图片
            if(dw>width&&dh>height)
            {
                scale = Math.min(width*1.0f/dw, height*1.0f/dh);
            }
            //如果图片宽度和高度都比view的要小，则应该按最小的比例放大图片
            if(dw<width&&dh<height)
            {
                scale = Math.min(width*1.0f/dw, height*1.0f/dh);
            }
            //如果仅仅是高度比view的大，则按照高度缩小图片即可
            if(dw<width&&dh>height)
            {
                scale = height*1.0f/dh;
            }

            initScale = scale;
            midScale = initScale*2;
            maxScale = initScale*4;

//移动图片到达view的中心
            int dx = width/2 - dw/2;
            int dy = height/2 - dh/2;
            matrix.postTranslate(dx, dy);

//缩放图片
            matrix.postScale(initScale, initScale, width/2, height/2);

            setImageMatrix(matrix);


        }

    }
}
