/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libraryloans;
import java.util.*;
import java.io.*;
import java.time.*;
/**
 * Program is intended to store and manage details of 
 * library items currently on loan to library users according
 * to a list of functional requirements
 * 
 * CONSOLE INTERFACE ONLY
 * 
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
public class LibraryLoans {

    /**
     * @param args the command line arguments
 
  upon program getItems, should read from three csv files
  to populate application with previously stored data 
  as a starting point
     */
    
    
    private CreateItems populateItems = new CreateItems();
    private CreateLoans populateLoans = new CreateLoans();
    private CreateUsers populateUsers = new CreateUsers();
    private ValidateData validate = new ValidateData();
    private IssueItem issue = new IssueItem();
    private RenewLoan renew = new RenewLoan();
    private ReturnItem returnitem = new ReturnItem();
    
    //public LibraryLoans(){
       
//}
    //private IssueItem issueitem = new IssueItem();
    
    
    public void start(){
        populateItems.getItems();
        populateLoans.getLoans();    //testing
        populateUsers.getUsers();    //testing
        
        
        
        //populateItems.getList();
        
        //this.menu(); // NEEDS TO BE UPDATED
       
        validate.getItemsList();
        validate.getUsersList();
        validate.checkUser();
        validate.checkItem();
        
       
       
        
       
        //issueitem.getItems();
    }
    
    public void menu(){
        int[] options = {0,1,2,3,4,5,6};
        int userInput = 0;
        
        Scanner choice = new Scanner(System.in);
        
        // creation of basic menu
        // ask user what they want to do
        System.out.println("What would you like to do? ");
        System.out.println("Option 1: Issue a new loan ");
        System.out.println("Option 2: Renew existing loan");
        System.out.println("Option 3: Return an Item");
        System.out.println("Option 4: View all items on loan");
        System.out.println("Option 5: View all items held by the library");
        System.out.println("Option 6: Quit the program");
        
        // accept input
        userInput = choice.nextInt();
        
        // let user number input = the option in array
        
        // set of switch case statements that match the instructions in menu
        
        switch (userInput){
            case 1:
                System.out.println("option 1");
                break;
            case 2: 
                System.out.println("option 2");
                break;
            case 3:
                System.out.println("option 3");
                break;
            case 4:
                System.out.println("option 4");
                populateItems.printItems();
                break;
            case 5:
                System.out.println("option 5");
                break;
            case 6:
                System.out.println("option 6");
                break;
            default:
                System.out.println("Please select a valid option");
                menu();
        }
    }
    
    public static void main(String[] args) {
        // items, users and loans stored as lists/arrays
        LibraryLoans libLoan = new LibraryLoans();
        
        libLoan.start();
        
        // When program exits, list of loans should be written to LOANS.csv
    }
    
}
