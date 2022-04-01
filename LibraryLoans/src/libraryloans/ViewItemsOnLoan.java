/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import libraryloans.Objects.Loan;
import libraryloans.Objects.Item;
import libraryloans.Readers.LoanReader;
import libraryloans.Readers.ItemReader;
import java.util.ArrayList;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
public class ViewItemsOnLoan {
    private ItemReader createItems = new ItemReader();
    private LoanReader createLoans = new LoanReader();
    
    protected ArrayList<Item> allItems;
    protected ArrayList<Loan> allLoans;
    protected ArrayList<Item> currentlyLoaned;
    protected ArrayList<Item> currentlyHeld;
   
    
    
    public void getItemsList(){
        if (allItems == null){
            createItems.getItems();
            allItems = createItems.itemsFromCSV;
        } 
        //System.out.println(allItems.get(0));
    }
    
    public void getLoansList(){
        if (allLoans == null){
            createLoans.getLoans();
            allLoans = createLoans.loansFromCSV;
        } 
        //
    }
    
    // allow librarian to view all items currently on loan
    public void sortItems(){
        this.getItemsList();
        this.getLoansList();
        
        currentlyLoaned = new ArrayList<Item>();
        currentlyHeld = new ArrayList<Item>();
        
        // create two loops
        int counter = 0;                                    //set counter to 0
        int size = allItems.size();
                                      
        while (counter < size + 1 ){      // and counter is less than the size of array + 1
           for(int i = 0; i < size; i++){                   // loop through array
               Item i1 = allItems.get(i);                  // create temporary variable to store data at point i
               String barcode = i1.getBarcode();            //create a string to hold the userID
               for (int j = 0; j < allLoans.size(); j++){
                    Loan j1 = allLoans.get(j);
                    String loanBarcode = j1.getBarcode();
                    if (loanBarcode.equals(barcode)){       // if barcode is found in loans
                    currentlyLoaned.add(i1);                // add to currentlyLoaned list
                    }else{
                        currentlyHeld.add(i1);              // otherwise add to currentlyHeld list
                    }
               }   
           }
        }
        this.printItems();
    }
    
    // allow librarian to view all items held by the library
  
    public void printItems(){
        System.out.println(currentlyHeld);
        //System.out.println(currentlyLoaned);
    }
}
