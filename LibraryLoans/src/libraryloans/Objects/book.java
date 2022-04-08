/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 * Inherits data from Item.
 * 
 */
public class book extends Item {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    protected String author;
    
    
    
    // constructor to initialise the data in items
    
    public book(String barcode, String author, String title, String type, String year, String isbn){
        super(barcode, title, type, year, isbn);
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }
    
    
    // Overriding the Item getMaxRenews method
    @Override
    public int getMaxRenews(){
    int maxRenews = 3;
    return maxRenews;
    }
    
    // Overriding the toString method to print easily
    @Override
    public String toString(){
        return "Barcode: " + super.barcode
                + "\nAuthor: " 
                + this.author 
                + "\nTitle: " + super.title 
                + "\nType: " + super.type 
                +  "\nYear: " + super.year 
                + "\nISBN: " + super.isbn 
                + "\n\n" ;
    } 
    
    
}
