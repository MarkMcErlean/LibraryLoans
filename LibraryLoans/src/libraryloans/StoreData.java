package libraryloans;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 *
 *Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00    )
 */
 
public class StoreData {
    private String[] itemsList = {};
    private String[] loansList = {};
    private String[] usersList = {};
    
    
    public void readItems(){
        try{            
            File items = new File ("ITEMS.csv");
        Scanner myReader = new Scanner(items);
        //myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            //System.out.println(line);
            itemsList = data.split(",");
            //System.out.println(loansList[0]); // checking that the array stores line
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");  
            e.getStackTrace();
        }
        
    }
        
 
    public void readLoans(){
        try{            
            File loans = new File ("LOANS.csv");
        Scanner myReader = new Scanner(loans);
        myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            //System.out.println(line);
            loansList = data.split(",");
            //System.out.println(loansList[0]); // checking that the array stores line
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");  
            e.getStackTrace();
        }
    }
    
     public void readUsers(){
        try{            
            File users = new File ("USERS.csv");
        Scanner myReader = new Scanner(users);
        myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            //System.out.println(line);
            usersList = data.split(",");
            //System.out.println(usersList[0]); // checking that the array stores line
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");
            e.getStackTrace();
            
        }
        
    }
     
     public void start(){
        
        this.readItems();
       // this.readLoans();
       // this.readUsers();
    }
     
}
