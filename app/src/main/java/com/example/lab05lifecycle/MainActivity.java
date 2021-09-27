package com.example.lab05lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
SharedPreferences sharedpreferences;
SharedPreferences.Editor editor;
int countonCreate=0;
int countonStart=0;
int countonResume=0;
int countonPause=0;
int countonStop=0;
int countonRestart=0;
int countonDestroy=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences("Values", MODE_PRIVATE);
        editor = sharedpreferences.edit();
        setInitialValues();

    }

    private void setInitialValues() {
        countonCreate=sharedpreferences.getInt("onCreate", 0);
        countonStart=sharedpreferences.getInt("onStart", 0);
        countonResume=sharedpreferences.getInt("onResume", 0);
        countonPause=sharedpreferences.getInt("onPause", 0);
        countonStop=sharedpreferences.getInt("onStop", 0);
        countonRestart=sharedpreferences.getInt("onRestart", 0);
        countonDestroy=sharedpreferences.getInt("onDestroy", 0);
    }
    private void storeValues(){
        editor.putInt("onCreate",countonCreate);
        editor.putInt("onStart",countonStart);
        editor.putInt("onResume",countonResume);
        editor.putInt("onPause",countonPause);
        editor.putInt("onStop",countonStop);
        editor.putInt("onRestart",countonRestart);
        editor.putInt("onDestroy",countonDestroy);
        editor.apply();
        System.out.println("Values onCreate: " + countonCreate);
        System.out.println("Values onStart: " + countonStart);
        System.out.println("Values onResume: " + countonResume);
        System.out.println("Values onPause: " + countonPause);
        System.out.println("Values onStop: " + countonStop);
        System.out.println("Values onRestart: " + countonRestart);
        System.out.println("Values onDestroy: " + countonDestroy);
        System.out.println("=====================================");

    }
    private void erase(){
        editor.remove("Values").commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countonPause++;
        storeValues();
    }

    @Override
    protected void onStart() {
        super.onStart();
        countonStart++;
        storeValues();
    }
}