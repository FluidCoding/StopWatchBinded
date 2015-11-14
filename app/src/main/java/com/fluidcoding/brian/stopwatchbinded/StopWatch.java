package com.fluidcoding.brian.stopwatchbinded;
import android.databinding.*;
import android.os.Handler;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.fluidcoding.brian.stopwatchbinded.databinding.ActivityStopWatchBinding;

public class StopWatch extends AppCompatActivity {
    WatchTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityStopWatchBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_stop_watch);
        time = new WatchTime();
        bind.setWatch(time);
    }

    public void onStartClick(View v){
        time.start();
    }

    public void onStopClick(View v){
        time.stop();
    }

    public void onResetClick(View v){
        time.reset();
    }
}