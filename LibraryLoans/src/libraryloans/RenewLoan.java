/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.time.LocalDate;
import java.util.ArrayList;
import libraryloans.Objects.Loan;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
public class RenewLoan {
    private final DataValidator validate;
    private final ArrayList<Loan> loans;
    private final loanManager manageLoan;
    
    public RenewLoan(ArrayList<Loan> loansList,
            DataValidator validator, loanManager issueItem){
        validate = validator;
        loans = loansList; 
        manageLoan = issueItem;
    }
    
    public void extendLoan(){
        String barcode = validate.getAndCheckBarcode();
        String userID = validate.getAndCheckUserId();
        String type = manageLoan.checkType(barcode);
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = manageLoan.renew(issueDate, type);

        for (Loan loan : loans) {
            if (barcode.equals(loan.getBarcode()) && userID.equals(loan.getUserID())) {
                loan.setDueDate(dueDate);
            }
        }
            
        }

    // Maximum number of renews is three (books)
    
    // Maximum number of renews is two (multimedia item)
}
