#react-native-backPressed

使用 npm 源
npm install react-native-backPressed --save  或者 yarn react-native-backPressed

原生模块导入
Android Studio
react-native link react-native-backPressed

使用方法
1、 MainActivity添加返回键监听

@Override
public void onBackPressed() {
    super.onBackPressed();
    RNBackPressedModule.uniqueInstance.sendEvent();
}

2、js 添加监听函数

import {
  NativeModules,
  NativeEventEmitter,
  BackHandler,
  ToastAndroid
} from 'react-native';

const NativeModule = new NativeEventEmitter(NativeModules.SCODI_BACK_ANDROID);

componentWillMount() {
    this.naiveBackHandler = NativeModule.addListener('RNBackHandler', this.handleBackPress);
}

componentWillUnmount() {
    this.naiveBackHandler.remove();
}

handleBackPress = () => {
  if (this.lastBackPressed && this.lastBackPressed + 2000 >= Date.now()) {
    BackHandler.exitApp();
    return;
  }

  this.lastBackPressed = Date.now();
  ToastAndroid.show("再按一次退出应用", ToastAndroid.SHORT);
}
