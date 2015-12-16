/*****************************************************************************
 * Assignment 6
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/01/2015
 *
 * The main program for Project 6 [Part #3].
 *
 * This program reads the file from "Xinyue_A6_data.txt" using java.util.Scanner,
 * parse the data and stores it into a Binary Search Tree of Place objects. In the main
 * program, it first reads the data and prints out the number of entries and the height
 * of the tree. Later, it asks user to input a right formatted town and state, search and
 * compare them inside the Binary Search Tree and then prints out all the related information
 * to the Console Window. The program will keep running until the user types "n" indicating they
 * don't want to search again.
 *****************************************************************************/

// import all the libraries
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import javax.swing.JOptionPane;

/*****************************************************************************
 * This program reads the file from "Xinyue_A6_data.txt" using java.util.Scanner,
 * parse the data and stores it into a Binary Search Tree of Place objects. In the main
 * program, it first reads the data and prints out the number of entries and the height
 * of the tree. Later, it asks user to input a right formatted town and state, search and
 * compare them inside the Binary Search Tree and then prints out all the related information
 * to the Console Window. The program will keep running until the user types "n" indicating they
 * don't want to search again.
 *
 * @author Xinyue(Lexie) Zhang (xzhang@brynmawr.edu)
 *****************************************************************************/

public class SearchPlacesBST {
    // Data fields
    public static BinarySearchTree<Place> placeBST = new BinarySearchTree<Place>();
    public static Place newPlace;

    // method readData
    /** Open an input stream to the data file, read each line, split the
     * information and stores the trimed information in an arrayList of
     * Place objects.
     */
    public static void readData() {
        try {
            Scanner data = new Scanner(new File("Xinyue_A6_data.txt"));
            while(data.hasNextLine()) {
                String[] pieces = data.nextLine().split(",");
                for(int i = 0; i < pieces.length; i++) {
                    pieces[i] = pieces[i].trim();
                }
                newPlace = new Place(pieces[0],pieces[1], pieces[2], pieces[3], pieces[5], pieces[6], pieces[9]);
                Place oldPlace = placeBST.find(newPlace);
                if(oldPlace != null) {
                    oldPlace.setZipCode(pieces[0]);
                    newPlace = null;
                } else {
                    placeBST.add(newPlace);
                }
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("The file is not found!");
        }
    }

    // method search
    /** Searching for the given town and state, and count the number of comparison
     * @param town   the town to be searched for within the arraylist
     *        state  the state to be searched for within the arraylist
     * @return returns the Place object with the specified town and state data field.
     */
    public static Place search(String town, String state) {
        Place findPlace = new Place(town, state);
        return placeBST.find(findPlace);
    }

    // the main method
    /** Read the data from the file and prints out the number
     * of entries. Then ask user for a valid formated town/state
     * name pair, split using the comma and trim the tokens. Call
     * the search() method and compare the input town and state with
     * the objects stored in the Binary Search Tree, case-nonsensitive
     * and finally prints out all the related information found or tells
     * the user either their input is of wrong format, or the input is 
     * not found. Continues the program until the user types 'n' denoting
     * that they don't want to search again.
     *
     * @param potential user input in the console --not used
     */
    public static void main(String[] args) {
        String response = "y";
        Scanner userInput;
        readData();
        // prints out the number of entries
        System.out.println("There are " + placeBST.size() + " entries in the data base.");
        System.out.println("The tree height is " + placeBST.height() + ".");
        do {
            try {
                System.out.println("Please input the town and state that you want me to search for!" +
                                   "\nPlease input in the right format separated by a comma, for example Bryn Mawr, PA.");
                // ask for user input in the Console Window
                userInput = new Scanner(System.in);
                String inputString = userInput.nextLine();
                String[] searchToken = inputString.split(",");
                String searchTown = searchToken[0].trim();
                String searchState = searchToken[1].trim();
                Place searchResult = search(searchTown, searchState);
                if (searchResult != null) {
                    System.out.println("Query: " + inputString);
                    System.out.println("Found...");
                    System.out.println(searchResult);
                    System.out.println("Do you want me to search again?\nPlease input n for no and y for yes.");
                    userInput = new Scanner(System.in);
                    response = userInput.nextLine();
                    System.out.println("It takes " + placeBST.getCount() + " comparisons to answer this query");
                } else {
                    System.out.println("Sorry, the town and state you input does not exist.");
                    System.out.println("Do you want me to search again?\nPlease input n for no and y for yes.");
                    userInput = new Scanner(System.in);
                    response = userInput.nextLine();
                    System.out.println("It takes " + placeBST.getCount() + " comparisons to answer this query");
                }
            } catch(ArrayIndexOutOfBoundsException aie) {
                System.out.println("Please input in the right format -- town, state.");
            }
        }while(response.equals("y"));
    }
}