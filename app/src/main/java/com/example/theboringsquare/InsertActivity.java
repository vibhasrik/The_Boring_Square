package com.example.theboringsquare;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
//
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import org.kandukuri.bookshop.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
    }

    public void goBack(View v) {
        this.finish();
    }

    public void insert(View v) {
        // Retrieve name and price
        EditText nameEditText = ( EditText) findViewById( R.id.input_name );
        EditText priceEditText = ( EditText) findViewById( R.id.input_price );
        EditText genreEditText = ( EditText) findViewById( R.id.input_genre );
        EditText authorFirstEditText = ( EditText) findViewById( R.id.input_authorFirst );
        EditText authorLastEditText = ( EditText) findViewById( R.id.input_authorLast );
        EditText descriptionEditText = ( EditText) findViewById( R.id.input_description );
        EditText imgEditText = ( EditText) findViewById( R.id.input_img );
        String name = nameEditText.getText( ).toString( );
        String priceString = priceEditText.getText( ).toString( );
        String genreString = nameEditText.getText( ).toString( );
        String authorFirstString = nameEditText.getText( ).toString( );
        String authorLastString = nameEditText.getText( ).toString( );
        String descriptionString = nameEditText.getText( ).toString( );
        String imgString = nameEditText.getText( ).toString( );

        // insert new book in database

        DatabaseManager  dbManager = new DatabaseManager(this);
        try
        {
            double price = Double.parseDouble(priceString);
            Book book = new Book(0, name, price);
            dbManager.insert(book);
            Toast.makeText( this, "Book added", Toast.LENGTH_LONG ).show( );
        }
        catch (NumberFormatException nfe)
        {
            Toast.makeText( this, "Price Error", Toast.LENGTH_LONG ).show( );
        }

        // clear data
        nameEditText.setText("");
        priceEditText.setText("");

//        ArrayList<Book> candies = dbManager.selectAll( );
//        for( Book book : candies )
//            Log.w( "MainActivity", "book = " + book.toString( ) );

        //slide 84
    }

}
