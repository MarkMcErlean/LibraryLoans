
package libraryloans;
import libraryloans.Readers.UserReader;
import libraryloans.Readers.ItemReader;
import libraryloans.Readers.LoanReader;
import libraryloans.Writers.LoanWriter;
import java.util.*;
import libraryloans.Objects.Item;
import libraryloans.Objects.User;
import libraryloans.Objects.Loan;
/**
 * Program is intended to store and manage details of 
 * library items currently on loan to library users according
 * to a list of functional requirements
 * 
 * CONSOLE INTERFACE 
 * 
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 */
public class LibraryLoans {
    
    private final ItemReader populateItems = new ItemReader();
    private final LoanReader populateLoans = new LoanReader();
    private final UserReader populateUsers = new UserReader();
    private LoanWriter loanWriter;
    private loanManager manageLoan;
    private RenewLoan renewLoan;
    private ReturnItem returnItem;
    private ViewItems viewItems;


    private void start(){
        ArrayList<Item> items = populateItems.getItems("ITEMS.csv");
        ArrayList<Loan> loans = populateLoans.getLoans("LOANS.csv");
        ArrayList<User> users = populateUsers.getUsers("USERS.csv");
        DataValidator validator = new DataValidator(items, users);
        manageLoan = new loanManager(items, loans, validator);
        viewItems = new ViewItems(items, loans);
        renewLoan = new RenewLoan(loans, items, validator, manageLoan);
        returnItem = new ReturnItem(loans, validator);
        loanWriter = new LoanWriter(loans);
        this.menu();

    }
    
    public void continueToMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Press enter to continue to menu...");
        String continueToMenu = scan.nextLine();
    }
    
    private void menu(){
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
                    this.continueToMenu();
                }
                // call issueItems code here
                case 2 -> {
                    System.out.println("Option 2: Renew an existing loan");
                    System.out.println("\n");
                    renewLoan.extendLoan();
                    this.continueToMenu();
                }
                // call renewLoan code here
                case 3 -> {
                    System.out.println("Option 3: Return an item");
                    System.out.println("\n");
                    returnItem.returnLoanItem();
                    this.continueToMenu();
                }
                // call returnItems code here
                case 4 -> {
                    System.out.println("Option 4: Print items currently loaned");
                    System.out.println("\n");
                    viewItems.printItemsOnLoan();
                    this.continueToMenu();
                }
                case 5 -> {
                    System.out.println("Option 5: Print all items");
                    System.out.println("\n");
                    // stock
                    viewItems.printItemsInLibrary();
                    this.continueToMenu();
                }
                case 6 -> {
                    System.out.println("Option 6: Saving any changes... Exiting the program...");
                    loanWriter.writeToFile("LOANS.csv");
                    keepGoing = false;
                    
                }
                default -> {
                    System.out.println("Please select a valid option");
                    this.continueToMenu();
                    this.menu();
                }
            }
        }while(keepGoing);
        }catch(InputMismatchException e){
            System.out.println("There was an error with your input, please"
                    + " try again");
            this.continueToMenu();
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
