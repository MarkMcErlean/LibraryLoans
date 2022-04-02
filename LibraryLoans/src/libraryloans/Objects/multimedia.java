/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

/**
 *
 * @author mark1
 */
public class multimedia extends Item {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    protected String artist;
    
    
    
    // constructor to initialise the data in items
    
    public multimedia(String barcode, String artist, String title, String type, String year, String isbn){
        super(barcode, artist, title, type, year, isbn);
        this.artist = artist;
        
        
    }

    
    public String artist(){
        return artist;
    }
 
    
    @Override
    public String toString(){
        return super.toString() 
                +"\nArtist: " 
                + this.artist 
                + "\n\n" ;
    }
 
    
    
}
