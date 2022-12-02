package com.cenesiz.broadcastreceiver01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    public static final String TAG = AirplaneModeReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean state = intent.getBooleanExtra("state", false);
        String message = "connection state changed to " + state;
        Log.i(TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
