package com.cenesiz.broadcastreceiver01;

import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cenesiz.broadcastreceiver01.databinding.ActivityMainBinding;

// BroadcastReceiver works on ui thread as async
public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // using implicit intent
        registerReceiver(new AirplaneModeReceiver(), new IntentFilter("android.intent.action.AIRPLANE_MODE"));

        // using explicit intent
        binding.buttonReceiver.setOnClickListener(view -> {
            Log.i(TAG, "data send to receiver!");
            Intent intent = new Intent(this, CustomBroadcastReceiver.class);
            intent.putExtra("weather", "sunshine");
            sendBroadcast(intent);
        });

        // using explict intent with action
        // setAction is required when using it your own code, otherwise it's not required for other app usages
        binding.buttonCustomActionReceiver.setOnClickListener(view -> {
            Log.i(TAG, "data send to receiver!");
            Bundle bundle = new Bundle();
            bundle.putString("bottle", "half fill");
            Intent intent = new Intent(this, CustomActionReceiver.class).setAction(getString(R.string.custom_action_receiver));
            intent.putExtras(bundle);
            sendBroadcast(intent);
        });
    }



}