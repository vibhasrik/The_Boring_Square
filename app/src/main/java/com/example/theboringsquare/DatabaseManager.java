package com.example.theboringsquare;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "bookDB";
    private static final int DATABASE_VERSION = 1;
    
    private static final String TABLE_BOOK = "book";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String GENRE = "genre";
    private static final String DESCRIPTION = "description";
    private static final String AUTHORFIRST = "authorFirst";
    private static final String AUTHORLAST = "authorLast";
    private static final String IMG = "img";
    private static final String PRICE = "price";

    public DatabaseManager( Context context ) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    public void onCreate( SQLiteDatabase db ) {
        // build sql create statement
        String sqlCreate = "create table " + TABLE_BOOK + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + NAME;
        sqlCreate += " text, " + PRICE + " real )";
        db.execSQL(sqlCreate);
    }

    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        // Drop old table if it exists
        db.execSQL( "drop table if exists " + TABLE_BOOK );
        // Re-create tables
        onCreate( db );
    }

    // Insert book into database
    public void insert( Book book ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_BOOK;
        sqlInsert += " values( null, '" + book.getName( );
        sqlInsert += "', '" + book.getPrice( ) + "' )";
        db.execSQL( sqlInsert );
        db.close( );
    }

    // Delete book from database
    public void deleteById( int id ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlDelete = "delete from " + TABLE_BOOK;
        sqlDelete += " where " + ID + " = " + id;
        Log.w("DatabaseManager", sqlDelete);
        db.execSQL( sqlDelete );
        db.close();
    }

    //point size = new point();
    //getWindowManager().getDefaultDisplay().getSize(size);
    //buttonWidth = size/7;

    // Update book record
    public void updateById( int id, String name, double price, String genre, String authorFirst, String authorLast, String description, String img ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlUpdate = "update " + TABLE_BOOK;
        sqlUpdate += " set " + NAME + " = \"" + name + "\", " +
                PRICE + " = " + price +
                GENRE + " = \"" + genre + "\", " +
                AUTHORFIRST + " = \"" + authorFirst + "\", " +
                AUTHORLAST + " = \"" + authorLast + "\", " +
                DESCRIPTION + " = \"" + description + "\", " +
                IMG + " = \"" + img + "\", " +
                " where " +
                ID + " = " + id;
        db.execSQL( sqlUpdate );
//        sqlUpdate = "update " + TABLE_BOOK;
//        sqlUpdate += " set " + PRICE + " = " + price + " where " + ID + " = " + id;
//        db.execSQL( sqlUpdate );
        db.close();
    }


    // Return list of all candies
    public ArrayList<Book> selectAll( ) {
        ArrayList<Book> candies = new ArrayList<Book>();
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlQuery = "select * from " + TABLE_BOOK;
        Cursor cursor = db.rawQuery( sqlQuery, null );
        while( cursor.moveToNext( ) ) {
            Book currentBook = new Book( Integer.parseInt(
                    cursor.getString( 0 ) ),
                    cursor.getString( 1 ), cursor.getDouble( 2 ) );
            candies.add( currentBook );
        }
        db.close( );

        return candies;
    }

    // Select book by id
    public Book selectById( int id ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlQuery = "select * from " + TABLE_BOOK;
        sqlQuery += " where " + ID + " = " + id;
        Cursor cursor = db.rawQuery( sqlQuery, null );
        Book book = null;
        if( cursor.moveToFirst( ) )
            book = new Book(
                    Integer.parseInt( cursor.getString( 0 ) ),
                    cursor.getString( 1 ),
                    cursor.getDouble( 2 ) );
        return book;
    }

}

