/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import libraryloans.Objects.Item;
import libraryloans.Objects.User;
import libraryloans.Readers.ItemReader;
import libraryloans.Readers.UserReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to be called to validate data integrity
 * 
 */
public class DataValidator {
    
    private ItemReader readItems = new ItemReader();
    private UserReader readUsers = new UserReader();
    //private IssueItem issueItem = new IssueItem();
    private Scanner scan = new Scanner(System.in);
    
    
    private ArrayList<Item> validItems;
    private ArrayList<User> validUsers;
    //protected String requestedUserId;
    //protected String requestedBarcode;
    
    public DataValidator(
            ArrayList<Item> itemsList,
            ArrayList<User> usersList 
    ){
        validItems = itemsList;
        validUsers = usersList;
    }
  
    private String requestInput(String message) {
        System.out.println(message);
        String input = scan.next();
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
        for (int index = 0; index < validUsers.size(); index++){
                if (requestedUserId.equalsIgnoreCase(validUsers.get(index).getUserID())){
                    System.out.println("User found");
                    return true;
                }
            }
           
            System.out.println(" User not found : Invalid userID");  // if still not found, print message 
            return false;
    }
    
//    public boolean CheckUsers3(){
//        requestedUserId = requestInput("Please enter in the User ID: ");
//        
//        validUsers.forEach((User user) -> { 
//            if (requestedUserId.equalsIgnoreCase(user.getUserID())) {
//                System.out.println("User found");
//                return true;
//            }
//            System.out.println(" User not found : Invalid userID");
//            return false; 
//        });
//    }

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
	for (int index = 0; index < validItems.size(); index++){
		if(requestedBarcode.equalsIgnoreCase(validItems.get(index).getBarcode())){
			System.out.println("Item found");
			return true;
		}

	}
	
	System.out.println("Item not found : invalid barcode");
	return false;
    }




}
