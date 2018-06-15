package com.example.dell.yikezhong3.ui.file;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.yikezhong3.R;

public class UpLoadFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceStte) {

        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        return view;
    }
}
