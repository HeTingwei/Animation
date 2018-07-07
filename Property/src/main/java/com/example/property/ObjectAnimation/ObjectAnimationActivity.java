package com.example.property.ObjectAnimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.property.R;

public class ObjectAnimationActivity extends AppCompatActivity {

    TextView tv;
    PointView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
        tv = (TextView) findViewById(R.id.textView);
        pointView = (PointView) findViewById(R.id.pointView);

    }

    public void alphaClick(View view) {
        //改变透明度
        //四个参数作用：1.指定作用控件2.指定操作属性3.可变长参数，这里指定透明度从1到0再到1
        //像“alpha”这样的参数，是因为textView有setAlpha()方法，这点可以用于自定义的View
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1);
        animator.setDuration(2000);
        animator.start();
    }

    //旋转0到180再到0(这里其实是绕Z轴转，z轴垂直于X和Y轴)
    public void rotateClick(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "rotation", 0, 180, 0);
        animator.setDuration(2000);
        animator.start();
    }

    //以穿过textView中心的水平线为轴旋转
    public void rotateXClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "rotationX", 0, 270, 0);
        animator.setDuration(2000);
        animator.start();
    }

    //以穿过textView的中心的竖直线为轴旋转
    public void rotateYClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "rotationY", 0, 270, 0);
        animator.setDuration(2000);
        animator.start();
    }

    //水平移动
    public void translationX(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationX", 0, 200, 0,300);
        animator.setDuration(2000);
        animator.start();
    }

    //y轴上缩放大小,参数的单位是多少倍
    public void scaleYClick(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "scaleY", 0, 1, 0, 2);
        animator.setDuration(2000);
        animator.start();
    }

    //自定义 ObjectAnimator 属性
    public void objectAnimatorClick(View v) {

        doPointViewAnimation();
    }
    private void doPointViewAnimation(){
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
        //这里的pointRadius是因为在自定义View中有：setPointRadius()方法，使用Int也是看setPointRadius（）的参数
        ObjectAnimator animator = ObjectAnimator.ofInt(pointView, "radius", 0, 400, 150,400);
        animator.setDuration(2000);
        animator.start();

    }



}
