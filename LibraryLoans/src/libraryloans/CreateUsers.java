/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mark1
 */
public class CreateUsers {
    
        public void start(){
    //this.readUsersFromFile("ITEMS.csv");
    try{
        
        ArrayList<Users> usersReadFromFile = new ArrayList<Users>();
        usersReadFromFile = readUsersFromFile("USERS.csv");

        //System.out.println(loansReadFromFile); //prints the contents of the array
        int size = usersReadFromFile.size();                // get the size of arrayList
        
        for (int i =0; i < size; i++){                      // Loop through arrayList
            System.out.println(usersReadFromFile.get(i));   // print each obj
        }
        
        //System.out.println(usersReadFromFile.get(3)); //test reading specific record in array
    }catch(Exception e){
        //todo error message
    }

    

    //readItemsFromFile();
}


public static ArrayList<Users> readUsersFromFile(String fileName) throws FileNotFoundException {
        File file = new File("USERS.CSV");  //setting filename to ITEMS.csv
        Scanner s = new Scanner(file);      //initialising scanner to scan through the file

        ArrayList<Users> usersList = new ArrayList<Users>(); //

        while (s.hasNextLine()){                // while the scanner has a line to read
            String line = s.nextLine();         // set line to the next line

            String[] users = line.split(",");   // split the line at each comma

            //User_id,first_name,last_name,email
            
            String userID = users[0];          // set barcode value to the 0th value in loans array
            String fname = users[1];           // set userID value to 1st in array
            String lname = users[2];            // set issueID to 2nd in array
            String email = users[3];             // set type
                       
          
          

            // create object of item
            Users newUser = new Users(userID, fname, lname, email);

            //add the new object to the list of objects
            usersList.add(newUser);
            //System.out.println(items[0]); //test to see if array stores data (it does)
        }
        return usersList;                        //return statement for ArrayList

  
}
 
    
}
