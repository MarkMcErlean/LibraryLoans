
package libraryloans;
import libraryloans.Readers.UserReader;
import libraryloans.Readers.ItemReader;
import libraryloans.Readers.LoanReader;
import java.util.*;
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
     *
 
  upon program getItems, should read from three CSV files
  to populate application with previously stored data 
  as a starting point
     */
    
    
    private final ItemReader populateItems = new ItemReader();
    private final LoanReader populateLoans = new LoanReader();
    private final UserReader populateUsers = new UserReader();
    private loanManager manageLoan;
    private RenewLoan renewLoan;
    private ReturnItem returnItem;
    private ViewItems viewItems;
    private ArrayList<Item> items;
    private ArrayList<User> users;
    private ArrayList<Loan> loans;


//}

    
    
    private void start(){
        items = populateItems.getItems("src\\ITEMS.csv");
        loans = populateLoans.getLoans("src\\LOANS.csv");
        users = populateUsers.getUsers("src\\USERS.csv");
        DataValidator validator = new DataValidator(items, users);
        manageLoan = new loanManager(items, loans, validator);
        viewItems = new ViewItems(items, loans);
        renewLoan = new RenewLoan(loans, validator, manageLoan);
        returnItem = new ReturnItem(loans, validator);
       
        this.menu();
        
        //populateItems.getList();
        
       
       // TEST CODE HERE //
        //validate.getItemsList();
        //validate.getUsersList();
        //issueItem.issue();
        //viewItems.printItemsOnLoan();
        //viewItems.printItemsInLibrary();
        //renewLoan.extendLoan();
        //returnItem.returnLoanItem();
        //validator.getAndCheckUserId();
        
        //this.menu(); // NEEDS TO BE UPDATED
        //viol.sortItems();
       //populateItems.printItems();
    
    }
    
    private void menu(){
        //int[] options = {0,1,2,3,4,5,6};
        boolean keepGoing = true;
        int userInput;
        
        Scanner choice = new Scanner(System.in);
        try{
        do{
        // creation of basic menu
        // ask user what they want to do
        System.out.println("What would you like to do? Enter a number to perform a function");
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

            switch (userInput) {
                case 1 -> {
                    System.out.println("Option 1: Issue a new loan");
                    System.out.println("\n");
                    manageLoan.issue();
                }
                // call issueItems code here
                case 2 -> {
                    System.out.println("Option 2: Renew an existing loan");
                    System.out.println("\n");
                    renewLoan.extendLoan();
                }
                // call renewLoan code here
                case 3 -> {
                    System.out.println("Option 3: Return an item");
                    System.out.println("\n");
                    returnItem.returnLoanItem();
                }
                // call returnItems code here
                case 4 -> {
                    System.out.println("Option 4: Print items currently loaned");
                    System.out.println("\n");
                    viewItems.printItemsOnLoan();
                }
                case 5 -> {
                    System.out.println("Option 5: Print all items");
                    System.out.println("\n");
                    // stock
                    viewItems.printItemsInLibrary();
                }
                case 6 -> {
                    System.out.println("Option 6: Saving any changes... Exiting the program...");
                    keepGoing = false;
                }
                default -> {
                    System.out.println("Please select a valid option");
                    this.menu();
                }
            }
        }while(keepGoing);
        }catch(InputMismatchException e){
            System.out.println("There was an error with your input, please"
                    + " try again");
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
