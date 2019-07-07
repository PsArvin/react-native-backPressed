package com.xxxx;

import com.facebook.react.ReactActivity;

import com.scodi.backPressed.RNBackPressedModule;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * 添加返回键监听
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        RNBackPressedModule.uniqueInstance.sendEvent();
    }
}
