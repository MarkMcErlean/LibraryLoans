
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
 * Reads data from a file and stores the data as an object in an arrayList
 * 
 */
public class LoanReader {
    public ArrayList<Loan> getLoans(String filename){
        return getLoansFromCSV(filename);
    }

private ArrayList<Loan> getLoansFromCSV(String fileName){
        ArrayList<Loan> loanList = new ArrayList<Loan>();
        
        try{
        File file = new File(fileName);
        Scanner lineScanner = new Scanner(file);
        String headerLine = lineScanner.nextLine();
        
         while (lineScanner.hasNextLine()){
            String line = lineScanner.nextLine();
            //add the new object to the list of objects
            loanList.add(loanFromString(line));
        }
        
        return loanList;
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