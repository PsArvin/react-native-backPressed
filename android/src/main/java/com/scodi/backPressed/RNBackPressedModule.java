package com.scodi.backPressed;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import com.facebook.react.bridge.Arguments;


public class RNBackPressedModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    // 实例化类
    public volatile static RNBackPressedModule uniqueInstance = null;

    //采用Double CheckLock(DCL)实现单例
    public static RNBackPressedModule getInstance(ReactApplicationContext reactContext) {
        reactContext = reactContext;
        if (uniqueInstance == null) {
            synchronized (RNBackPressedModule.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new RNBackPressedModule(reactContext);
                }
            }
        }
        return uniqueInstance;
    }

    public RNBackPressedModule(ReactApplicationContext reactContext) {
        super(reactContext);

        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "SCODI_BACK_ANDROID";
    }


    /**
     * 发送事件
     */
    public void sendEvent() {
        WritableMap data = Arguments.createMap();
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("RNBackHandler", data);
    }
}

