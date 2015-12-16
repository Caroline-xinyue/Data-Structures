/*****************************************************************************
 * Assignment 3
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 9/29/2015
 * 
 * The main program for project 3.
 *
 * This program reads the file from "Xinyue_A3.txt" using java.util.Scanner, 
 * parse the data and save the zipcode, town and states into an array of Place 
 * objects. Then it asks user for a given zipcode, check its validity, then 
 * search it inside the Place[] array and returns the location to the user as
 * well as printing out all the interactions in the Console Output. In addition, * this program compares the time used by linear search and binary search and 
 * print them out in the console.
 *****************************************************************************/

/** A class that replies the location search results of a 
 *  given US Postal Zip Code, with user interaction.
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 */

// import all the interfaces
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class Xinyue_A3 {
    static Place[] p;// an array of Place objects
    static int length;// length of the file, also the length of the array

     // method readData
    /** Open an input stream to the data file, read the first line from it and extract
     *  the number of entries in the file (print this out). Read each line, and print it
     *  out in the console.
     */
    public static void readData(){
	// Open an input stream to the data file, read the first line from it and extract
	// the number of entries in the file. Then read each line, and store the zipcode,
	// town and state into an array of Place objects.
	
	String line;// each line of the input file readed by Scanner
	int i = 0;// index for array Place[]
	
	// load the file and parse the data, then saved in an array of Place objects.
	try {
	    Scanner sc = new Scanner(new File("Xinyue_A3_data.txt"));
	    while(sc.hasNextLine()) {
		line = sc.nextLine();
		if(line.charAt(0)=='#') {
		    String[] tokens = line.split("[# ,]+");
		    length = Integer.parseInt(tokens[1]);
		    p = new Place[length];
		}else{
		    String[] pieces = line.split("[\t,]");
		    p[i] = new Place(pieces[0], pieces[3], pieces[4]);
		    i++;
		}
	    }
	} catch(FileNotFoundException fnfe) { // catch potential error when file is missing
	    JOptionPane.showMessageDialog(null, "The file is not found!");
	    System.exit(1);
	}
    } // end of readData()

     // method search
    /** Searching for the given zip code.
     * @param p    an array of Place objects to be searched
     *        zip  the zipcode string to be searched for within the array
     * @return returns the index when the zip code is found, and returns -1 otherwise.
     */
    public static int search(Place[] p, String zip) {
	long timeLinear = 0; // the time that search method takes
	long startLinear = System.nanoTime();
	for(int k = 0; k < p.length; k++) {
	    if(p[k].equals(zip)) {
		timeLinear = System.nanoTime() - startLinear;
		System.out.println("The zipcode was found! \tThe linear search takes " + timeLinear + " nanoseconds to find it");
		return k;
	    }
	}
	timeLinear = System.nanoTime() - startLinear;
	System.out.println("The zipcode was not found! \tThe linear search takes " + timeLinear + " nanoseconds to find it");
	return -1;
    }

    // method binarySearch
    /** Call the static method sort() and binarySearch() from class Arrays, find the string
     * zipcode in the array and return its index. If not found, returns a negative value.
     *
     * @param  place    an array of Place objects to be searched
     *         zipcode  the zipcode string to be searched for within the array
     * @return if the key zipcode is contained in the array, return its index; otherwise, return 
     *         (-(insertion point) -1).
     *         The insertion point is defined as the point at which the key would be inserted into the
     *         array: the index of teh first element in the range greater than the key, or toIndex if
     *         all elements in the range are less than the specified key.
     */
    public static int binarySearch(Place[] place, String zipcode) {
	long timeBinary = 0; // the time that binarySearch method take
	Arrays.sort(place);
	Place key = new Place(zipcode, null, null);
	long startBinary = System.nanoTime();
	int biSearch =  Arrays.binarySearch(place, key);
	timeBinary = System.nanoTime() - startBinary;
	if(biSearch >= 0) {
	    System.out.println("The zipcode was found! \tThe binary search takes " + timeBinary + " nanoseconds to find it");
	} else {
	    System.out.println("The zipcode was not found! \tThe binary search takes " + timeBinary + " nanoseconds to find it");
	}
	return biSearch;
    }

    // method testValidity
    /** Test whether the given string is a valid 5 digit number.
     *
     * @param the string to be tested, whether it's a valid 5 digit
     * @return returns true if s is a valid 5 digit number, and returns false otherwise
     */
    public static boolean testValidity (String s) {
	if(s.length() != 5) {
	    JOptionPane.showMessageDialog(null, "You didn't type in a valid 5 digit US zip code! \nPlease try again.");
	    System.out.println("You didn't type in a valid 5 digit US zip code! \nPlease try again.");
	    return false;
	}
	    boolean returnValue = false;
	    try {
		int t = Integer.parseInt(s);
		returnValue = true;
	    } catch(NumberFormatException nfe) {
		JOptionPane.showMessageDialog(null, "You didn't type in a valid 5 digit US zip code! \nPlease try again.");
		System.out.println("You didn't type in a valid 5 digit US zip code! \nPlease try again.");
	    }
	return returnValue;
    }
    
    // main method
    /** Returns the location search results of a 
     *  given US Postal Zip Code, with user interaction.
     *
     * @param potential user input in the console --not used
     */
    public static void main (String[] args) {
	int response = 0;// user response that controls the exiting of the program
	String[] choices = {"Yes", "No"};// user choices for whether search again
	int j = 0;// index for searching in the array Place[]
	int k = 0;// index for the binary search in class Place
	boolean valid; // whether user input a valid zip codes
	
	readData();
	do {
		String zip = JOptionPane.showInputDialog("You asked me to search for zip code: ");// ask user for input zipcode
		if(zip == null) { //exit the program when users choose CANCEL
			JOptionPane.showMessageDialog(null, "Good Bye!");
			System.out.println("Good Bye!");
			System.exit(1);
		}
		valid = testValidity(zip);
		if(valid) {
		    System.out.println("You asked me to search for zip code: " + zip);

		    // original search algorithm
		    j = search(p,zip);


		    // binary search algorithm
		    k = binarySearch(p, zip);

		    if(k >= 0) {
			// if found the zipcode, return the result to the user and ask him/her to choose whether to search again,
			// using the showOptionDialog of JOptionPane.
			System.out.println("The zip code " + zip + " belongs to " + p[k]);
			response  = JOptionPane.showOptionDialog(null, "The zip code " + zip + " belongs to " + p[k]
								 + "\nDo you want me to search again?", "Operation menu",
								 JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
								 choices, choices[0]);
		    } else {
		        // if the zipcode not found, tell the user that it doesn't exist and ask him/her to chooce whether to search again, using the 
		        // showOptionDialog of JOptionPane.
			System.out.println("The zip code " + zip + " does not exist.");
			response  = JOptionPane.showOptionDialog(null, "The zip code " + zip + " does not exist."
								 + "\nDo you want me to search again?", "Operation menu",
								 JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
								 choices, choices[0]);
		    }
		}
		
		// print out all user interactions in the Console Window. Also show message dialog "Good Bye!" to user if they choose
		// not to search again.
		if(response == 0) {
		    System.out.println("Do you want me to search again? " + "Yes");
		} else {
		    System.out.println("Do you want me to search again? " + "No");
		    System.out.println();
		    JOptionPane.showMessageDialog(null, "Good Bye!");
		    System.out.println("Good Bye!");
		}
		System.out.println();
	} while(response == 0);// The program keep running if user chooce "YES"
    } // end of main();
} // end of class A3
