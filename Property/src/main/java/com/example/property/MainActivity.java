package com.example.property;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.property.ObjectAnimation.ObjectAnimationActivity;
import com.example.property.ValueAnimator.ValueAnimatorActivity;
import com.example.property.ValueAnimator.ValueAnimatorActivity2;

/*这个学习Property Animator的项目
* 学习网址：http://wiki.jikexueyuan.com/project/android-animation/
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//valueAnimator基础
    public void valueAnimationClick(View view) {
startActivity(new Intent(this, ValueAnimatorActivity.class));
    }
//ValueAnimator进阶
    public void valueAnimationClick2(View view) {
        startActivity(new Intent(this, ValueAnimatorActivity2.class));
    }

    public void objectAnimationClick(View view) {
startActivity(new Intent(this, ObjectAnimationActivity.class));
    }


}
