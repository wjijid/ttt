package com.example.dell.yikezhong3.ui.shipin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.dell.yikezhong3.R;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowFragment;
import com.example.dell.yikezhong3.ui.shipin.nearby.VNearbyFragment;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.GuanZhuFragment;
import com.example.dell.yikezhong3.ui.tuijian.remen.ReMenFragment;

public class ShiPinFragment extends Fragment {


    private RadioGroup rg;
    private FragmentManager manager;
    private FrameLayout fr;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shipin_layout, null);
        fr = view.findViewById(R.id.fr);
        rg = view.findViewById(R.id.rg);
//        toolbar_title = view.findViewById(R.id.toolbar_title);
//        toolbar_title.setText("推荐");
        manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fr,new VFollowFragment()).commit();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        manager.beginTransaction().replace(R.id.fr,new VFollowFragment()).commit();
                        break;
                    case R.id.rb2:
                       // manager.beginTransaction().replace(R.id.fr,new VNearbyFragment()).commit();
                        break;
                }
            }
        });
        return view;
    }
}
