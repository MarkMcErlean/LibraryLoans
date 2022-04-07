
package libraryloans.Readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import libraryloans.Objects.Loan;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 */
public class LoanReader {
    public ArrayList<Loan> getLoans(String filename){
        return getLoansFromCSV(filename);
    }

private ArrayList<Loan> getLoansFromCSV(String fileName){
        ArrayList<Loan> loanList = new ArrayList<Loan>();
        
        try{
        File file = new File(fileName);  //setting filename to ITEMS.csv
        Scanner lineScanner = new Scanner(file);      //initialising scanner to scan through the file
        String headerLine = lineScanner.nextLine();
        
         while (lineScanner.hasNextLine()){
            String line = lineScanner.nextLine();
            //add the new object to the list of objects
            loanList.add(loanFromString(line));
        }
        
        return loanList;                        //return statement for ArrayList
    } catch (FileNotFoundException e) {
        System.out.println("Error reading file");
        return loanList;
        }
}

private Loan loanFromString(String loanString){
    String[] loanContents = loanString.split(",");
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    return new Loan(
        loanContents[0], 
        loanContents[1],
        //parse date sections of line to LocalDate
        LocalDate.parse(loanContents[2], formatter),
        LocalDate.parse(loanContents[3], formatter),
        Integer.parseInt(loanContents[4])
        );
    }
}