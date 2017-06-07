package com.bwei.xme.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by muhanxi on 17/5/28.
 * 自定义圆 跟随手指移动
 */

public class CircleView extends View {


    Paint paint ;
    float x ;
    float y ;
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint = new Paint();
        paint.setAntiAlias(true);




    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        x =  MeasureSpec.getSize(widthMeasureSpec)/2 ;
       y = MeasureSpec.getSize(heightMeasureSpec )/ 2;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);

        canvas.drawCircle(x,y,100,paint);



    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                x = event.getX() ;
//                y = event.getY();
                System.out.println("event ACTION_DOWN = " + event.getX() + "  " + event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                float movey =  event.getY() ;
                float movex = event.getX() ;

//                x = Math.abs(movex - x);
//                y = Math.abs(movey - y) ;
                x = movex ;
                y = movey ;
                invalidate();



                break;
            case MotionEvent.ACTION_UP:
                x = event.getX() ;
                y = event.getY();
                break;



        }




        return true;
    }
}
