/*****************************************************************************
 * Assignment 4
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 10/08/2015
 *
 * The main program for project 4.
 *
 * This program reads the file from "Xinyue_A4_data.txt" using java.util.Scanner,
 * parse the data and stores it into an Arraylist of Place objects. In this main
 * program, it first reads the data and prints out the number of entries. Later,
 * it uses System.in method of the Scanner class to ask user for a valid formatted
 * town and the state it is in, search and compare them inside the arraylist
 * placeArrayList and then prints out all the related information to the
 * Console Window.
 *****************************************************************************/

// import all the interfaces
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*****************************************************************************
 *  A class that replies all the information found about a
 *  given US town and the state it's in, with user interaction
 *  in the Console Window.
 *
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 *
 *****************************************************************************/
public class SearchZipCode {

    public static ArrayList<Place> placeArrayList = new ArrayList<Place>();
    public static Place newPlace;
    // method readData
    /** Open an input stream to the data file, read each line, split the
     * information and stores the trimed information in an arrayList of 
     * Place objects.
     */
    public static void readData() {
        try {
            Scanner data = new Scanner(new File("Xinyue_A4_data.txt"));
            while (data.hasNextLine()) {
                String[] pieces = data.nextLine().split(",");
                for(int i = 0; i < pieces.length; i++) {
                    pieces[i] = pieces[i].trim();
                }
                newPlace = new Place(pieces[0],pieces[1], pieces[2], pieces[3], pieces[5], pieces[6], pieces[9]);
                placeArrayList.add(newPlace);
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("The file is not found!");
        }
    } // end of readData() method

    // method search
    /** Searching for the given town and state, and count the number of comparison
     * @param town   the town to be searched for within the arraylist
     *        state  the state to be searched for within the arraylist
     * @return returns the index when the query is found; returns -1 otherwise.
     */
    public static int search(String town, String state) {
	int count = 0;
	for(int i = 0; i < placeArrayList.size(); i++) {
	    if (placeArrayList.get(i).equals(town, state)) {
		count++;
		System.out.println("It takes " + count + " comparisons to answer this query");
		return i;
	    }
	    count++;
	}// end of for loop
        System.out.println("It takes " + count + " comparisons to answer this query");
        return -1;
    }

    // main method
    /** Read the data from the file and prints out the number
     *  of entries. Then ask user for a valid formated town/state
     *  name pair, split using the comma and trim the tokens. Compare
     *  the input town and state with each object in the arraylist,
     *  case-nonsensitive and finally prints out all the related
     *  information found or tells the user either their input is of
     *  wrong format, or the input is not found.
     *
     * @param potential user input in the console --not used
     */
    public static void main(String[] args) {
        try {
            readData();
            //prints out the number of entries
            System.out.println("There are " + placeArrayList.size() + " entries in the data base.");
            System.out.println("Please input the town and state that you want me to search for!" +
                    "\nPlease input in the right format separated by a comma, for example Bryn Mawr, PA.");
            //ask for user input in the Console Window
            Scanner userInput = new Scanner(System.in);
            String inputString = userInput.nextLine();
            String[] searchToken = inputString.split(",");
            String searchTown = searchToken[0].trim();
            String searchState = searchToken[1].trim();
            int searchResult = search(searchTown, searchState);
            if (searchResult != -1) {
                System.out.println("Query: " + inputString);
                System.out.println("Found...");
                System.out.println(placeArrayList.get(searchResult).toString());
            } else {
                System.out.println("Sorry, the town and state you input does not exist.");
            }
        } catch(ArrayIndexOutOfBoundsException aie) {
            System.out.println("Please input in the right format -- town, state.");
        }
    } // end of main() method
} // end of class SearchZipCode
