/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libraryloans;
import java.util.Scanner;
import java.io.*;
import java.time.*;
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
     * 
     *  upon program start, should read from three csv files
     *  to populate application with previously stored data 
     *  as a starting point
     */
    
    private String[] itemsList = {};
    private String[] loansList = {};
    private String[] usersList = {};
           
    
    
    private void readItems(){
        try{            
            File items = new File ("D:\\Java stuff\\LibraryLoans\\LibraryLoans\\LibraryLoans\\src\\libraryloans\\ITEMS.csv");
        Scanner myReader = new Scanner(items);
        myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            System.out.println(data);
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");
            
        }
    }
 
    private void readLoans(){
        try{            
            File loans = new File ("D:\\Java stuff\\LibraryLoans\\LibraryLoans\\LibraryLoans\\src\\libraryloans\\LOANS.csv");
        Scanner myReader = new Scanner(loans);
        myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            System.out.println(data);
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");
            
        }
    }
    
     private void readUsers(){
        try{            
            File users = new File ("D:\\Java stuff\\LibraryLoans\\LibraryLoans\\LibraryLoans\\src\\libraryloans\\USERS.csv");
        Scanner myReader = new Scanner(users);
        myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            System.out.println(data);
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");
            
        }
    }
    
    
    public void start(){
        this.readItems();
        this.readLoans();
        this.readUsers();
    }
    
    
    public static void main(String[] args) {
        // items, users and loans stored as lists/arrays
        LibraryLoans libLoan = new LibraryLoans();
        
        libLoan.start();
        
        // Wnhen program exits, list of loans should be written to LOANS.csv
    }
    
}
