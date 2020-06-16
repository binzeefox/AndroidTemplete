package com.binzeefox.foxframe.core.base;

import android.annotation.SuppressLint;
import android.app.Application;

import com.binzeefox.foxframe.core.FoxCore;

/**
 * 自定义Application
 * @author binze
 * 重构自 2019/12/9 10:28
 */
@SuppressLint("Registered")
public abstract class FoxApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //核心
        FoxCore core = FoxCore.init(this);
    }

    /* 2020/06/10 12:00 */
    /* 这个回调比较鸡肋，决定移除掉 */
    /* 2020/06/16 14:28 */
    /* 发现错误，还是放回来吧 */

    /**
     * 获取内容提供者授权信息, 默认为空
     * @author binze 2019/12/11 11:48
     */
    public String getAuthority(){
        return null;
    }
}
