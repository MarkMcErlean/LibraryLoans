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
 * Stephen McKeown (B00839440)
 */
public class ReturnItem {
    
    private final DataValidator validate;
    private final ArrayList<Loan> loans;
    private Loan currentLoan;
    //private LocalDate dueDate;
    
    public ReturnItem(ArrayList<Loan> loansList,
            DataValidator validator){
        validate = validator;
        loans = loansList;
    }
    
    public void returnLoanItem(){
    
        String barcode = validate.getAndCheckBarcode();
        String userId = validate.getAndCheckUserId();
        LocalDate today = LocalDate.now();
        LocalDate dueDate = null;

        // for each oject of loan in Loans array
        for (Loan loan : loans) {
            try{
            if (loan.getBarcode().equals(barcode) &&
                    loan.getUserID().equals(userId)) {
                currentLoan = loan;
                dueDate = currentLoan.getDueDate();
            }else{
                System.out.println("Record does not exist, please try again");
                this.returnLoanItem();
            }
            }catch(NullPointerException nullException){
                System.out.println("That record does not exist, try again");
                this.returnLoanItem();
            }
        }
        if (today.isAfter(dueDate)){
            System.out.println("Item is overdue ");
            loans.remove(currentLoan);

        } else{
            System.out.println("Item returned");
            loans.remove(currentLoan);

        }
}
    
   
    
    
    
    // Items must be returned on or before their due date
    
    //when item is returned, it should be removed from list of loans
    
    
}
