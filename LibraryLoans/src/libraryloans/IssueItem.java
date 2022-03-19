package libraryloans;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 * 
 * This class will be used to create a new loan
 * librarian will supply a barcode and user ID
 * System will check if supplied details exist.
 * 
 */
public class IssueItem {
    
    //Book loans are for a four week period
    //Multimedia loans are for a one week period
    // when item is issued, create a loan object and add to list/array of loans
    
    private String[] itemsList = {"25832497", "240453126"}; // example strings
    private String[] loansList = {};
    private String[] usersList = {"b00839440", "b00842054"};
    private Scanner scan;
    
    
    private void checkUser(){
        String input;
        
        scan = new Scanner (System.in) ; // Creates scanner instance
        System.out.println("Please enter in the User ID: ");
        
        input = scan.next();
        boolean result = Arrays.stream(usersList).anyMatch(input::equals);
	if (result) 
            System.out.println("This User ID exits in the system.");
        else 
            System.out.println("This User ID does not exist.");
    }
    
    
    private void checkItem(){
        String input;
        
        scan = new Scanner (System.in) ; // Creates scanner instance
        System.out.println("Please enter in the item barcode: ");
        
        input = scan.next();
        boolean result = Arrays.stream(usersList).anyMatch(input::equals);
	if (result) 
            System.out.println("This item exits in the system.");
        else
            System.out.println("This item does not exist in the system.");
    }
    
    
    public void start(){
        this.checkUser();
        this.checkItem();
    }
    
    
    public static void main(String[] args) {
        IssueItem issItem = new IssueItem();
        issItem.start();
    }
    
    
}

