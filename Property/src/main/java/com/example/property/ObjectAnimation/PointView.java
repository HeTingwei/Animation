package com.example.property.ObjectAnimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HeTingwei on 2017/11/14.
 */

public class PointView extends View {
    Point point = new Point(200);
    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(400,400,point.getRadius(), paint);
    }

    //这个setRadius必须要有，IDE无法直接识别此点，这个让动画可以改变radius属性
    public void setRadius(int radius){
        point.setRadius(radius);
        invalidate();
    }

    //当且仅当在只有一个数值参数是调用getRaduis()
    //如：ObjectAnimator animator = ObjectAnimator.ofInt(pointView, "radius",100);
    public int getRaduis(){
        return 50;
    }

}
