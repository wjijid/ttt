package com.example.dell.yikezhong3.component;

import com.example.dell.yikezhong3.fragment.TabFragment3;
import com.example.dell.yikezhong3.moudle.HttpMoudle;
import com.example.dell.yikezhong3.ui.collect.MyShouCangActivity;
import com.example.dell.yikezhong3.ui.duanzi.DuanziFragment;
import com.example.dell.yikezhong3.ui.follow.FollowActivity;
import com.example.dell.yikezhong3.ui.select.MySouActivity;
import com.example.dell.yikezhong3.ui.shipin.follow.VFollowFragment;
import com.example.dell.yikezhong3.ui.shipin.nearby.VNearbyFragment;
import com.example.dell.yikezhong3.ui.tuijian.guanzhu.GuanZhuFragment;
import com.example.dell.yikezhong3.ui.tuijian.remen.ReMenFragment;
import com.example.dell.yikezhong3.ui.login.ItActivity;
import com.example.dell.yikezhong3.ui.regin.ReginActivity;
import com.example.dell.yikezhong3.ui.xiangqing.XiangQingActivity;

import dagger.Component;

@Component(modules = HttpMoudle.class)
public interface HttpComponent {

    void inject(DuanziFragment duanziFragment);
    void inject(ReMenFragment reMenFragment);
    void inject(ItActivity itActivity);
    void inject(ReginActivity reginActivity);
    void inject(GuanZhuFragment guanZhuFragment) ;
    void inject(FollowActivity followActivity);
    void inject(MyShouCangActivity shouCangActivity);
    void inject (VFollowFragment vFollowFragment);
    void inject(XiangQingActivity xiangQingActivity);
    void inject(TabFragment3 tabFragment3);
    void inject(VNearbyFragment vNearbyFragment);
    void inject (MySouActivity  mySouActivity);

}
