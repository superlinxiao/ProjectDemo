package com.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;



/**
 * @author lizheng
 * create at 2019/7/25
 * description:
 */
public class FragmentTestAct extends FragmentActivity {
    private static final String TAG = "TestFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "FragmentTestAct onCreate start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

//        addFragment();

        Log.i(TAG, "FragmentTestAct onCreate end");


        //小结：在oncreate里面，commitAllowingStateLoss和commitNowAllowingStateLoss会影响fragmentattach方法的调用顺序，
        // 用now的话，会立即执行attach


//        FragmentTestAct onCreate start
//        onAttach
//        FragmentTestAct onCreate end
//        onCreateView
//        onViewCreated
//        onActivityCreated
//        FragmentTestAct onStart
    }

    private void addFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        TestFragment fragment = new TestFragment();
        fragmentTransaction.replace(R.id.frame, fragment);
        //如果是在fragment已经attach之后，hide方法会被出发，也就是说commitNow的时候，hide方法会被出发，commit不会
        fragmentTransaction.show(fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        addFragment();
        //小结：在onStart及其之后里面，commitAllowingStateLoss和commitNowAllowingStateLoss会影响fragment attach onCreateView onViewCreated onActivityCreated 方法的调用顺序，
        // 用now的话，会立即执行attach

//        FragmentTestAct onCreate start
//        FragmentTestAct onCreate end
//        FragmentTestAct onStart
//        onAttach
//                onCreateView
//        onViewCreated
//                onActivityCreated
        Log.i(TAG, "FragmentTestAct onStart");
    }
}
