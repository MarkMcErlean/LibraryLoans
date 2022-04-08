
package libraryloans;

import libraryloans.Objects.Loan;
import libraryloans.Objects.Item;
import java.util.ArrayList;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 */
public class ViewItems {
    private final ArrayList<Item> items;
    private final ArrayList<Loan> loans;
    private ArrayList<Item> heldItems;
    private ArrayList<Item> loanedItems;
    
    
public ViewItems(ArrayList<Item> itemsList, ArrayList<Loan> loansList){
    items = itemsList;
    loans = loansList;

}
   /*
for every index of loans, search through each index of items to see if the index
is a match. if it is, add that index of item to loanedItems
*/
private void getLoaned(){
    loanedItems = new ArrayList<Item>();
    heldItems = new ArrayList<Item>();
    for (Item item : items) {
        for (Loan loan : loans) {
            try {
                if (item.getBarcode().equals(loan.getBarcode())) {
                    loanedItems.add(item);
                } else {
                    heldItems.add(item);
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }
}



private void removeDuplicatesHeld(){
    //this.getHeld();
    this.getLoaned();

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
    for (Item loanedItem : loanedItems) {
        System.out.println(loanedItem);
    }
}
    
public void printItemsInLibrary(){
    //this.getLoaned();
    this.removeDuplicatesHeld();
    for (Item heldItem : heldItems) {
        System.out.println(heldItem);
    }

}
    
}
