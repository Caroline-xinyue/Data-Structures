/*****************************************************************************
 * Assignment 6
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/01/2015
 *
 * The program that implements the Place class for Project 6 [Part #3].
 *
 * This program reads the file from "Xinyue_A6_data.txt" using java.util.Scanner,
 * parse the data and stores it into a Binary Search Tree of Place objects. In the main
 * program, it first reads the data and prints out the number of entries and the height
 * of the tree. Later, it asks user to input a right formatted town and state, search and
 * compare them inside the Binary Search Tree and then prints out all the related information
 * to the Console Window. The program will keep running until the user types "n" indicating they
 * don't want to search again.
 *****************************************************************************/

// imports all the libraries
import java.util.ArrayList;
/******************************************************************************
 * Represents a place, including all the important data of a town in the United
 * States.
 *
 * @author Xinyue(Lexie) Zhang (xzhang@brynmawr.edu)
 *
 ******************************************************************************/

public class Place implements Comparable<Place> {
    //data fields
    private ArrayList<String> zipCode = new ArrayList<String>();
    private String town;
    private String state;
    private String phoneAreaCode;
    private String county;
    private String timeZone;
    private String countyPopulation;
    private String location;

    //constructor
    public Place(String zipCode, String town, String state, String phoneAreaCode, String county, String timeZone,
                 String countyPopulation) {
        this.zipCode.add(zipCode);
        this.town = town;
        this.state = state;
        this.phoneAreaCode = phoneAreaCode;
        this.county = county;
        this.timeZone = timeZone;
        this.countyPopulation = countyPopulation;
        this.location = town + ", " + state;
    }

    public Place(String town, String state) {
        this.zipCode = null;
        this.town = town;
        this.state = state;
        this.phoneAreaCode = null;
        this.county = null;
        this.timeZone = null;
        this.countyPopulation = null;
        this.location = town + ", " + state;
    }

    //methods
    /* getters */
    /** get the private data field -- zipCode.
     *
     * @return the U.S. Postal Zipcode
     */
    public String getZipCode() {
        String returnZip = "";
        for(int i = 0; i < zipCode.size(); i++) {
            returnZip += zipCode.get(i);
            if(i != zipCode.size() - 1) {
                returnZip += ", ";
            }
        }
//        for(String zip : zipCode) {
//            returnZip = returnZip + zip + " ";
//        }
        return returnZip;
    }
    /** get the private data field -- town.
     *
     * @return the town that the place is located
     */
    public String getTown() {
        return town;
    }
    /** get the private data field -- state.
     *
     * @return the state that the place is located
     */
    public String getState() {
        return state;
    }
    /** get the private data field -- phoneAreaCode.
     *
     * @return the phone area code
     */
    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }
    /** get the private data field -- county.
     *
     * @return the county that the place is located
     */
    public String getCounty() {
        return county;
    }
    /** get the private data field -- timeZone.
     *
     * @return the time zone the place is in
     */
    public String getTimeZone() {
        return timeZone;
    }
    /** get the private data field -- countyPopulation.
     *
     * @return the total population of the county
     */
    public String getCountyPopulation() {
        return countyPopulation;
    }
    /* setters */
    /** set the private data field -- zipCode.
     *
     * @param zipCode   the new U.S. Postal Zipcode
     */
    public void setZipCode(String zipCode) {
        this.zipCode.add(zipCode);
    }
    /** set the private data field -- town.
     *
     * @param town  the new town of the place
     */
    public void setTown(String town) {
        this.town = town;
    }
    /** set the private data field -- state.
     *
     * @param state  the new state of the place
     */
    public void setState(String state) {
        this.state = state;
    }
    /** set the private data field -- phoneAreaCode.
     *
     * @param phoneAreaCode  the new phone area code of the place
     */
    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }
    /** get the private data field -- county.
     *
     * @param county the new county of the place
     */
    public void setCounty(String county) {
        this.county = county;
    }
    /** set the private data field -- timeZone.
     *
     * @param timeZone  the new timeZone of the place
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    /** set the private data field -- countyPopulation.
     *
     * @param countyPopulation  the new county population of the place
     */
    public void setCountyPopulation(String countyPopulation) {
        this.countyPopulation = countyPopulation;
    }

    /** override the toString() method.
     *
     * @return a string that shows the information about a given place
     */
    @Override
    public String toString() {
        return "Town: " + town + ", " + state + " owns zipCodes: " + getZipCode() + "; has Area Code: " + phoneAreaCode +
                "; and is in Time Zone: " + timeZone + "\nIt's in County: " + county + ", and has population: " + countyPopulation;
    }

    /** compare a given town and state to a place object.
     *
     * @param town  the town to compare with
     *        state the state of the town to compare with
     * @return a boolean value. Returns true if the input town
     * and state matches the town and state data field of the
     * object, all in lower case; return false otherwise.
     */
    public boolean equals(String town, String state) {
        String thisTown = this.town.toLowerCase();
        String thisState = this.state.toLowerCase();
        return thisTown.equals(town.toLowerCase()) && thisState.equals(state.toLowerCase());
    }

    // CompareTo method
    /** compare the place to another place object given.
     *
     * @param place  the place to compare with
     * @return an integer. Returns a positive integer if the input town
     * and state matches the town and state data field of the
     * object, all in lower case; return false otherwise.
     */
    @Override
    public int compareTo(Place place) {
        String thisPlace = location;
        String comparePlace = place.location;
        if(thisPlace.equals(comparePlace)) {
            return 0;
        } else {
            return thisPlace.compareToIgnoreCase(comparePlace);
        }
    }
} // end of Place()