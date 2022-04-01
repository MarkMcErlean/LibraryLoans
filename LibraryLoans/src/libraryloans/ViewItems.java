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
public class ViewItems {
    private ArrayList<Item> items;
    private ArrayList<Loan> loans;
    private ArrayList<Item> currentlyLoaned;
    private ArrayList<Item> currentlyHeld;
    private DataValidator validator;
    private IssueItem newLoan;
    
    
    public ViewItems(ArrayList<Item> itemsList, ArrayList<Loan> loansList, IssueItem issueItem){
        items = itemsList;
        loans = loansList;
        newLoan = issueItem;
        
    }
   
    
    // allow librarian to view all items currently on loan
    private void sortItems(String barcode){
       for (int index = 0; index < items.size(); index ++){
           if(barcode.equalsIgnoreCase(loans.get(index).getBarcode())){
                  currentlyHeld.add(items.get(index));
              }
        }
        
        
        }
        

    
    // allow librarian to view all items held by the library
  
    public void printItems(){
        System.out.println(currentlyHeld);
        //System.out.println(currentlyLoaned);
    }
}
