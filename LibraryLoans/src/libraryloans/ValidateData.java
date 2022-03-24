/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mark1
 */
public class ValidateData {
    
    private String[] itemsList = {"25832497", "240453126"}; // example strings
    private String[] loansList = {};
    private String[] usersList = {"b00839440", "b00842054"};
    private Scanner scan;
    
    // checks to see if a user exists
    public void checkUser(){
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
    
    // checks to see if item exists
    public void checkItem(){
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
    
}
