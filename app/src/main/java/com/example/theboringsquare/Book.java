package com.example.theboringsquare;

public class Book {
    private int id;
    private String name;
    private String authorFirst;
    private String authorLast;
    private String genre;
    private String img;
    private String description;
    private double price;

    public Book( int newId, String newName, double newPrice ) {
        setId( newId );
        setName( newName );
        setPrice( newPrice );
    }

    // S E T T E R   M E T H O D S
    public void setId( int newId ) {
        id = newId;
    }

    public void setName( String newName ) {
        name = newName;
    }
    public void setPrice( double newPrice ) {
        if( newPrice >= 0.0 )
            price = newPrice;
    }

    public void setGenre( String newGenre ) {
        genre = newGenre;
    }

    public void setAuthorFirst( String newAuthorFirst ) {
        authorFirst = newAuthorFirst;
    }

    public void setAuthorLast( String newAuthorLast ) {
        authorLast = newAuthorLast;
    }

    public void setImg( String newImg ) {
        img = newImg;
    }

    public void setDescription( String newDescription ) {
        description = newDescription;
    }

    // G E T T E R   M E T H O D S

    public int getId( ) {
        return id;
    }

    public String getName( ) {
        return name;
    }

    public double getPrice( ) {
        return price;
    }

    public String getGenre( ) {
        return genre;
    }

    public String getImg( ) {
        return img;
    }

    public String getDescription( ) {
        return description;
    }

    public String getAuthorFirst( ) {
        return authorFirst;
    }

    public String getAuthorLast( ) {
        return authorLast;
    }

    public String toString( ) {
        return id + "; " + name + "; " + price;
    }
}


