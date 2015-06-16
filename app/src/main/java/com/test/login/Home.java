package com.test.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.pushbots.push.Pushbots;

/**
 * Created by amrsobhy on 6/16/15.
 */
public class Home extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        String name =getIntent().getStringExtra("name");
        TextView hello =(TextView)findViewById(R.id.helloworld);
        hello.setText("Hello " + name + "!");

        Switch notificationSwitch = (Switch) findViewById(R.id.notifications);
        //set the switch to ON
        notificationSwitch.setChecked(true);

        //attach a listener to check for changes in state
        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if(isChecked){
                    Log.e("PB", "Notifications is currently ON");
                    Pushbots.sharedInstance().setPushEnabled(true);
                    Pushbots.sharedInstance().register();
                }else{
                    Log.e("PB", "Notifications is currently OFF");
                    Pushbots.sharedInstance().setPushEnabled(false);
                    Pushbots.sharedInstance().unRegister();
                }

            }
        });




    }



}
