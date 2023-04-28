package com.example.theboringsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void insertButton(View v) {
        Intent adminIntent = new Intent(v.getContext(), InsertActivity.class);
        startActivity(adminIntent);
    }

    public void deleteButton(View v) {
        Intent adminIntent = new Intent(v.getContext(), DeleteActivity.class);
        startActivity(adminIntent);
    }

    public void updateButton(View v) {
        Intent adminIntent = new Intent(v.getContext(), UpdateActivity.class);
        startActivity(adminIntent);
    }
}