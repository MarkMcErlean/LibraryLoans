/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

/**
 *
 * @author mark1
 */
public class Items {
    
    //Barcode,Author/Artist,Title,Type,Year,ISBN
    
    protected String barcode;
    protected String authorArtist;
    protected String title;
    protected String type;
    protected String year;
    protected String isbn;
    
    // constructor to initialise the data in items
    
    public Items(String bcode, String itemAuthor, String itemTitle, String itemType, String itemYear, String ItemISBN){
        
        barcode = bcode;
        authorArtist = itemAuthor;
        title = itemTitle;
        type = itemType;
        year = itemYear;
        isbn = ItemISBN;
    }
    
//    @Override
//    public String toString(){
//        return String.format("Barcode: %bcode\r\nAuthor or Artist: %itemAuthor\r\n")
//    }
}
