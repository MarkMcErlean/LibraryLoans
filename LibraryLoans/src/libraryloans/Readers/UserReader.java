
package libraryloans.Readers;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import libraryloans.Objects.User;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 *  Reads data from a file and puts it into the object "User"
 * 
 * @author mark1
 */
public class UserReader {
    public ArrayList<User> getUsers(String filename){
        return getUsersFromCSV(filename);
    }

private ArrayList<User> getUsersFromCSV(String fileName) {
    ArrayList<User> userList = new ArrayList<User>();

    try {
        File file = new File(fileName);
        Scanner lineScanner = new Scanner(file);  

/* While the file has more lines, take the next line and convert to an 
loan, then add to the list of loans.
*/
        String headerLine = lineScanner.nextLine();
        while (lineScanner.hasNextLine()){
        String line = lineScanner.nextLine();
//add the new object to the list of objects
        userList.add(userFromString(line));
        }

    return userList;                        //return statement for ArrayList
    } catch (Exception e) {
        System.out.println("Error reading file");
    return userList;
    }   
}
 
  private User userFromString(String userString) {
            String[] userContents = userString.split(",");   // split the line at each comma
            
            
            return new User(
                userContents[0], 
                userContents[1],
                userContents[2],
                userContents[3]
                );
  }
  
}
