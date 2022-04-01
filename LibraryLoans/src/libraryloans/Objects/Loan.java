/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mark1
 */
public class Loan {
    
    //Barcode,User_id,Issue_Date,Due_Date,numRenews
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        private String barcode;
        private String userID;
        private LocalDate issueDate;
        private LocalDate dueDate;
        private String numRenews;
        
    
    
    // constructor to initialise the data in items
    
    public Loan(String barcode, String userID, LocalDate issueDate, LocalDate dueDate, String numRenews){
        
        this.barcode = barcode;
        this.userID = userID;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.numRenews = numRenews;
        
    }
    
    public String getBarcode(){
        return barcode;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public LocalDate getIssueDate(){
        return issueDate;
    }
    
    public LocalDate getDueDate(){
        return dueDate;
    }
    
    public String getDueDateAsString(){
        return dueDate.format(formatter);
    }
    
    public String getIssueDateAsString(){
        return issueDate.format(formatter);
    }
    
    public String getNumRenews(){
        return numRenews;
    }
    
   
    
    // In below to string format your date
    @Override
    public String toString(){
        return "Barcode: " + this.barcode + "\nUser ID: " + this.userID + "\nIssue Date: " + this.getIssueDateAsString() + "\nDueDate: " + getDueDateAsString() +  "\nNumber of Renews: " + this.numRenews + "\n\n" ;
    }
}

