/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans.Objects;

/**
 *
 * @author mark1
 */
public class User {
    //User_id,first_name,last_name,email
    
    private String userID;
    private String fname;
    private String lname;
    private String email;
    
    
    
    
    // constructor to initialise the data in items
    
    public User(String userID, String fname, String lname, String email){
        
        this.userID = userID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }
    
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
    
   
    
    
    @Override
    public String toString(){
        return "User ID: " + this.userID + "\nFirst Name: " + this.fname + "\nLast Name: " + this.lname + "\nEmail: " + this.email + "\n\n" ;
    }
    
}
