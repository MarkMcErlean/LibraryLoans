package libraryloans;
import java.util.Scanner;
import java.time.*;
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
//    private CreateItems createItems = new CreateItems();
//    private CreateUsers createUsers = new CreateUsers();
    private ValidateData validate = new ValidateData();
    
    
//    protected ArrayList<Items> validItems;
//    protected ArrayList<Users> validUsers;
    
    
    private Scanner scan = new Scanner(System.in);

    public void issue(){
        System.out.println("Making data validity checks...");
        
        //String bcode = scan.nextLine();
        validate.getItemsList();
        validate.getUsersList();
       
        // checks if entered barcode and userID are valid
        if (validate.checkItem() && validate.checkUser()){  // if valid
            //System.out.println("yep ");
            String barcode = validate.bcode;
            String userID = validate.uID;
            
            LocalDate date = LocalDate.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            String issueDate = date.format(format);
            
            //System.out.println(barcode);
            //System.out.println(userID);
            //Loans newLoan = new Loans(barcode, userID, issueDate, dueDate, numRenews);
        }
        
        
    }
    
    // enter barcode
    
    // check valid
    
    // if valid
    
    
    
    
    // if checkItem is true and check user is true
    // create a new loan item with those details
    
    
    
    
}

