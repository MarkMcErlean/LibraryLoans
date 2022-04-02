package libraryloans;
import libraryloans.Objects.Loan;
import libraryloans.Objects.Item;
import libraryloans.Readers.ItemReader;
import java.util.Scanner;
import java.time.*;
import java.time.Period;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 * 
 * This class will be used to create a new loan. Librarian supplies a Bar-code
 * and a User ID. System checks that these details exist, and if they do, 
 * creates a new loan record. Book loans are for a four week period, multimedia
 * loans are for a one week period. 
 * 
 */
public class IssueItem {
    
    private DataValidator validate;
    
    //private String barcode;
    private ArrayList<Item> items; //<-- again, this needs to be at the top of the class
    private ArrayList<Loan> loans;
    private Scanner scan = new Scanner(System.in);
//    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    
    public IssueItem(ArrayList<Item> itemsList, ArrayList<Loan> loansList, DataValidator validator){
        items = itemsList;      //<-- this bit is where it accepts the passing of the items list
        loans = loansList;
        validate = validator;
        
    }
    
    public LocalDate updateDueDate(LocalDate date, long numOfWeeks){
       return date.plusDays(numOfWeeks*7); 
    }
    
    public LocalDate renew(LocalDate issueDate, String type){
        if (type .equals("Book")){
                return updateDueDate(issueDate, 4);
//                returnDueDate = date.plusDays(fourWeeks);
//                dueDate = returnDueDate.format(format);
            } else{
                return updateDueDate(issueDate, 1);
//                returnDueDate = date.plusDays(week);
//                dueDate = returnDueDate.format(format);
            }
        
    }

    public void issue(){
        System.out.println("Making data validity checks...");       
        // checks if entered barcode and userID are valid
            LocalDate date = LocalDate.now();
            String barcode = validate.getAndCheckBarcode();
            String userID = validate.getAndCheckUserId();
            String type = checkType(barcode);
            LocalDate issueDate = date;  //todays date
            LocalDate dueDate = renew(date, type);
            String numRenews = "0";
            
            
            // getting time logic
            
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
          for (int index = 0; index < items.size(); index++){
              if(barcode.equalsIgnoreCase(items.get(index).getBarcode())){
                  type = items.get(index).getType();
                  validType = true;
              }
          }
        } while (!validType);
        return type;
    }
}

