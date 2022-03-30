package libraryloans;
import java.util.Scanner;
import java.time.*;
import java.time.Period;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 * 
 * This class will be used to create a new loan
 * librarian will supply a barcode and user ID
 * System will check if supplied details exist.
 * 
 */
public class IssueItem {
    
    //Book loans are for a four week period
    //Multimedia loans are for a one week period
    // when item is issued, create a loan object and add to list/array of loans
    private CreateItems createItems = new CreateItems();
    private ValidateData validate = new ValidateData();
    private String itemType;
    
    private Scanner scan = new Scanner(System.in);

    public void issue(){
        System.out.println("Making data validity checks...");
        

        validate.getItemsList();
        validate.getUsersList();
       
        // checks if entered barcode and userID are valid
        if (validate.checkItem() && validate.checkUser()){  // if valid
            
            String barcode = validate.bcode;            //use supplied barcode
            String userID = validate.uID;               //use supplied userID
            String issueDate;                           //todays date
            String dueDate;                             //return due date
            String numRenews = "0";                     // num of renews set to 0
            
            // getting time logic
            
            LocalDate date = LocalDate.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            issueDate = date.format(format);
            long week = 7; // one week = 7 days
            long fourWeeks = week * 4;
            LocalDate returnDueDate;
            
            this.findType();
            
            if (itemType == "Book"){
                returnDueDate = date.plusDays(fourWeeks);
                dueDate = returnDueDate.format(format);
            } else{
                returnDueDate = date.plusDays(week);
                dueDate = returnDueDate.format(format);
            }
            
            //System.out.println(itemType);
            
            //System.out.println(barcode);
            //System.out.println(userID);
            Loans newLoan = new Loans(barcode, userID, issueDate, dueDate, numRenews);
            
            //System.out.println(newLoan);
            
        }
    }
    
    // this class gets the item type of the item matching barcode used
    private void findType(){
 
        int size = validate.validItems.size();              // get size of item list
            int counter = 0;                                //set counter to 0
            
            boolean found = false;                          // create boolean found flag, while found is false
            while (found == false && counter < size + 1 ){  // and counter is less than the size of array + 1
               for(int i = 0; i < size; i++){               // loop through array
                   Items i1 = validate.validItems.get(i);   // create temporary variable to store data at point i
                   String barcode = i1.getBarcode();        //create a string to hold the barcode
                   if (barcode.equals(validate.bcode)){     // if barcode == user input
                       itemType = i1.getType();             // get the item type at this index
                       found = true;                        // set found flag to true
                   }    
                   else{                                
                       counter += 1;                        // otherwise increment counter
                   }
                } 
            }
    }
    
}

