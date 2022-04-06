/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import libraryloans.Objects.Item;
import libraryloans.Objects.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to be called to validate data integrity
 * 
 */
public class DataValidator {

    //private IssueItem issueItem = new IssueItem();
    private final Scanner scan = new Scanner(System.in);

    private final ArrayList<Item> validItems;
    private final ArrayList<User> validUsers;
    
    public DataValidator(
            ArrayList<Item> itemsList,
            ArrayList<User> usersList 
    ){
        validItems = itemsList;
        validUsers = usersList;
    }
  
    private String requestInput(String message) {
        System.out.println(message);
        String input = scan.nextLine();
        return input;
    }
    
    public String getAndCheckUserId(){
        boolean valid = false;
        String userId;
        do {
            //String input;    
            userId = requestInput("Please enter in the User ID: ");
            if (checkUser(userId)){
                valid = true;
            } else {
                System.out.println("Invalid User, you will need to enter again.");
            }
        } while (!valid);
        return userId;
    }
    
    private boolean checkUser(String requestedUserId){
        for (User validUser : validUsers) {
            if (requestedUserId.equalsIgnoreCase(validUser.getUserID())) {
                System.out.println("User found");
                return true;
            }
        }
           
            System.out.println(" User not found : Invalid userID");  // if still not found, print message 
            return false;
    }


public String getAndCheckBarcode(){
    boolean valid = false;
    String barcode;
    do{
        barcode = requestInput("Please enter barcode: ");
        if (checkItem(barcode)){
            valid = true;
        }else{
        System.out.println("Invalid item, you will need to enter again.");
        }
    }while (!valid);
    return barcode;
}


public boolean checkItem(String requestedBarcode){
    for (Item validItem : validItems) {
        if (requestedBarcode.equalsIgnoreCase(validItem.getBarcode())) {
            System.out.println("Item found");
            return true;
        }

    }
	
	System.out.println("Item not found : invalid barcode");
	return false;
    }




}
