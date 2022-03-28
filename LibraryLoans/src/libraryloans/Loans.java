/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

/**
 *
 * @author mark1
 */
public class Loans {
    
    //Barcode,User_id,Issue_Date,Due_Date,numRenews
    
        private String barcode;
        private String userID;
        private String issueDate;
        private String dueDate;
        private String numRenews;
        
    
    
    // constructor to initialise the data in items
    
    public Loans(String barcode, String userID, String issueDate, String dueDate, String numRenews){
        
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
    
    public String getIssueDate(){
        return issueDate;
    }
    
    public String getDueDate(){
        return dueDate;
    }
    
    public String getNumRenews(){
        return numRenews;
    }
    
   
    
    
    @Override
    public String toString(){
        return "Barcode: " + this.barcode + "\nUser ID: " + this.userID + "\nIssue Date: " + this.issueDate + "\nDueDate: " + this.dueDate +  "\nNumber of Renews: " + this.numRenews + "\n\n" ;
    }
}

