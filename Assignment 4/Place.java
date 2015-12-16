/*****************************************************************************
 * Assignment 4
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 10/08/2015
 * 
 * The Place class for project 4.
 *
 * This program reads the file from "Xinyue_A4_data.txt" using java.util.Scanner,
 * parse the data and stores it into an Arraylist of Place objects. In this main
 * program, it first reads the data and prints out the number of entries. Later,
 * it uses System.in method of the Scanner class to ask user for a valid formatted
 * town and the state it is in, search and compare them inside the arraylist
 * placeArrayList and then prints out all the related information to the
 * Console Window.
 ******************************************************************************/

/******************************************************************************
 * Represents a place, including all the important data of a town in the United
 * States.
 *
 * @author Xinyue(Lexie) Zhang (xzhang@brynmawr.edu)
 *
 ******************************************************************************/

public class Place {
    //data fields
    private String zipCode;
    private String town;
    private String state;
    private String phoneAreaCode;
    private String county;
    private String timeZone;
    private String countyPopulation;

    //constructor
    public Place(String zipCode, String town, String state, String phoneAreaCode, String county, String timeZone,
                 String countyPopulation) {
	this.zipCode = zipCode;
	this.town = town;
	this.state = state;
        this.phoneAreaCode = phoneAreaCode;
        this.county = county;
        this.timeZone = timeZone;
        this.countyPopulation = countyPopulation;
    }
    
    //methods
    /* getters */
    /** get the private data field -- zipCode.
     *
     * @return the U.S. Postal Zipcode
     */ 
    public String getZipCode() {
	return zipCode;
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
	this.zipCode = zipCode;
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
	return "Town: " + town + ", " + state + ", " + zipCode + " (Area Code: " + phoneAreaCode +
	    ", Time Zone: " + timeZone + ")\nCounty: " + county + ", population " + countyPopulation;
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
	if(thisTown.equals(town.toLowerCase()) && thisState.equals(state.toLowerCase())) {
            return true;
	} else {
	    return false;
	}
    }
} // end of Place()
