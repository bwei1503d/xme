package com.bwei.xme.ketang;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by muhanxi on 17/6/6.
 */

public class CircleView extends View {


    Paint paint;
    private float x = 100;
    private float y = 100;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawCircle(x,y,100,paint);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:

                x = event.getX();
                y = event.getY();
                System.out.println("x = " + x);
                System.out.println("y = " + y);




                //主线程调用刷新
                invalidate();
                //子线程 调用刷新
//                postInvalidate();



                break;
            case MotionEvent.ACTION_UP:

                break;



        }

        return true;
    }
}
