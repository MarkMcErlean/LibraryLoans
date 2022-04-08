
package libraryloans.Writers;

import java.util.ArrayList;
import libraryloans.Objects.Loan;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 */
public class LoanWriter {
    private ArrayList<Loan> loans;
    private FileWriter writer;
    
    public LoanWriter(ArrayList<Loan> loansList){
        loans = loansList;
    }
    
    
    public void writeToFile(String fileName){
       try{
           writer = new FileWriter(fileName);
           String headerLine = "Barcode,User_id,Issue_Date,Due_Date,numRenews\n";
           writer.write(headerLine);
            //loop through loans
        for(Loan loan : loans){
            
            String line = loan.getBarcode() + "," 
                    + loan.getUserID() + "," 
                    + loan.getIssueDateAsString() 
                    + "," + loan.getDueDateAsString() 
                    + "," + loan.getNumRenewsAsString() + "\n";
        writer.write(line);
        }
        writer.close();
          
        }catch(IOException e){
            System.out.println("Error found: Input/Output error");
       }
    }
    
    
   
    
}
