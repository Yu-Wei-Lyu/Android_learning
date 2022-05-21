package com.example.a109590004hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String str;
    private CheckBox[] mCheckBox = new CheckBox[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBox[0] = findViewById(R.id.checkBox);
        mCheckBox[1] = findViewById(R.id.checkBox2);
        mCheckBox[2] = findViewById(R.id.checkBox3);
        mCheckBox[3] = findViewById(R.id.checkBox4);
        mCheckBox[4] = findViewById(R.id.checkBox5);

    }

    public void showToastBtn(View view) {
        str = "Toppings : ";
        for(int i = 0; i < 5; i++){
            if(mCheckBox[i].isChecked()){
                str += mCheckBox[i].getText().toString() + ' ';
            }
        }
        Toast toast = Toast.makeText(this, str,Toast.LENGTH_SHORT);
        toast.show();
    }
}