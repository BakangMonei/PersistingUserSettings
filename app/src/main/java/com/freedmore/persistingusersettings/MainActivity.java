package com.freedmore.persistingusersettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    RadioButton rdBtnBlue, rdBtnBrown, rdBtnGreen;

    SharedPreferences colorPrefs;
    SharedPreferences.Editor editor;

    String selectedColor;
    String savedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View layout = findViewById(R.id.myLayout);
        colorPrefs = getSharedPreferences("myPrefs",MODE_PRIVATE);
        editor = colorPrefs.edit();

        rdBtnBlue = findViewById(R.id.radioButtonBlue);
        rdBtnBrown = findViewById(R.id.radioButtonBrown);
        rdBtnGreen = findViewById(R.id.radioButtonGreen);
        btnSave = findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdBtnBlue.isChecked()){
                    selectedColor = "blue";
                }
                if(rdBtnBrown.isChecked()){
                    selectedColor ="brown";
                }
                if(rdBtnGreen.isChecked()){
                    selectedColor ="green";
                }

                editor.putString("key_color",selectedColor);
                editor.commit();
            }
        });

        if(colorPrefs.contains("key_color")){
            savedColor = colorPrefs.getString("key_color","white");
            if(savedColor.equals("blue")) {
                layout.setBackgroundColor(getResources().getColor(R.color.my_blue));
            }
            if(savedColor.equals("brown")) {
                layout.setBackgroundColor(getResources().getColor(R.color.my_brown));
            }
            if(savedColor.equals("green")) {
                layout.setBackgroundColor(getResources().getColor(R.color.my_green));
            }
        }

    }
}