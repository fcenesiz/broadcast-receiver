package com.cenesiz.broadcastreceiver01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CustomActionReceiver extends BroadcastReceiver {

    public static final String TAG = CustomActionReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "some data received!");
        Toast.makeText(context, "bottle is " + intent.getExtras().getString("bottle"), Toast.LENGTH_LONG).show();
    }

}
