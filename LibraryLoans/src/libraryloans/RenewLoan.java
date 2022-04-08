
package libraryloans;

import java.time.LocalDate;
import java.util.ArrayList;
import libraryloans.Objects.Item;
import libraryloans.Objects.Loan;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 */
public class RenewLoan {
    private final DataValidator validate;
    private ArrayList<Item> items;
    private final ArrayList<Loan> loans;
    private final loanManager manageLoan;
    private LibraryLoans libraryLoans = new LibraryLoans();
    
    public RenewLoan(ArrayList<Loan> loansList,ArrayList<Item> itemsList,
            DataValidator validator, loanManager issueItem){
        validate = validator;
        items = itemsList;
        loans = loansList; 
        manageLoan = issueItem;
    }
    
    public void extendLoan(){
        String barcode = validate.getAndCheckBarcode();
        String userID = validate.getAndCheckUserId();
        String type = manageLoan.checkType(barcode);
        
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = manageLoan.renew(issueDate, type);
        
        int currentRenews = getCurrentRenews(barcode, userID);
        int maxRenews = this.getMaxRenews(barcode);
        
      
        for (Loan loan : loans){
          if (barcode.equals(loan.getBarcode()) && userID.equals(loan.getUserID())){
              if(currentRenews < maxRenews){
              loan.setDueDate(dueDate);
              System.out.println("Loan renewed");
              }
          }else{
              System.out.println("Record does not exist... Returning to menu...");
              break;
          }
        }
            
        }

    
    private int getMaxRenews(String barcode){
        return getItem(barcode).getMaxRenews();
    }
    
    private int getCurrentRenews(String barcode, String userID){
        int currentRenews = 0;
        for (Loan loan : loans){
            if (barcode.equals(loan.getBarcode()) && userID.equals(loan.getUserID())) {
                loan.getNumRenews();
            }
        }
        return currentRenews;
    }
    
    private Item getItem(String barcode){
        Item retreivedItem = null;
        for (Item item : items){
            if (barcode.equals(item.getBarcode())) {
                retreivedItem = item;
            }
        }
        return retreivedItem;
        
    } 
}
