package com.zhaoxuan.iamalive;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Alive";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * AlarmManager 定时发送广播。广播接收器收到广播后会请求网络
         */
        Intent intent = new Intent("Alive");
        intent.putExtra("msg", "看看网络还通不~");
        PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10 * 1000, pi);
        Log.d(TAG, "start");

    }
}
