package com.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * @author lizheng
 * create at 2019/7/25
 * description:
 */
public class TestFragment extends Fragment {

    private static final String TAG = "TestFragment";


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_test, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addFragment();
        Log.e(TAG, "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "hidden:" + hidden);
    }

    private void addFragment() {

        //小结：在fragment中使用commit和commitnow的区别和在activity中一样，如果fragment的create的流程没有执行完，那么子fragment也只是执行attach和onhidechange
        //

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        TestChildFragment fragment = new TestChildFragment();
        fragmentTransaction.replace(R.id.child_wrapper, fragment);
        //如果是在fragment已经attach之后，hide方法会被出发，也就是说commitNow的时候，hide方法会被出发，commit不会
        fragmentTransaction.show(fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

}
