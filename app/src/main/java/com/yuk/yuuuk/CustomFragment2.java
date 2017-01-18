package com.yuk.yuuuk;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by dedi on 18/01/17.
 * That's it
 */

public class CustomFragment2 extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.wtf("CustomFragment2", "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.wtf("CustomFragment2", "onCreateView");
        return inflater.inflate(R.layout.layout_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.wtf("CustomFragment2", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.wtf("CustomFragment2", "onActivityCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.wtf("CustomFragment2", "onDestroyView");
    }
}
