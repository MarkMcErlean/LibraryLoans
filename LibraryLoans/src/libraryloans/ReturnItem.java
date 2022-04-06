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
public class ReturnItem {
    
    private final DataValidator validate;
    private final ArrayList<Loan> loans;
    private Loan currentLoan;
    private LocalDate dueDate;
    
    public ReturnItem(ArrayList<Loan> loansList,
            DataValidator validator){
        validate = validator;
        loans = loansList;
    }
    
    public void returnLoanItem(){
    
        String barcode = validate.getAndCheckBarcode();
        String userId = validate.getAndCheckUserId();
        LocalDate today = LocalDate.now();


        for (Loan loan : loans) {
            if (loan.getBarcode().equals(barcode) &&
                    loan.getUserID().equals(userId)) {
                currentLoan = loan;
                dueDate = loan.getDueDate();
            }
        }
        if (today.isAfter(dueDate)){
            System.out.println("Item is overdue ");
            loans.remove(currentLoan);

        } else{
            System.out.println("Item returned");
            //System.out.println(currentLoan);
            loans.remove(currentLoan);

        }
}
    
   
    
    
    
    // Items must be returned on or before their due date
    
    //when item is returned, it should be removed from list of loans
    
    
}
