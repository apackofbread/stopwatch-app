package com.example.stopwatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.app.Activity;


import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class stopw extends AppCompatActivity {

    private int seconds=0;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopw);
        runTimer();

    }
    public void onClickStart(View view)
    {
        running=true;
        Toast.makeText(getApplicationContext(),"stopwatch start",Toast.LENGTH_SHORT).show();
    }
    public void onClickStop(View view)
    {
        running=false;
        Toast.makeText(getApplicationContext(),"stopwatch stopped",Toast.LENGTH_SHORT).show();

    }
    public void onClickReset(View view)
    {
        running=false;
        seconds=0;
        Toast.makeText(getApplicationContext(),"stopwatch reset",Toast.LENGTH_SHORT).show();

    }

    private void runTimer()
    {


        final TextView time_view=findViewById(R.id.time_view);

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;

                String time= String.format("%d:%02d:%02d",hours,minutes,secs);

                time_view.setText(time);

                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);

            }
        });



    }


}
