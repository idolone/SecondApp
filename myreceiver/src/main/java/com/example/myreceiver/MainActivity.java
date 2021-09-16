package com.example.myreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KIN";
    private static final String TAG_ACTION = "com.example.myreceiver_flag_";
    private Object context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册动态的
        UpdateReceiver updateReceiver = new UpdateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("MotiveBroadcast");
        registerReceiver(updateReceiver,filter);


    }

    public void staticonclick(View view) {
        Log.d(TAG, "staticonclick: ");
        Intent intent = new Intent();
        intent.setAction(TAG_ACTION);
        intent.setComponent(new ComponentName("com.example.myreceiver","com.example.myreceiver.MyReciever"));
        sendBroadcast(intent);

//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName(TAG_ACTION,"com.example.myreceiver.MyReciever"));
//        getApplicationContext().sendBroadcast(intent);
    }

    public void motiveBroad(View view) {
        Log.d(TAG, "motiveBroad: ");
        Intent intent = new Intent();
        intent.setAction("MotiveBroadcast");
       // intent.setComponent(new ComponentName("com.example.myreceiver","com.example.myreceiver.UpdateReceiver"));
        sendBroadcast(intent);
    }
}