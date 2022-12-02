package com.cenesiz.broadcastreceiver01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = CustomBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "some data received!");
        Toast.makeText(context, "weather is " + intent.getExtras().getString("weather"), Toast.LENGTH_LONG).show();
    }

}
