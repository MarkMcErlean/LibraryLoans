/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * class to be called to validate data integrity
 * 
 */
public class ValidateData {
    
    private CreateItems validateItems = new CreateItems();
    private CreateUsers validateUsers = new CreateUsers();
    private Scanner scan;
    
    
    ArrayList<Items> validItems;
    ArrayList<Users> validUsers;
    
    
    public void getItemsList(){
        if (validItems == null){
            validateItems.getItems();
            validItems = validateItems.itemsFromCSV;
        } 
        System.out.println(validItems.get(0));
    }
    
    public void getUsersList(){
        if (validUsers == null){
            validateUsers.getUsers();
            validUsers = validateUsers.usersFromCSV;
        } 
        //
    }

    // checks to see if a user exists
    public void checkUser(String user){
            String input;
            scan = new Scanner(System.in) ; // Creates scanner instance
            System.out.println("Please enter in the User ID: ");    //instruct user
            input = scan.next();                                    // accept input


            int size = validUsers.size();                   // get size of user list
            int counter = 0;                                //set counter to 0
            
            boolean found = false;                          // create boolean found flag, while found is false
            while (found == false && counter < size + 1 ){  // and counter is less than the size of array + 1
               for(int i = 0; i < size; i++){               // loop through array
                   Users u1 = validUsers.get(i);            // create temporary variable to store data at point i
                   String userID = u1.getUserID();          //create a string to hold the userID
                   if (userID.equals(input)){               // if userID == user input
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
        }
    }

    // checks to see if item exists
    public void checkItem(String bcode){
        String input;
            scan = new Scanner(System.in) ; // Creates scanner instance
            System.out.println("Please enter in the Barcode: ");    //instruct user
            input = scan.next();                                    // accept input


            int size = validItems.size();                   // get size of item list
            int counter = 0;                                //set counter to 0
            
            boolean found = false;                          // create boolean found flag, while found is false
            while (found == false && counter < size + 1 ){  // and counter is less than the size of array + 1
               for(int i = 0; i < size; i++){               // loop through array
                   Items i1 = validItems.get(i);            // create temporary variable to store data at point i
                   String barcode = i1.getBarcode();        //create a string to hold the barcode
                   if (barcode.equals(input)){              // if barcode == user input
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
        }
    }
    

    
}
