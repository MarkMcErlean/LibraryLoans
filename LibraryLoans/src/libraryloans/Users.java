/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryloans;

/**
 *
 * @author mark1
 */
public class Users {
    //User_id,first_name,last_name,email
    
    private String users;
    private String fname;
    private String lname;
    private String email;
    
    
    
    
    // constructor to initialise the data in items
    
    public Users(String users, String fname, String lname, String email){
        
        this.users = users;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        
        
    }
    
    public String getUsers(){
        return users;
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
        return "User: " + this.users + "\nFirst Name: " + this.fname + "\nLast Name: " + this.lname + "\nEmail: " + this.email + "\n\n" ;
    }
    
}
