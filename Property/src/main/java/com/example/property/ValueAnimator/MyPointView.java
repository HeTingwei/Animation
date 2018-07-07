package com.example.property.ValueAnimator;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;
/*
* 用于自定义的ObjectOf
* */
public class MyPointView extends View {
    private Point mCurPoint;  
    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);  
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(600,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);  
        if (mCurPoint != null){  
            Paint paint = new Paint();
            paint.setAntiAlias(true);  
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);  
            canvas.drawCircle(300,300,mCurPoint.getRadius(),paint);
        }  
    }  

    public void doPointAnim(){  
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {  
            @Override  
            public void onAnimationUpdate(ValueAnimator animation) {  
                mCurPoint = (Point)animation.getAnimatedValue();  
                invalidate();  
            }  
        });  
        animator.setDuration(1000);  
        animator.setInterpolator(new BounceInterpolator());
        animator.start();  
    }
    public class PointEvaluator implements TypeEvaluator<Point> {
        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            int start = startValue.getRadius();
            int end  = endValue.getRadius();
            int curValue = (int)(start + fraction * (end - start));
            return new Point(curValue);
        }
    }
}