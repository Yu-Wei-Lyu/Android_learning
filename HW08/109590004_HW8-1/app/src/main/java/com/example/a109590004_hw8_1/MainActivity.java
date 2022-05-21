package com.example.a109590004_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int count;
    private ImageView battery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery = (ImageView) findViewById(R.id.imageView);
        count = 3;
        battery.setImageLevel(count);
    }

    public void btnClickPlus(View view) {
        if(count < 6){
            count += 1;
        }
        battery.setImageLevel(count);
    }

    public void btnClickMin(View view) {
        if(count > 0){
            count -= 1;
        }
        battery.setImageLevel(count);
    }
}