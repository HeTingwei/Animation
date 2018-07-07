package com.example.animation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
/*

这个项目包括Tween Animation补间动画 和Frame Animation逐帧动画(只有一例)
* 感觉这个地方学比较好：极客学院：http://wiki.jikexueyuan.com/project/android-animation/
* 本项目来自： 慕课网:http://www.imooc.com/video/7361但是是视屏教学
* 官网讲解： 自定义动画：https://developer.android.com/training/material/animations.html?hl=zh-cn
* 以及： Animation and Graphics： https://developer.android.com/guide/topics/graphics/overview.html?hl=zh-cn
*
* */
public class MainActivity extends Activity implements OnClickListener {

	private ImageView image;
	private Button scale;
	private Button rotate;
	private Button translate;
	private Button mix;
	private Button alpha;
	private Button continue_btn;
	private Button continue_btn2;
	private Button flash;
	private Button move;
	private Button change;
	private Button layout;
	private Button frame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		image = (ImageView) findViewById(R.id.image);
		scale = (Button) findViewById(R.id.scale);
		rotate = (Button) findViewById(R.id.rotate);
		translate = (Button) findViewById(R.id.translate);
		alpha = (Button) findViewById(R.id.alpha);
		continue_btn = (Button) findViewById(R.id.continue_btn);
		continue_btn2 = (Button) findViewById(R.id.continue_btn2);
		flash = (Button) findViewById(R.id.flash);
		move = (Button) findViewById(R.id.move);
		change = (Button) findViewById(R.id.change);
		layout = (Button) findViewById(R.id.layout);
		frame = (Button) findViewById(R.id.frame);
		scale.setOnClickListener(this);
		rotate.setOnClickListener(this);
		translate.setOnClickListener(this);
		alpha.setOnClickListener(this);
		continue_btn.setOnClickListener(this);
		continue_btn2.setOnClickListener(this);
		flash.setOnClickListener(this);
		move.setOnClickListener(this);
		change.setOnClickListener(this);
		layout.setOnClickListener(this);
		frame.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Animation loadAnimation;
		switch (view.getId()) {
		// 渐变尺寸缩放动画
		case R.id.scale: {
			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
			image.startAnimation(loadAnimation);
			break;
		}

		// 旋转动画
		case R.id.rotate: {
			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
			image.startAnimation(loadAnimation);
			break;
		}
		// 位置移动动画
		case R.id.translate: {

			loadAnimation = AnimationUtils
					.loadAnimation(this, R.anim.translate);
			image.startAnimation(loadAnimation);
			break;
		}

		// 连续播放两种动画：位移（带动画监听器）+旋转
		case R.id.continue_btn: {
			loadAnimation = AnimationUtils
					.loadAnimation(this, R.anim.translate);
			image.startAnimation(loadAnimation);
			final Animation loadAnimation2 = AnimationUtils.loadAnimation(this,
					R.anim.rotate);
			loadAnimation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation arg0) {
					// TODO Auto-generated method stub
					image.startAnimation(loadAnimation2);
				}
			});
			break;
		}
		// 两个动画续波：在配置文件里写了两个动画
		case R.id.continue_btn2: {
			loadAnimation = AnimationUtils.loadAnimation(this,
					R.anim.continue_anim);
			image.startAnimation(loadAnimation);
			break;
		}

		// 透明度动画
		case R.id.alpha: {
			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
			image.startAnimation(loadAnimation);
			break;
		}
		// 左右抖动
		case R.id.move: {
			TranslateAnimation translate = new TranslateAnimation(-50, 50, 0, 0);
			translate.setDuration(1000);
			translate.setRepeatCount(Animation.INFINITE);
			translate.setRepeatMode(Animation.REVERSE);
			image.startAnimation(translate);

			break;
		}
		// 闪烁：没有加载配置文件
		case R.id.flash: {

			AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);// 10%到100%透明
			alphaAnimation.setDuration(100);// 持续时间
			alphaAnimation.setRepeatCount(10);// 重复10次
			// 倒序的重复REVERSE正序的重复RESTART
			alphaAnimation.setRepeatMode(Animation.REVERSE);
			image.startAnimation(alphaAnimation);

			break;
		}

		// Activity切换动画
		case R.id.change: {
			Intent intent = new Intent(MainActivity.this, MainActivity2.class);
			startActivity(intent);
            //第一参数是进入的Activity动画，第二是消失的Activity动画
			overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
			break;
		}

		// listview的子view的添加动画
		case R.id.layout: {
			Intent intent = new Intent(MainActivity.this, ListActivity.class);
			startActivity(intent);
			break;
		}

		// 逐帧动画
		case R.id.frame: {
			image.setImageResource(R.drawable.anim_list);
			AnimationDrawable animationDrawable = (AnimationDrawable) image
					.getDrawable();

			animationDrawable.start();

			break;

		}

		}
	}

}
