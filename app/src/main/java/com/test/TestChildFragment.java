package com.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * @author lizheng
 * create at 2019/7/25
 * description:
 */
public class TestChildFragment extends Fragment {

    private static final String TAG = "TestFragment";


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "TestChildFragment onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "TestChildFragment onCreateView");
        return inflater.inflate(R.layout.fragment_child_test, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "TestChildFragment onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "TestChildFragment onActivityCreated");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "TestChildFragment  hidden:" + hidden);
    }
}
