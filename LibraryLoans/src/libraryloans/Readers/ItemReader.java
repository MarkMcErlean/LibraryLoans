/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Readers;
import java.util.*;
import java.io.*;
import libraryloans.Objects.Item;

/**
 *
 * @author mark1
 */
public class ItemReader{
    public ArrayList<Item> itemsFromCSV;
    
    public ArrayList<Item> getItems(String filename){
        return getItemsFromCSV(filename);
}
//    // method to print all items - needs separated into two methods to print records held by library and records on loan
//    public void printItems(){
//        for (int i =0; i < itemsFromCSV.size(); i++){                      // loop through ArrayList
//        System.out.println(itemsFromCSV.get(i));      // Read objects in ArrayList while skipping record 0
//            
//        }
//    }


private ArrayList<Item> getItemsFromCSV(String fileName) {
    ArrayList<Item> itemList = new ArrayList<Item>();
    
    try {
        File file = new File(fileName);
        Scanner lineScanner = new Scanner(file);      //initialising scanner to scan through the file

        /* While the file has more lines, take the next line and convert to an 
        item, then add to the list of items.
        */

        while (lineScanner.hasNextLine()){
            String line = lineScanner.nextLine();
            //add the new object to the list of objects
            itemList.add(itemFromString(line));
        }
        
        return itemList;                        //return statement for ArrayList
    } catch (Exception e) {
        System.out.println("Error reading file");
        return itemList;
    }
  
}

/** 
* Create object of item(), uses below contructor
 Item(String barcode, String authorArtist, String title, String type, String year, String isbn)
 which matches order of items in CSV file, so can directly create from array
* @param itemString The plain string version of the item you intend to return
* @return Item 
**/
private Item itemFromString(String itemString) {
            String[] itemContents = itemString.split(",");   // split the line at each comma
            
            
            return new Item(
                itemContents[0], 
                itemContents[1],
                itemContents[2],
                itemContents[3],
                itemContents[4],
                itemContents[5]
            );
}

   
    
}
