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
public class CreateLoans {
    
    public void start(){
    //this.readLoansFromFile("ITEMS.csv");
    try{
        
        ArrayList<Loans> loansReadFromFile = new ArrayList<Loans>();
        loansReadFromFile = readLoansFromFile("LOANS.csv");

        //System.out.println(loansReadFromFile); //prints the contents of the array
        int size = loansReadFromFile.size();                // get size of arrayList
        
        for (int i =0; i < size; i++){                      // loop through arrayList
            System.out.println(loansReadFromFile.get(i));   // reading each record
        }
        
        //System.out.println(loansReadFromFile.get(3)); //test reading specific record in array
    }catch(Exception e){
        //todo error message
    }

    

    //readItemsFromFile();
}


public static ArrayList<Loans> readLoansFromFile(String fileName) throws FileNotFoundException {
        File file = new File("LOANS.CSV");  //setting filename to ITEMS.csv
        Scanner s = new Scanner(file);      //initialising scanner to scan through the file

        ArrayList<Loans> loansList = new ArrayList<Loans>(); //

        while (s.hasNextLine()){                // while the scanner has a line to read
            String line = s.nextLine();         // set line to the next line

            String[] loans = line.split(",");   // split the line at each comma

            //Barcode,User_id,Issue_Date,Due_Date,numRenews
            
            String barcode = loans[0];          // set barcode value to the 0th value in loans array
            String userID = loans[1];           // set userID value to 1st in array
            String issueDate = loans[2];            // set issueID to 2nd in array
            String dueDate = loans[3];             // set type
            String numRenews = loans[4];             // set year
          
          

            // create object of item
            Loans newLoan = new Loans(barcode, userID, issueDate, dueDate, numRenews);

            //add the new object to the list of objects
            loansList.add(newLoan);
            //System.out.println(items[0]); //test to see if array stores data (it does)
        }
        return loansList;                        //return statement for ArrayList

  
}
    
}
