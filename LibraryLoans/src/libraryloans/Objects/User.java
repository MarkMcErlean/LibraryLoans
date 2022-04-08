package libraryloans.Objects;

/**
 * Created by:
 * Mark McErlean (B00842054)
 * Stephen McKeown (B00839440)
 * 
 */
public class User {
    //User_id,first_name,last_name,email
    
    private final String userID;
    private final String fname;
    private final String lname;
    private final String email;
    
    
    
    
    // constructor to initialise the data in items
    
    public User(String userID, String fname, String lname, String email){
        
        this.userID = userID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }
    // Getters and setters
    
    public String getUserID(){
        return userID;
    }
    
    public String getFname(){
        return fname;
    }
    
    public String getLname(){
        return lname;
    }
    
    public String getEmail(){
        return email;
    }
    
    // Overriding the toString method to print easily
    
    @Override
    public String toString(){
        return "User ID: " + this.userID + "\nFirst Name: " + this.fname + "\nLast Name: " + this.lname + "\nEmail: " + this.email + "\n\n" ;
    }
    
}
