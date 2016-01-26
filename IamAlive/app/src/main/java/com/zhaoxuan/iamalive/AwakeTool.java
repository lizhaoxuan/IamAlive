package com.zhaoxuan.iamalive;

import android.os.PowerManager;

/**
 * 唤醒工具类
 * Created by lizhaoxuan on 16/1/25.
 */
public class AwakeTool {

    private AwakeTool(){}

    /**
     * 不要再睡啦！！！
     * 屏幕会亮一下下，不建议太平凡，用户会抱怨。
     * 但是可以发一些本地缓存的通知消息啥的掩饰一下下
     */
    public static void donotSleep(){
        PowerManager pm = (PowerManager) AliveApplication.getContext().getSystemService(
                AliveApplication.getContext().POWER_SERVICE);
        PowerManager.WakeLock mWakelock = pm.newWakeLock(
                PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "target");
        //下面这行代码实现点亮屏幕，
        mWakelock.acquire();
        //记得release
        mWakelock.release();
    }

}
