package com.binzeefox.foxframe.core.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import com.binzeefox.foxframe.core.FoxCore;

/**
 * 自定义Application
 * @author binze
 * 重构自 2019/12/9 10:28
 */
@SuppressLint("Registered")
public class FoxApplication extends Application {
    private static final String TAG = "FoxApplication";
    private FoxCore core;

    @Override
    public void onCreate() {
        super.onCreate();
        //核心
        core = FoxCore.init(this);
    }

    /**
     * 获取内容提供者授权信息, 默认为包名加 .authority
     * @author binze 2019/12/11 11:48
     */
    public String getAuthority(){
        if (core == null) {
            Log.e(TAG, "getAuthority: app 尚未完成初始化" );
            return null;
        }
        return core.getPackageInfo().packageName + ".authority";
    }
}
