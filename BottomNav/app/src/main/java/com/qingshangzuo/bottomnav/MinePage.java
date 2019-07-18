package com.qingshangzuo.bottomnav;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MinePage extends Fragment {

    // 缓存 Fragment 视图
    private View rootView;
    private static MinePage minePage;

    public MinePage(){

    }

    public static MinePage getNewInstance(){
        if(minePage == null){
            minePage = new MinePage();
        }
        return minePage;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(R.layout.activity_mine,container,false);
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();

        if (parent != null){
            parent.removeView(rootView);
        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
