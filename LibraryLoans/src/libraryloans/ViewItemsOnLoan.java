/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.util.ArrayList;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
public class ViewItemsOnLoan {
    private CreateItems createItems = new CreateItems();
    private CreateLoans createLoans = new CreateLoans();
    
    protected ArrayList<Items> allItems;
    protected ArrayList<Loans> allLoans;
    protected ArrayList<Items> currentlyLoaned;
    protected ArrayList<Items> currentlyHeld;
   
    
    
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
        
        currentlyLoaned = new ArrayList<Items>();
        currentlyHeld = new ArrayList<Items>();
        
        // create two loops
        int counter = 0;                                    //set counter to 0
        int size = allItems.size();
                                      
        while (counter < size + 1 ){      // and counter is less than the size of array + 1
           for(int i = 0; i < size; i++){                   // loop through array
               Items i1 = allItems.get(i);                  // create temporary variable to store data at point i
               String barcode = i1.getBarcode();            //create a string to hold the userID
               for (int j = 0; j < allLoans.size(); j++){
                    Loans j1 = allLoans.get(j);
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
