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
public class CreateItems{
    
    public void start(){
    //this.readItemsFromFile("ITEMS.csv");
    try{
        
        ArrayList<Items> itemsReadFromFile = new ArrayList<Items>();
        itemsReadFromFile = readItemsFromFile("ITEMS.csv");

        //System.out.println(itemsReadFromFile); //prints the contents of the array
        int size = itemsReadFromFile.size();
        
        for (int i =0; i < size; i++){
            System.out.println(itemsReadFromFile.get(i));
        }
        
        //System.out.println(itemsReadFromFile.get(3)); //test reading specific record in array
    }catch(Exception e){
        //todo error message
    }

    

    //readItemsFromFile();
}


public static ArrayList<Items> readItemsFromFile(String fileName) throws FileNotFoundException {
        File file = new File("ITEMS.CSV");  //setting filename to ITEMS.csv
        Scanner s = new Scanner(file);      //initialising scanner to scan through the file

        ArrayList<Items> itemList = new ArrayList<Items>(); //

        while (s.hasNextLine()){                // while the scanner has a line to read
            String line = s.nextLine();         // set line to the next line

            String[] items = line.split(",");   // split the line at each comma

            String barcode = items[0];          // set barcode value to the 0th value in item array
            String authorArtist = items[1];     // set author value to 1st in array
            String title = items[2];            // set title to 2nd in array
            String type = items[3];             // set type
            String year = items[4];             // set year
            String isbn = items[5];             // set isbn
          

            // create object of item
            Items newItem = new Items(barcode, authorArtist, title, type, year, isbn);

            //add the new object to the list of objects
            itemList.add(newItem);
            //System.out.println(items[0]); //test to see if array stores data (it does)
        }
        return itemList;                        //return statement for ArrayList

  
}
    
}
