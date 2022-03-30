/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to be called to validate data integrity
 * 
 */
public class ValidateData {
    
    private CreateItems validateItems = new CreateItems();
    private CreateUsers validateUsers = new CreateUsers();
    //private IssueItem issueItem = new IssueItem();
    private Scanner scan;
    
    
    protected ArrayList<Items> validItems;
    protected ArrayList<Users> validUsers;
    protected String uID;
    protected String bcode;
    
    
    public void getItemsList(){
        if (validItems == null){
            validateItems.getItems();
            validItems = validateItems.itemsFromCSV;
        } 
        //System.out.println(validItems.get(0));
    }
    
    public void getUsersList(){
        if (validUsers == null){
            validateUsers.getUsers();
            validUsers = validateUsers.usersFromCSV;
        } 
       
    }

    // checks to see if a user exists
    public boolean checkUser(){
            //String input;
            scan = new Scanner(System.in) ; // Creates scanner instance
            System.out.println("Please enter in the User ID: ");    //instruct user
            uID = scan.next();                                    // accept input


            int size = validUsers.size();                   // get size of user list
            int counter = 0;                                //set counter to 0
            
            boolean found = false;                          // create boolean found flag, while found is false
            while (found == false && counter < size + 1 ){  // and counter is less than the size of array + 1
               for(int i = 0; i < size; i++){               // loop through array
                   Users u1 = validUsers.get(i);            // create temporary variable to store data at point i
                   String userID = u1.getUserID();          //create a string to hold the userID
                   if (userID.equals(uID)){               // if userID == user input
                       System.out.println("User found");    // print found
                       found = true;                        // set found flag to true
                   }    
                   else{                                
                       counter += 1;                        // otherwise increment counter
                   }
                } 
            } 
        if (found == false){
                System.out.println(" User not found : Invalid userID");  // if still not found, print message 
                return false;
        } else{
            return true;
        }
    }

    // checks to see if item exists
    public boolean checkItem(){
        String input;
            scan = new Scanner(System.in) ; // Creates scanner instance
            System.out.println("Please enter in the Barcode: ");    //instruct user
            bcode = scan.next();                                    // accept input


            int size = validItems.size();                   // get size of item list
            int counter = 0;                                //set counter to 0
            
            boolean found = false;                          // create boolean found flag, while found is false
            while (found == false && counter < size + 1 ){  // and counter is less than the size of array + 1
               for(int i = 0; i < size; i++){               // loop through array
                   Items i1 = validItems.get(i);            // create temporary variable to store data at point i
                   String barcode = i1.getBarcode();        //create a string to hold the barcode
                   if (barcode.equals(bcode)){              // if barcode == user input
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
