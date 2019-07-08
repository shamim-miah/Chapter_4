package com.example.chapter_4;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    public int sec=0;
    public boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onClickStart(View view){
        run = true;
    }
    public void onClickStop(View view){
        run = false;
    }
    public void onClickReset(View view){
        run = false;
        sec=0;
    }

    private void runTimer() {

        final TextView timeView=(TextView)findViewById(R.id.text);
        final Handler handler=new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=sec/3600;
                int min=(sec%3600)/60;
                int secs=sec%60;
                String time= String.format("%d:%02d:%02d",hours,min,secs);
                timeView.setText(time);

                if(run){
                    sec++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
