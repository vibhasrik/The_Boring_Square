package com.example.theboringsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

//    public void updateView()
//    {
//        Log.w("WelcomeActivity", "updateView");
//        ButtonHandler bh = new ButtonHandler();
//        Button adminButton =(Button) findViewById( R.id.adminButton );
//        adminButton.setOnClickListener(bh);
//        Button customerButton =(Button) findViewById( R.id.customerButton );
//        customerButton.setOnClickListener(bh);
//
//    }

    public void modifyDataAdmin(View v) {
        Intent adminIntent = new Intent(v.getContext(), LoginActivity.class);
        startActivity(adminIntent);
    }

    public void modifyDataCustomer(View v) {
        Intent customerIntent = new Intent(v.getContext(), BookstoreActivity.class);
        startActivity(customerIntent);
    }
}
//    private class ButtonHandler implements View.OnClickListener {
//        public void onClick(View v) {
//            Log.w("WelcomeActivity", "onClick");
//            int id = v.getId();
//            switch (id) {
//                case R.id.adminButton:
//                    Intent adminIntent = new Intent(v.getContext(), LoginActivity.class);
//                    startActivity(adminIntent);
//                    return;
//                case R.id.customerButton:
//                    Intent customerIntent = new Intent(v.getContext(), BookstoreActivity.class);
//                    startActivity(customerIntent);
//                    return;
//            }
//            updateView();
//        }
//    }
//}