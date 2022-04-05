/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.time.LocalDate;
import java.util.ArrayList;
import libraryloans.Objects.Item;
import libraryloans.Objects.Loan;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
public class RenewLoan {
    private DataValidator validate;
    private ArrayList<Item> items; 
    private ArrayList<Loan> loans;
    private loanManager manageLoan;
    
    public RenewLoan(ArrayList<Item> itemsList, ArrayList<Loan> loansList,
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

        for (int index = 0; index < loans.size(); index++){
            if (barcode.equals(loans.get(index).getBarcode()) && userID.equals(loans.get(index).getUserID())){
                loans.get(index).setDueDate(dueDate);
            }
        }
        
        
        
        //System.out.println("Date updated: ");
        //System.out.println("renewed date is: " + issueDate);
            
        }

    // Maximum number of renews is three (books)
    
    // Maximum number of renews is two (multimedia item)
}
