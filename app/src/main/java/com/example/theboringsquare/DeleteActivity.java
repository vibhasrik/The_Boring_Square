package com.example.theboringsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    DatabaseManager dbManager = new DatabaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        updateView();
    }

    public void updateView() {
        ArrayList<Book> books = dbManager.selectAll();
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        RadioGroup radioGroup = new RadioGroup(this);

        for (Book book : books) {
            RadioButton rb = new RadioButton(this);
            rb.setId(book.getId());
            rb.setText(book.toString());
            radioGroup.addView(rb);
        }

        radioGroup.setOnCheckedChangeListener(new RadioButtonHandler());
        scrollView.addView(radioGroup);
        layout.addView(scrollView);

        setContentView(layout);
    }

    private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            dbManager.deleteById(checkedId);
            Toast.makeText(DeleteActivity.this, "Book deleted", Toast.LENGTH_SHORT).show();
            updateView();
        }
    }
}