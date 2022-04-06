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
 * Stephen McKeown (B00839440)
 */
public class RenewLoan {
    private final DataValidator validate;
    private ArrayList<Item> items;
    private final ArrayList<Loan> loans;
    private final loanManager manageLoan;
    private int maxRenews;
    private int currentRenews;
    private String barcode;
    private String userID;
    
    public RenewLoan(ArrayList<Loan> loansList,ArrayList<Item> itemsList,
            DataValidator validator, loanManager issueItem){
        validate = validator;
        items = itemsList;
        loans = loansList; 
        manageLoan = issueItem;
    }
    
    public void extendLoan(){
        barcode = validate.getAndCheckBarcode();
        userID = validate.getAndCheckUserId();
        String type = manageLoan.checkType(barcode);
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = manageLoan.renew(issueDate, type);
        this.getCurrentRenews();
        this.getCurrentRenews();
        
     
//        for (Loan loan : loans) {
          for (Loan loan : loans){
            if (barcode.equals(loan.getBarcode()) && userID.equals(loan.getUserID())) {
                loan.setDueDate(dueDate);
            }
        }
            
        }

    
    private int getMaxRenews(){
        for (Item item : items){
            if (barcode.equals(item.getBarcode())) {
                maxRenews = item.getMaxRenews();
            }
        }
        return maxRenews;
    }
    
    private int getCurrentRenews(){
        for (Loan loan : loans){
            if (barcode.equals(loan.getBarcode()) && userID.equals(loan.getUserID())) {
                currentRenews = loan.getNumRenews();
            }
        }
        return currentRenews;
    }
    
}
