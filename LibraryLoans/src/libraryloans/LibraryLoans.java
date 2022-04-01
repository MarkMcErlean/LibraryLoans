/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libraryloans;
import libraryloans.Readers.UserReader;
import libraryloans.Readers.ItemReader;
import libraryloans.Readers.LoanReader;
import java.util.*;
import java.io.*;
import java.time.*;
import libraryloans.Objects.Item;
import libraryloans.Objects.User;
import libraryloans.Objects.Loan;
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
 
  upon program getItems, should read from three CSV files
  to populate application with previously stored data 
  as a starting point
     */
    
    
    private ItemReader populateItems = new ItemReader();
    private LoanReader populateLoans = new LoanReader();
    private UserReader populateUsers = new UserReader();
    private DataValidator validator;
    private IssueItem issueItem;
    private RenewLoan renewLoan;
    private ReturnItem returnItem = new ReturnItem();
    private ViewItems viewItems;
    private ArrayList<Item> items;
    private ArrayList<User> users;
    private ArrayList<Loan> loans;
    
    //public LibraryLoans(){
       
//}
    //private IssueItem issueitem = new IssueItem();
    
    
    private void start(){
        items = populateItems.getItems("ITEMS.csv");
        loans = populateLoans.getLoans("LOANS.csv");    //testing
        users = populateUsers.getUsers("USERS.csv");    //testing
        validator = new DataValidator(items, users);
        issueItem = new IssueItem(items, loans, validator);
        viewItems = new ViewItems(items, loans, issueItem);
       
        
        
        //populateItems.getList();
        
       
       // TEST CODE HERE //
        //validate.getItemsList();
        //validate.getUsersList();
        //issueItem.issue();
        viewItems.printItems();
        //validator.getAndCheckUserId();
        
        //this.menu(); // NEEDS TO BE UPDATED
        //viol.sortItems();
       //populateItems.printItems();
       
        
       
        
    }
    //public void menu(ArrayList<Item> itemList ){
    
    public void menu(){
        //int[] options = {0,1,2,3,4,5,6};
        int userInput;
        
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
                System.out.println("\n");
                
                // call issueItems code here
                break;
            case 2: 
                System.out.println("option 2");
                System.out.println("\n");
                
                // call renewLoan code here
                break;
            case 3:
                System.out.println("option 3");
                System.out.println("\n");
                
                // call returnItems code here
                break;
            case 4:
                System.out.println("option 4");
                System.out.println("\n");
                
                // call populateItems.itemsOnLoan code here
                //populateItems.printItems();
                break;
            case 5:
                System.out.println("option 5");
                System.out.println("\n");
                
                // call populateItems.itemsHeld code here
                break;
            case 6:
                System.out.println("option 6");
                break;
            default:
                System.out.println("Please select a valid option");
                this.menu();
        }
    }
    
    public static void main(String[] args) {
        // items, users and loans stored as lists/arrays
        LibraryLoans libLoan = new LibraryLoans();
        
        libLoan.start();
        
        // When program exits, list of loans should be written to LOANS.csv
    }
    
}
