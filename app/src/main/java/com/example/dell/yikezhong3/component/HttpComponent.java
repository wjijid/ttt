package com.example.dell.yikezhong3.component;

import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.duanzi.DuanziFragment;
import com.example.dell.yikezhong3.ui.login.ItActivity;

import dagger.Component;

@Component(modules = HttpMoudle.class)
public interface HttpComponent {

    void inject(DuanziFragment duanziFragment);
    void inject(ItActivity itActivity);
}
