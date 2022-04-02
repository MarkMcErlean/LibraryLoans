/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

/**
 *
 * @author mark1
 */
public class book extends Item {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    protected String author;
    
    
    
    // constructor to initialise the data in items
    
    public book(String barcode, String author, String title, String type, String year, String isbn){
        super(barcode, author, title, type, year, isbn);
        this.author = author;
    }

    public String artist(){
        return author;
    }
    
    @Override
    public String toString(){
        return super.toString() 
                +"\nArtist: " 
                + this.author 
                + "\n\n" ;
    }
 
    
    
}
