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
    
    private ItemReader validateItems = new ItemReader();
    private UserReader validateUsers = new UserReader();
    //private IssueItem issueItem = new IssueItem();
    private Scanner scan = new Scanner(System.in);
    
    
    private ArrayList<Item> validItems;
    private ArrayList<User> validUsers;
    protected String requestedUserId;
    
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

    // checks to see if item exists
    public boolean checkItem(ArrayList<Item> itemsList){
        String input;
         // Creates scanner instance
        System.out.println("Please enter in the Barcode: ");    //instruct user
        requestedBarcode = scan.next();                                    // accept input


        int size = validItems.size();                   // get size of item list
        int counter = 0;                                //set counter to 0

        boolean found = false;                          // create boolean found flag, while found is false
        while (found == false && counter < size + 1 ){  // and counter is less than the size of array + 1
           for(int i = 0; i < size; i++){               // loop through array
               Item i1 = validItems.get(i);            // create temporary variable to store data at point i
               String barcode = i1.getBarcode();        //create a string to hold the barcode
               if (barcode.equals(requestedBarcode)){              // if barcode == user input
                   System.out.println("Item found");    // print found
                   found = true;                        // set found flag to true
               }    
               else{                                
                   counter += 1;                        // otherwise increment counter
               }
            } 
        } 
        if (found == false){
                System.out.println(" Item not found : Invalid Barcode");  // if still not found, print message 
                return false;
        }else{
            return true;
        }
    }   
}
