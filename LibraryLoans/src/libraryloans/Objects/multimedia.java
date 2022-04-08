/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 * Inherits data from Item
 */
public class multimedia extends Item {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    protected String artist;

    // constructor to initialise the data in items
    
    public multimedia(String barcode, String artist, String title, String type, String year, String isbn){
        super(barcode, title, type, year, isbn);
        this.artist = artist;
    }

    public String getArtist(){
        return artist;
    }
    // Overriding Item getMaxRenews Method to 2 max max renews
    @Override
     public int getMaxRenews(){
    int maxRenews = 2;
    return maxRenews;
    }
    
    @Override
    public String toString(){
        return "Barcode: " + super.barcode
                + "\nArtist: " 
                + this.artist 
                + "\nTitle: " + super.title 
                + "\nType: " + super.type 
                +  "\nYear: " + super.year 
                + "\nISBN: " + super.isbn 
                + "\n\n" ;
    } 
 
    
    
}
