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
    private ArrayList<Item> heldItems;
    private ArrayList<Item> loanedItems;
    private DataValidator validator;
    private IssueItem newLoan;
    
    
public ViewItems(ArrayList<Item> itemsList, ArrayList<Loan> loansList, IssueItem issueItem){
    items = itemsList;
    loans = loansList;
    newLoan = issueItem;

}
   /*
for every index of loans, search through each index of items to see if the index
is a match. if it is, add that index of item to loanedItems
*/
private ArrayList<Item> getLoaned(){
    loanedItems = new ArrayList<Item>();
    for (int itemIndex = 0; itemIndex < items.size(); itemIndex ++){
        for (int loanIndex = 0; loanIndex < loans.size(); loanIndex++){
            try{    
                if(items.get(itemIndex).getBarcode().equals(loans.get(loanIndex).getBarcode())){
                    loanedItems.add(items.get(itemIndex));   
                }                   
                }catch(IndexOutOfBoundsException e){
                    break;
                }
        }
    }
     return loanedItems;
}

private ArrayList<Item> getHeld(){
    heldItems = new ArrayList<Item>();
    for (int itemIndex = 0; itemIndex < items.size(); itemIndex ++){
        for(int loanIndex = 0; loanIndex <loans.size(); loanIndex++){
            try{
                if(items.get(itemIndex).getBarcode().equals(loans.get(loanIndex).getBarcode())){
                    heldItems.add(items.get(itemIndex)); 
                }
            }catch(IndexOutOfBoundsException e){
                break;
            }
           
        }
    }
        return heldItems;
}    


private void removeDuplicatesHeld(){
    this.getHeld();
    
    for (int index = 0; index < heldItems.size(); index++){
        for (int duplicate = index + 1; duplicate < heldItems.size(); duplicate ++){
            if (heldItems.get(index).equals(heldItems.get(duplicate))){
                heldItems.remove(duplicate);
                duplicate--;
            }
            
        }
    }
}
    
    // allow librarian to view all items held by the library
  
public void printItemsOnLoan(){
    this.getLoaned();
    for( int index = 0; index < loanedItems.size(); index++){
        System.out.println(loanedItems.get(index));
    }
  //  System.out.println(currentlyHeld);
    //System.out.println(currentlyLoaned);
}
    
public void printItemsInLibrary(){
    this.removeDuplicatesHeld();
    for (int index = 0; index < heldItems.size(); index++){
        System.out.println(heldItems.get(index));
    }

}
    
}
