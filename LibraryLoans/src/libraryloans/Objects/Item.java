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
 */
public class Item {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    
    private final String barcode;
    private final String authorArtist;
    private final String title;
    private final String type;
    private final String year;
    private final String isbn;
    
    
    // constructor to initialise the data in items
    
    public Item(String barcode, String authorArtist, String title, String type, String year, String isbn){
        
        this.barcode = barcode;
        this.authorArtist = authorArtist;
        this.title = title;
        this.type = type;
        this.year = year;
        this.isbn = isbn;
        
    }
    
    public String getBarcode(){
        return barcode;
    }
    
    public String getAuthorArtist(){
        return authorArtist;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getType(){
        return type;
    }
    
    public String getYear(){
        return year;
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public int getMaxRenews(){
        int maxRenews = 1;
        if( this.type.equals("Book")){
            maxRenews = 3;
        }else{
            maxRenews = 2;
        }
        return maxRenews;
    }
    
    
    @Override
    public String toString(){
        return "Barcode: " + this.barcode
                + "\nAuthor/Artist: " 
                + this.authorArtist 
                + "\nTitle: " + this.title 
                + "\nType: " + this.type 
                +  "\nYear: " + this.year 
                + "\nISBN: " + this.isbn 
                + "\n\n" ;
    } 
    
    
}
