package com.example.property.ValueAnimator;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.property.R;

/*
* 这个是ValueAnimator进阶
* */
public class ValueAnimatorActivity2 extends AppCompatActivity {
    private static final String TAG = "ValueAnimatorActivity2";
    private TextView tv, tv2;
    ValueAnimator animator, animator2, animator3, animator4;
    MyPointView myPointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator2);
        tv = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView4);
        myPointView = (MyPointView) findViewById(R.id.myPointView);
        addValueAnimator();
        addValueAnimator2();
        addValueAnimator3();
    }

    public void startClick(View view) {
        animator.start();
    }

    public void startClick2(View view) {
        animator2.start();
    }

    public void startClick3(View view) {
        animator3.start();
    }

    public void startClick4(View view) {
        //自定义objectOf，使用自定义View:MyPointView
        myPointView.doPointAnim();
    }

    //使用插值器
    private ValueAnimator addValueAnimator() {
        animator = ValueAnimator.ofInt(0, 600);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.layout(curValue, tv.getTop(), curValue + tv.getWidth(), tv.getBottom());
            }
        });
        animator.setDuration(1000);
        //使用插值器效果：https://hetingwei.github.io/Web/Android%20develop%20help/Animation/interpolator.html
        //使用插值器interpolator改变动画效果
        animator.setInterpolator(new BounceInterpolator());//结束时弹起来几下
        return animator;
    }

    //    使用ofObject改变数值
    private void addValueAnimator2() {

        animator2 = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char) animation.getAnimatedValue();
                tv2.setText(String.valueOf(text));
            }
        });
        animator2.setInterpolator(new LinearInterpolator());
        animator2.setDuration(10000);
    }

    //使用 ArgbEvalutor 变换颜色
    private void addValueAnimator3() {
        animator3 = ValueAnimator.ofInt(Color.RED, Color.YELLOW);
        animator3.setEvaluator(new ArgbEvaluator());//变换颜色
        animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) animation.getAnimatedValue();
                tv2.setBackgroundColor(color);
            }
        });
        animator3.setDuration(3000);
    }


    //自定义的Evaluator，用于objectOf
    class CharEvaluator implements TypeEvaluator<Character> {
        @Override
        //fraction是进度在1到0之间
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt = (int) startValue;
            int endInt = (int) endValue;
            int curInt = (int) (startInt + fraction * (endInt - startInt));
            char result = (char) curInt;
            return result;
        }
    }
}

