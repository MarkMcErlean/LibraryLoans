/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;
import java.util.*;
import java.io.*;

/**
 *
 * @author mark1
 */
public class CreateItems {
    
    //private Items[] item = new Items[6];
    
    
    public CreateItems() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("ITEMS.csv"));
       
        //Scanner scan = new Scanner(new File("ITEMS.csv"));
        scan.useDelimiter("\n");
    
        Items[] items = new Items[0];
        while(scan.hasNext()){
            String barcode = scan.next();
            String authorArtist = scan.next();
            String title = scan.next();
            String type = scan.next();
            String year = scan.next();
            String isbn = scan.next();
            
            Items newItem = new Items(barcode, authorArtist, title, type, year, isbn);
            items = addItem(items, newItem);
        }
        
        for (Items item : items){
            System.out.println(item);
        }
    }   
    
    private static Items[] addItem(Items[] items, Items itemToAdd){
        Items[] newItems = new Items[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = itemToAdd;
        
        return newItems;
    }
    
}
