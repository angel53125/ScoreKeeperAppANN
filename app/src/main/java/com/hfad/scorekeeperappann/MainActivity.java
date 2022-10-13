package com.hfad.scorekeeperappann;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int tv_left_Score = 0;
    private int tv_right_Score = 0;
    private boolean running = false;
    public static final String LEFT_SCORE = "leftScore";
    public static final String RIGHT_SCORE = "rightScore";
    public static final String RUNNING_KEY = "running";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLeft = (Button) findViewById(R.id.buttonLeft);
        Button btnRight = (Button) findViewById(R.id.buttonRight);
        TextView tvRight = (TextView) findViewById(R.id.textViewRight);
        TextView tvLeft = (TextView) findViewById(R.id.textViewLeft);


        if (savedInstanceState != null)
        {
            //Restore the values from the bundle for offset/running
            tv_left_Score = savedInstanceState.getInt(LEFT_SCORE);
            tv_right_Score = savedInstanceState.getInt(RIGHT_SCORE);
            running = savedInstanceState.getBoolean(RUNNING_KEY);
            tvLeft.setText(Integer.toString(tv_left_Score));
            tvRight.setText(Integer.toString(tv_right_Score));
        }





        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_left_Score++;

                System.out.println(tv_left_Score);
                tvLeft.setText(Integer.toString(tv_left_Score));
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_right_Score++;
                System.out.println(tv_right_Score);
                tvRight.setText(Integer.toString(tv_right_Score));
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

//Save the state of our activities' special properties
        savedInstanceState.putInt(LEFT_SCORE, tv_left_Score);
        savedInstanceState.putInt(RIGHT_SCORE, tv_right_Score);
        savedInstanceState.putBoolean(RUNNING_KEY, running);
    }

}