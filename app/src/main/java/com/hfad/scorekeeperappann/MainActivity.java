package com.hfad.scorekeeperappann;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int left_Score = 0;
    private int right_Score = 0;
    private boolean running = false;
    public static final String LEFT_SCORE = "leftScore";
    public static final String RIGHT_SCORE = "rightScore";
    public static final String RUNNING_KEY = "running";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLeft = (Button) findViewById(R.id.button2);
        Button btnRight = (Button) findViewById(R.id.button);
        TextView tvLeft = (TextView) findViewById(R.id.textView3);
        TextView tvRight = (TextView) findViewById(R.id.textView4);


        if (savedInstanceState != null)
        {

//Restore the values from the bundle for offset/running
            left_Score = savedInstanceState.getInt(LEFT_SCORE);
            right_Score = savedInstanceState.getInt(RIGHT_SCORE);
            running = savedInstanceState.getBoolean(RUNNING_KEY);

//If the stopwatch is in the middle of running,
// we need to directly set the base time to whatever it was
// at the start of the run and start the clock.
//Otherwise, we can just call the setBaseTime() method like we usually do
        }
            




        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                left_Score++;

                System.out.println(left_Score);
                tvLeft.setText(Integer.toString(left_Score));
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right_Score++;

                System.out.println(right_Score);
                tvRight.setText(Integer.toString(right_Score));

            }
        });



    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
//call the parent method and let it do its thing.
//I get a warning if I do not do this.
        super.onSaveInstanceState(savedInstanceState);
//Save the state of our activities' special properties
        savedInstanceState.putInt(LEFT_SCORE, left_Score);
        savedInstanceState.putInt(RIGHT_SCORE, right_Score);
        savedInstanceState.putBoolean(RUNNING_KEY, running);
    }

}