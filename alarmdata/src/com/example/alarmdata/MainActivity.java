package com.example.alarmdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onClick(View view) {
    	
    	Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
        .putExtra(AlarmClock.EXTRA_MESSAGE, "Buenos dias")
        .putExtra(AlarmClock.EXTRA_HOUR, 15)
        .putExtra(AlarmClock.EXTRA_MINUTES, 00);
    	if (intent.resolveActivity(getPackageManager()) != null) {
    		startActivity(intent);
    	}

    }
}
