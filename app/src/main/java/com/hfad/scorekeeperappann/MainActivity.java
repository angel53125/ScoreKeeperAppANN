package com.hfad.scorekeeperappann;

/*
@author Angel Negron

This app increases two different teams scores
While maintaining data when the screen rotates
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int tv_left_Score = 0;  //Left Score score
    private int tv_right_Score = 0; //Right Score score
    private boolean running = false;
    public static final String LEFT_SCORE = "leftScore";
    public static final String RIGHT_SCORE = "rightScore";
    public static final String RUNNING_KEY = "running";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Buttons and text views
        Button btnLeft = (Button) findViewById(R.id.button_Left);
        Button btnRight = (Button) findViewById(R.id.button_Right);
        TextView tvRight = (TextView) findViewById(R.id.textView_Right);
        TextView tvLeft = (TextView) findViewById(R.id.textView_Left);


        if (savedInstanceState != null)
        {
            //Restore the values from the bundle for offset/running
            tv_left_Score = savedInstanceState.getInt(LEFT_SCORE);
            tv_right_Score = savedInstanceState.getInt(RIGHT_SCORE);
            running = savedInstanceState.getBoolean(RUNNING_KEY);
            tvLeft.setText(Integer.toString(tv_left_Score));
            tvRight.setText(Integer.toString(tv_right_Score));
        }




    /*
    When this button is pressed the left score will increase
     */
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_left_Score++; //Increase Score

                System.out.println(tv_left_Score);
                tvLeft.setText(Integer.toString(tv_left_Score)); //Set text
            }
        });

        /*
        When this button is pressed the right score will increase
         */
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_right_Score++; //Increase Score

                System.out.println(tv_right_Score);
                tvRight.setText(Integer.toString(tv_right_Score)); //Set Text
            }
        });
    }


    /**
     * Saves the variable when the state of the app is destroyed and created again
     * @param savedInstanceState
     */
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