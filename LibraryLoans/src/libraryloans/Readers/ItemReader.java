
package libraryloans.Readers;
import java.util.*;
import java.io.*;
import libraryloans.Objects.Item;
import libraryloans.Objects.book;
import libraryloans.Objects.multimedia;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 * Loops through a file, stores each line as a string, separates the string by
 * comma's into each part of the object, which is then stored into an array.
 * 
 */
public class ItemReader{
    public ArrayList<Item> getItems(String filename){
        return getItemsFromCSV(filename);
}

private ArrayList<Item> getItemsFromCSV(String fileName) {
    ArrayList<Item> itemList = new ArrayList<Item>();
    
    try {
        File file = new File(fileName);
        Scanner lineScanner = new Scanner(file); 

        /* While the file has more lines, take the next line and convert to an 
        item, then add to the list of items. Skips the first Line (file header)
        */

        String headerLine = lineScanner.nextLine();
        while (lineScanner.hasNextLine()){
            String line = lineScanner.nextLine();
            //add the new object to the list of objects
            itemList.add(itemFromString(line));
        }
        
        return itemList;                        
    } catch (Exception e) {
        System.out.println("Error reading file");
        return itemList;
    }
  
}

/** 
* Create object of item(), uses below constructor
 Item(String barcode, String authorArtist, String title, String type, String year, String isbn)
 which matches order of items in CSV file, so can directly create from array
* @param itemString The plain string version of the item you intend to return
* @return Item 
**/
private Item itemFromString(String itemString) {
            String[] itemContents = itemString.split(",");   // split the line at each comma
            if (itemContents[3] .equalsIgnoreCase("Book")){
            return new book(
                itemContents[0], 
                itemContents[1],
                itemContents[2],
                itemContents[3],
                itemContents[4],
                itemContents[5]
            );
            }else{
                return new multimedia(
                itemContents[0], 
                itemContents[1],
                itemContents[2],
                itemContents[3],
                itemContents[4],
                itemContents[5]
            );

//            }else{
//                return new Item(
//                itemContents[0], 
//                itemContents[1],
//                itemContents[2],
//                itemContents[3],
//                itemContents[4],
//                itemContents[5]
//            );
            }       
}
   
    
}
