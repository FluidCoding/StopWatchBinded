package com.fluidcoding.brian.stopwatchbinded;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.os.Handler;

import com.fluidcoding.brian.stopwatchbinded.BR;

/**
 * Created by brian on 10/29/2015.
 */
public class WatchTime extends BaseObservable {
    private boolean running;
    private String seconds;
    private Long startTime;
    private Long stopTime;

    public WatchTime(int seconds) {
        this.seconds = String.valueOf(seconds);
    }

    public WatchTime() {
        running = false;
        startTime = 0L;
        stopTime=0L;
        seconds = "";
        final Handler h = new Handler();

        h.post(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    setSeconds((System.currentTimeMillis() - startTime) / 1000L);
                }
                h.postDelayed(this, 1000);
            }
        });
    }

    public void start() {
        running = true;
        if (startTime != 0)
            startTime = System.currentTimeMillis() - (stopTime-startTime);
        else
            startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
        running = false;
    }

    public void reset() {
        running = false;
        startTime = 0L;
        stopTime = 0L;
        setSeconds(0L);
    }

    @Bindable
    public String getSeconds() {
        return seconds;
    }

    @Bindable
    public void setSeconds(Long seconds) {
        this.seconds = String.valueOf(seconds);
        notifyPropertyChanged(BR.seconds);
    }
}