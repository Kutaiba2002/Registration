package com.example.reistration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

private EditText edtName, edtEmail;
private RadioGroup radioGroup;
private RadioButton radioButton;
private Switch switchYear;
private Button btnSave;

private SharedPreferences prefs;
private SharedPreferences.Editor editor;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtEmail= findViewById(R.id.edtEmail);
        radioGroup = findViewById(R.id.radioGroup);
        btnSave = findViewById(R.id.btnSave);
        switchYear = findViewById(R.id.switchYear);

    }
    public void btnSaveOnClick(View v) {

        prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor = prefs.edit();
        Gson gson = new Gson();
        String nameText = edtName.getText().toString();
        String emailText = edtEmail.getText().toString();
        String genderStr = null;
        if(radioGroup.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // get selected radio button from radioGroup
            int selectedId = radioGroup.getCheckedRadioButtonId();
            // find the radiobutton by returned id
            radioButton = (RadioButton)findViewById(selectedId);
            genderStr = radioButton.getText().toString();
            //Toast.makeText(getApplicationContext(), radioButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();
        }
        boolean switchState;
        if(switchYear.isChecked()){
            switchState = true;
        }else {
            switchState = false;
        }

        String toString = gson.toJson(new Student(nameText,emailText,switchState,genderStr));
        editor.putString("jsonObject", toString);
        editor.commit();
        Toast.makeText(getApplicationContext(), toString, Toast.LENGTH_SHORT).show();
    }
}