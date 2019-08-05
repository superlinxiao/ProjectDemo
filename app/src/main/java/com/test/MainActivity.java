package com.test;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator mAnimator;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogMetricsUtils.logMetrics(this, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAnimator = ObjectAnimator.ofFloat(null, "translationY", 0f, 300f);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setRepeatMode(ValueAnimator.RESTART);
        mAnimator.setDuration(2000);
//        mAnimator.setStartDelay(5000);
        mAnimator.setTarget(findViewById(R.id.test));
        Log.e(TAG, "start:" + System.currentTimeMillis());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e(TAG, "onAnimationUpdate:" + System.currentTimeMillis());
            }
        });
    }

    public void pause(View view) {
        mAnimator.pause();
    }


    public void resume(View view) {
        mAnimator.resume();//如果再pause和resume中建设置了setCurrentTime，那么再resume的时候是不会处理这个时间点的，仍然会在上次暂停的位置开始执行动画
    }

    public void start(View view) {
        Log.e(TAG, "start:" + System.currentTimeMillis());
        mAnimator.start();//如果有时间点事件，会在相应的时间点开始执行动画，否则，从0时间点开始执行
        //start后会在同一个线程马上执行update监听回调

        Log.e(TAG, "start over:" + System.currentTimeMillis());

        mAnimator.setCurrentPlayTime(1000);//如果动画已经开始，会将执行相应时间的动画，并消耗掉这个时间点事件。如果动画没有开始，会等待动画开始执行的时候，执行相应时间的动画
        //综上，如果想要每次都在指定时间点开始执行动画，只需要在start之后再设置时间点，调用顺序不能错。
    }

    public void cancel(View view) {
        mAnimator.cancel();
    }

    public void showStatus(View view) {
        boolean running = mAnimator.isRunning();
        boolean paused = mAnimator.isPaused();
        boolean started = mAnimator.isStarted();
        Log.e(TAG, "running:" + running + "  paused:" + paused + "   started:" + started);
    }

    public void setTime(View view) {
        mAnimator.setCurrentPlayTime(1500);
    }

    public void startTestFragment(View view) {
        startActivity(new Intent(this, FragmentTestAct.class));
    }
}
