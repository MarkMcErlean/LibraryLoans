package libraryloans;
import libraryloans.Objects.Loan;
import libraryloans.Objects.Item;
import java.time.*;
import java.util.ArrayList;


/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 * 
 * This class will be used to create a new loan. Librarian supplies a Bar-code
 * and a User ID. System checks that these details exist, and if they do, 
 * creates a new loan record. Book loans are for a four-week period, multimedia
 * loans are for a one-week period.
 * 
 */
public class loanManager {
    
    private final DataValidator validate;
    
    //private String barcode;
    private final ArrayList<Item> items;
    private final ArrayList<Loan> loans;
    
    public loanManager(ArrayList<Item> itemsList, ArrayList<Loan> loansList, DataValidator validator){
        items = itemsList;
        loans = loansList;
        validate = validator; 
    }
    
    public LocalDate updateDueDate(LocalDate date, long numOfWeeks){
       return date.plusDays(numOfWeeks*7); 
    }
    
    public LocalDate renew(LocalDate issueDate, String type){
        if (type .equals("Book")){
                return updateDueDate(issueDate, 4);
            } else{
                return updateDueDate(issueDate, 1);
            }
        
    }

    public void issue(){
        System.out.println("Making data validity checks...");       
        // checks if entered barcode and userID are valid
            //LocalDate date = LocalDate.now();
            String barcode = validate.getAndCheckBarcode();
            String userID = validate.getAndCheckUserId();
            String type = checkType(barcode);
            LocalDate issueDate = LocalDate.now();
            LocalDate dueDate = renew(issueDate, type);
            int numRenews = 0;

            
            // public       void    method(Param)
            // Access-Level return  name   (input)

            Loan newLoan = new Loan(barcode, userID, issueDate, dueDate, numRenews);
            newLoan.getDueDateAsString();
            
            loans.add(newLoan);
            
            System.out.println(newLoan);
     
        }
    
    
    // this class gets the item type of the item matching barcode used
    public String checkType(String barcode){
        boolean validType = false;
        String type = "INVALID";
        do{
            for (Item item : items) {
                if (barcode.equalsIgnoreCase(item.getBarcode())) {
                    type = item.getType();
                    validType = true;
                }
            }
        } while (!validType);
        return type;
    }
}

