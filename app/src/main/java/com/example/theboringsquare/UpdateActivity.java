package com.example.theboringsquare;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    DatabaseManager dbManager = new DatabaseManager(this);
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        scrollView = new ScrollView(this);
        updateView();
    }

    public void updateView()
    {
        ArrayList<Book> books = dbManager.selectAll();
        scrollView.removeAllViews();
        GridLayout grid = new GridLayout(this);
        grid.setRowCount(books.size());
        grid.setColumnCount(8);

        Point size = new Point( );
        getWindowManager().getDefaultDisplay().getSize(size);
        int width = size.x;

        TextView[] ids = new TextView[books.size()];
        EditText[][] info = new EditText[books.size()][7];
        Button[] buttons = new Button[books.size()];

        for(int i = 0;  i < books.size(); i++)
        {
            Book book = books.get(i);

            ids[i] = new TextView(this);
            ids[i].setText("" + book.getId());

            info[i][0]= new EditText(this);
            info[i][1]= new EditText(this);
            info[i][2]= new EditText(this);
            info[i][3]= new EditText(this);
            info[i][4]= new EditText(this);
            info[i][5]= new EditText(this);
            info[i][6]= new EditText(this);

            info[i][0].setText(book.getName());
            info[i][1].setText("" + book.getPrice());
            info[i][2].setText("" + book.getGenre());
            info[i][3].setText("" + book.getAuthorFirst());
            info[i][4].setText("" + book.getAuthorLast());
            info[i][5].setText("" + book.getDescription());
            info[i][6].setText("" + book.getImg());


            info[i][0].setId( 10 * book.getId( ) );
            info[i][1].setId( 10 * book.getId( ) + 1 );
            info[i][2].setId( 10 * book.getId( ) + 2 );
            info[i][3].setId( 10 * book.getId( ) + 3 );
            info[i][4].setId( 10 * book.getId( ) + 4 );
            info[i][5].setId( 10 * book.getId( ) + 5 );
            info[i][6].setId( 10 * book.getId( ) + 6 );

            buttons[i] = new Button( this );
            buttons[i].setText( "Update" );
            buttons[i].setId( book.getId( ) );

            ButtonHandler bh = new ButtonHandler();
            buttons[i].setOnClickListener(bh);

            grid.addView( ids[i], width / 10, ViewGroup.LayoutParams.WRAP_CONTENT );
            grid.addView( info[i][0], width / 2, ViewGroup.LayoutParams.WRAP_CONTENT );
            grid.addView( info[i][1], width / (100/15), ViewGroup.LayoutParams.WRAP_CONTENT );
            grid.addView( buttons[i], width / 4, ViewGroup.LayoutParams.WRAP_CONTENT );
        }

        scrollView.addView(grid);
        setContentView(scrollView);
    }

    private class ButtonHandler implements View.OnClickListener
    {
        public void onClick(View v)
        {
            int bookId = v.getId();
            EditText nameET = (EditText)findViewById(10 * bookId);
            EditText priceET = (EditText)findViewById(10 * bookId + 1);
            EditText genreET = (EditText)findViewById(10 * bookId + 2);
            EditText authorFirstET = (EditText)findViewById(10 * bookId + 3);
            EditText authorLastET = (EditText)findViewById(10 * bookId + 4);
            EditText descriptionET = (EditText)findViewById(10 * bookId + 5);
            EditText imgET = (EditText)findViewById(10 * bookId + 6);


            String name = nameET.getText().toString();
            String priceString = priceET.getText().toString();
            String genre = genreET.getText().toString();
            String authorFirst = authorFirstET.getText().toString();
            String authorLast = authorLastET.getText().toString();
            String description = descriptionET.getText().toString();
            String img = imgET.getText().toString();

            try {
                Double price = Double.parseDouble(priceString);
                dbManager.updateById(bookId, name, price, genre, authorFirst, authorLast, description, img);
                Toast.makeText( UpdateActivity.this, "Book Updated", Toast.LENGTH_SHORT ).show( );
            }
            catch (NumberFormatException nfe)
            {
                Toast.makeText( UpdateActivity.this, "Price error", Toast.LENGTH_SHORT ).show( );
            }
            updateView();
        }
    }
}