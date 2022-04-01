/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

/**
 *
 * @author mark1
 */
public class Item {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    
    private String barcode;
    private String authorArtist;
    private String title;
    private String type;
    private String year;
    private String isbn;
    
    
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
    
    
    @Override
    public String toString(){
        return "Barcode: " + this.barcode + "\nAuthor/Artist: " + this.authorArtist + "\nTitle: " + this.title + "\nType: " + this.type +  "\nYear: " + this.year + "\nISBN: " + this.isbn + "\n\n" ;
    }
//    public void printItems(){
//        System.out.println("Barcode: " + barcode);
//        System.out.println("Author/Artist: " + authorArtist);
//        System.out.println("Title: " + title);
//        System.out.println("Type: " + type);
//        System.out.println("Year: " + year);
//        System.out.println("ISBN: " + isbn);
//    }  
    
    
}
