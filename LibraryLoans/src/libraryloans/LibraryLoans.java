/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libraryloans;
import java.util.*;
import java.io.*;
import java.time.*;
/**
 * Program is intended to store and manage details of 
 * library items currently on loan to library users according
 * to a list of functional requirements
 * 
 * CONSOLE INTERFACE ONLY
 * 
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
public class LibraryLoans {

    /**
     * @param args the command line arguments
     * 
     *  upon program start, should read from three csv files
     *  to populate application with previously stored data 
     *  as a starting point
     */
    
    private StoreData storedata = new StoreData();
    private CreateItems populateItems = new CreateItems();
    //private IssueItem issueitem = new IssueItem();
    
    
    public void start(){
        
        //storedata.start();
        
        
        
        System.out.println("What would you like to do? ");
        System.out.println("Option 1: Issue a new loan ");
        System.out.println("Option 2: Renew existing loan");
        System.out.println("Option 3: Return an Item");
        System.out.println("Option 4: View all items on loan");
        System.out.println("Option 5: View all items held by the library");
        System.out.println("Option 6: Quit the program");
       
        //issueitem.start();
    }
    
    public static void main(String[] args)throws FileNotFoundException {
        // items, users and loans stored as lists/arrays
        LibraryLoans libLoan = new LibraryLoans();
        
        libLoan.start();
        
        // When program exits, list of loans should be written to LOANS.csv
    }
    
}
