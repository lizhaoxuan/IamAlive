package com.zhaoxuan.iamalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 广播接收器
 * 已经自Manifest里注册好了
 * Created by lizhaoxuan on 16/1/25.
 */
public class AlwaysWork extends BroadcastReceiver {

    private static final String TAG = "Alive";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String msg = intent.getStringExtra("msg");
        Log.d(TAG, "收到广播" + msg);
        new HttpThread().start();
    }

    class HttpThread extends Thread {
        @Override
        public void run() {
            try {
                URL url = new URL("http://www.baidu.com");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                Log.d(TAG, "响应码：" + conn.getResponseCode());
            } catch (Exception e) {
                Log.d(TAG, "访问失败");
                /**
                 * 点亮操作不应过于频繁
                 */
                AwakeTool.donotSleep();
                e.printStackTrace();

            }
        }
    }


}
