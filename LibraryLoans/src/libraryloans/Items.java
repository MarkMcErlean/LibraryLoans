package libraryloans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mark1
 */
public class Items {
    // properties
	//private static final int CURRENT_YEAR = 2011;
	//private static int totalNum = 0;
	
	private String barcode;
	private String authorArtist;
	private String title;
	private String type;
        private int year;
        private String isbn;
	
	//constructors
	public Items(String inBarcode, String inAuthorArtist, String inTitle, String inType, int inYear, String inISBN)
	{
            this.barcode = inBarcode;
            this.authorArtist = inAuthorArtist;
            this.title = inTitle;
            this.type = inType;
            this.year = inYear;
            this.isbn = inISBN;
	}
	
	//methods

	public void displayDetails()
	{	// display results
            System.out.println("Barcode: " + this.barcode);
            System.out.println("Author/Artist: " + this.authorArtist);
            System.out.println("Title: " + this.title);
            System.out.println("Type: " + this.type);
            System.out.println("Year: " + this.year);
            System.out.println("ISBN: " + this.isbn);

		
	}
	
	public String getbarcode()
	{
		return this.barcode;
	}

	public void setbarcode(String inBarcode)
	{
		this.barcode = inBarcode;
	} //allows changes to barcodes on record
        
        public void setAuthorArtist(String inAuthorArtist)
	{
		this.authorArtist = inAuthorArtist;
	} //allows changes to barcodes on record

	public String getauthorArtist()
	{
		return this.authorArtist;
	}


	public int getYear()
	{
		return this.year;
	}


	

}
