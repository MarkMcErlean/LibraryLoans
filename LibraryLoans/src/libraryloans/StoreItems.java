package libraryloans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mark1
 */
import java.io.*;
import java.util.Scanner;


public class StoreItems {
    public void tempName()
	{
           PrintWriter pw = null;
            
            try{
                pw = new PrintWriter("ITEMS.csv");
                pw.println("Barcode,Author/Artist,Title, Type, Year,");
                
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
                System.exit(1);
             }
           
            Items[] items = new Items[5];
             ////initilising an instance using the first constructor
            //items[0] = new Items("BMW", 2500, 2006, 20000);
           // produceReport(pw, items[0]);
            /////initialising an istance using the second constructor
            //items[1] = new Items("Volkswagen", 1.6, 2005, 14000);
            //produceReport(pw, items[1]);
            ////initialising an instance using the default constructor with details being entered from keyboard
            //items[2] = new Items();
            ////create the first instance using the default constructor with details being entered from keyboard
            //Scanner cin = new Scanner(System.in);
            //readDetailsFromKeyboard(cin, items[2]);
            //produceReport(pw, items[2]);
            //items[2].displayDetails();
            ////Read the details of the other multiple items from a file
           
            Scanner in = null;
            
            //the first scan to get the number of items recorded in a file
            int nLines = 0;
            try
            { 	in = new Scanner(new File("ITEMS.csv"));
                while(in.hasNextLine())
                {
                    nLines++;    
                    in.nextLine();
            }
            } catch (FileNotFoundException ex)
            { 	System.out.println(ex.getMessage());
                    System.out.println("in " + System.getProperty("user.dir"));
                    System.exit(1);
            }
            
            Items[] itemsFromFile = new Items[nLines];
            nLines = 0;
            //the second scan to get the details of each Items
            try
            { 	in = new Scanner(new File("ITEMS.csv"));
            }catch (FileNotFoundException ex)
            { 	System.out.println(ex.getMessage());
                    System.out.println("in " + System.getProperty("user.dir"));
                    System.exit(1);
            }
            while (in.hasNextLine())
            { 
                //itemsFromFile[nLines] = new Items();
                readFromFile(in, itemsFromFile[nLines]);
                itemsFromFile[nLines].displayDetails();
                produceReport(pw, items[nLines]);
                nLines++;
            }
		
            in.close();
            pw.close();

	}
        
        public static void readFromFile(Scanner in, Items Items)
	{	// read in details from a file
            String barcode = in.next();
            Items.setbarcode(barcode);
            if (in.hasNextLine())
		Items.setAuthorArtist(in.nextLine());
            else
		Items.setAuthorArtist("Unknown");
               // Items.setTitle(in.next());
               // Items.setType(in.next());
               // Items.setYear(in.nextInt());
               // Items.setISBN(in.next());
		//in.nextLine();
	}

    public static void produceReport(PrintWriter out, Items items){
            
            //System.out.println(items.getbarcode()+","+items.getAuthorArtist()+","+ items.getTitle()+","+items.getType()+","+ items.getYear())+","+items.getISBN();
            System.out.println(items.getbarcode()+","+items.getauthorArtist());
               
        }

}
