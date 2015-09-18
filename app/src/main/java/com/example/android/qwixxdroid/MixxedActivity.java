package com.example.android.qwixxdroid;

import android.os.Bundle;

/**
 * Created by Benjamin on 16.07.2015.
 */
public class MixxedActivity extends ClassicActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixxed);
    }

    @Override
    protected void makeButtons() {
        //red buttons
        makeButton(R.id.first_2_button, MyColor.YELLOW, 1, 1);
        makeButton(R.id.first_3_button, MyColor.YELLOW, 2, 1);
        makeButton(R.id.first_4_button, MyColor.YELLOW, 3, 1);
        makeButton(R.id.first_5_button, MyColor.BLUE, 4, 1);
        makeButton(R.id.first_6_button, MyColor.BLUE, 5, 1);
        makeButton(R.id.first_7_button, MyColor.BLUE, 6, 1);
        makeButton(R.id.first_8_button, MyColor.GREEN, 7, 1);
        makeButton(R.id.first_9_button, MyColor.GREEN, 8, 1);
        makeButton(R.id.first_10_button, MyColor.GREEN, 9, 1);
        makeButton(R.id.first_11_button, MyColor.RED, 10, 1);
        makeButton(R.id.first_12_button, MyColor.RED, 11, 1);
        makeButton(R.id.first_lock_button, MyColor.RED, 12, 1);

        //yellow buttons
        makeButton(R.id.second_2_button, MyColor.RED, 1, 2);
        makeButton(R.id.second_3_button, MyColor.RED, 2, 2);
        makeButton(R.id.second_4_button, MyColor.GREEN, 3, 2);
        makeButton(R.id.second_5_button, MyColor.GREEN, 4, 2);
        makeButton(R.id.second_6_button, MyColor.GREEN, 5, 2);
        makeButton(R.id.second_7_button, MyColor.GREEN, 6, 2);
        makeButton(R.id.second_8_button, MyColor.BLUE, 7, 2);
        makeButton(R.id.second_9_button, MyColor.BLUE, 8, 2);
        makeButton(R.id.second_10_button, MyColor.YELLOW, 9, 2);
        makeButton(R.id.second_11_button, MyColor.YELLOW, 10, 2);
        makeButton(R.id.second_12_button, MyColor.YELLOW, 11, 2);
        makeButton(R.id.second_lock_button, MyColor.YELLOW, 12, 2);

        //green buttons
        makeButton(R.id.third_12_button, MyColor.BLUE, 1, 3);
        makeButton(R.id.third_11_button, MyColor.BLUE, 2, 3);
        makeButton(R.id.third_10_button, MyColor.BLUE, 3, 3);
        makeButton(R.id.third_9_button, MyColor.YELLOW, 4, 3);
        makeButton(R.id.third_8_button, MyColor.YELLOW, 5, 3);
        makeButton(R.id.third_7_button, MyColor.YELLOW, 6, 3);
        makeButton(R.id.third_6_button, MyColor.RED, 7, 3);
        makeButton(R.id.third_5_button, MyColor.RED, 8, 3);
        makeButton(R.id.third_4_button, MyColor.RED, 9, 3);
        makeButton(R.id.third_3_button, MyColor.GREEN, 10, 3);
        makeButton(R.id.third_2_button, MyColor.GREEN, 11, 3);
        makeButton(R.id.third_lock_button, MyColor.GREEN, 12, 3);

        //blue buttons
        makeButton(R.id.fourth_12_button, MyColor.GREEN, 1, 4);
        makeButton(R.id.fourth_11_button, MyColor.GREEN, 2, 4);
        makeButton(R.id.fourth_10_button, MyColor.RED, 3, 4);
        makeButton(R.id.fourth_9_button, MyColor.RED, 4, 4);
        makeButton(R.id.fourth_8_button, MyColor.RED, 5, 4);
        makeButton(R.id.fourth_7_button, MyColor.RED, 6, 4);
        makeButton(R.id.fourth_6_button, MyColor.YELLOW, 7, 4);
        makeButton(R.id.fourth_5_button, MyColor.YELLOW, 8, 4);
        makeButton(R.id.fourth_4_button, MyColor.BLUE, 9, 4);
        makeButton(R.id.fourth_3_button, MyColor.BLUE, 10, 4);
        makeButton(R.id.fourth_2_button, MyColor.BLUE, 11, 4);
        makeButton(R.id.fourth_lock_button, MyColor.BLUE, 12, 4);
    }
}
