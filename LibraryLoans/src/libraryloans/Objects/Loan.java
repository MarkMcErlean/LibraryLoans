package libraryloans.Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 * This class creates Loan objects
 *
 */
public class Loan {
    
    //Barcode,User_id,Issue_Date,Due_Date,numRenews
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private final String barcode;
        private final String userID;
        private LocalDate issueDate;
        private LocalDate dueDate;
        private int numRenews;
        
    
    
    // constructor to initialise the data in items
    
    public Loan(String barcode, String userID, LocalDate issueDate, LocalDate dueDate, int numRenews){
        super();
        this.barcode = barcode;
        this.userID = userID;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.numRenews = numRenews;
        
    }
    // getters and setters
    
    public String getBarcode(){
        return barcode;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public LocalDate getIssueDate(){
        return issueDate;
    }
    
    public void setIssueDate(LocalDate issueDate){
        this.issueDate = issueDate;
    }
    
    public LocalDate getDueDate(){
        return dueDate;
    }
    
    public void setDueDate(LocalDate dueDate){
        if (this.numRenews <= 2){
            this.dueDate = dueDate;
            this.numRenews ++; 
        }else{
            System.out.println("Maximum number of renewals reached: renewal failed.");
        }
        
    }
    
    public String getDueDateAsString(){
        return dueDate.format(formatter);
    }
    
    public String getIssueDateAsString(){
        return issueDate.format(formatter);
    }
    
    
    public int getNumRenews(){
        return numRenews;
    }
    
    public String getNumRenewsAsString(){
        return String.valueOf(numRenews);
    }
    
   
    // Overriding the toString method to print easily
    
    @Override
    public String toString(){
        return "Barcode: " 
                + this.barcode 
                + "\nUser ID: " 
                + this.userID + "\nIssue Date: " 
                + this.getIssueDateAsString() 
                + "\nDueDate: " + getDueDateAsString() 
                +  "\nNumber of Renews: " 
                + this.numRenews 
                + "\n\n" ;
    }
}

