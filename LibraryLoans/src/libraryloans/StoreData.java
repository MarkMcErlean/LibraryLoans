package libraryloans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        String data = "";
        int counter = 0;
        
        try{            
            File items = new File ("ITEMS.csv");
            Scanner myReader = new Scanner(items);
            //myReader.useDelimiter(","); // sets a comma as the delimiter
        
        while (myReader.hasNextLine())
        {
            data = myReader.nextLine();
            //System.out.println(data);
            itemsList = data.split(",");
            //itemsList = data.split(",");
            //System.out.println(itemsList[0]); // checking that the array stores data
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
            //System.out.println(data);
            loansList = data.split(",");
            //System.out.println(loansList[0]); // checking that the array stores data
  
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
            //System.out.println(data);
            usersList = data.split(",");
            //System.out.println(usersList[0]); // checking that the array stores data
        }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occured.");
            e.getStackTrace();
            
        }
        
    }
     
     public void start(){
        
        this.readItems();
        this.readLoans();
        this.readUsers();
    }
     
}
