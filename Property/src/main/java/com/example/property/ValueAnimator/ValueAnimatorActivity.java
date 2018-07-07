package com.example.property.ValueAnimator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.property.R;


/*
* ValueAnimator包下都是测试ValueAnimator
* 这个activity是ValueAnimator基础部分
* 构造一个 ValueAnimator 实例，让其计算的值是从 0 到 400； 然后添加对计算过程进行监听：
* */
public class ValueAnimatorActivity extends AppCompatActivity {

    private static final String TAG = "ValueAnimatorActivity";
    private TextView tv;
    ValueAnimator animator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ValueAnimatorActivity.this, "clicked me", Toast.LENGTH_SHORT).show();
            }
        });
        //初始化动画的播放信息
        animator = doAnimation();
    }

    public void startClick(View view) {
        animator.start();//开始播放
    }

    public void stopClick(View view) {
        animator.cancel();//结束播放
    }

    //初始化动画的播放信息
    private ValueAnimator doAnimation() {
    //ofInt的参数是可变长参数，如 ofInt(2,90,45)就表示从数值 2 变化到数字 90 再变化到数字 45
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        //监听变化并改变textView位置
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                //通过layout()修改位置
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);//循环播放模式：反向退回
        animator.setRepeatCount(ValueAnimator.INFINITE);//循环播放次数(这个值其实是-1,会一直播放下去)
        animator.setDuration(1000);//播放时长

        //监听动画的四个状态：start end repeat cancel
        //当调用cancel时，end 会在cancel后发送生
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.d(TAG, "Animation Start ");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.d(TAG, "Animation End");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.d(TAG, "Animation Cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.d(TAG, "Animation Repeat");
            }
        });
        return animator;
    }

}
