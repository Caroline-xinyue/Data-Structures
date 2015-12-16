/***********************************************************
 * Assignment 1
 * Name: Xinyue Zhang
 * E-mail: xzhang@brynmawr.edu
 * Course: CS 206
 * Submitted:  8/9/2015
 *
 * Processing review: Read in the data about all the postal 
 * zip codes in the 48 contiguous states of the US and plot
 * the geo-location of each zip code on the 2-dimensional
 * processing console. For those zip codes in the state of
 * Philadelphia, the plotted points are red.
 **********************************************************/
float MIN_X, MAX_X, MIN_Y, MAX_Y;
float cordX, cordY;
int NUM_ZIPCODES;
void setup() {
  // basic setup
  size(displayWidth, displayHeight);
  smooth();
  background(255);

  // draw legend
  // title
  fill(0);
  textSize(25);
  textAlign(CENTER);
  text("Plotting US Postal Zip Code Locations", 
    displayWidth/2, 50);
  textSize(20);
  text("by Lexie", displayWidth - 400, 80);

  // input the data from the provided data file
  String[] data = loadStrings("Xinyue_A1.txt");
  // declare and initialize the array of Place objects
  Place[] place = new Place[data.length];
  // split the data
  // split data on the first line
  if (data[0].charAt(0) == '#') {
    String[] info = split(data[0], "# ");
    String[] info2 = split(info[1], ",");
    NUM_ZIPCODES = int(info2[0]);
    MIN_X = float(info2[1]);
    MAX_X = float(info2[2]);
    MIN_Y = float(info2[3]);
    MAX_Y = float(info2[4]);
    textAlign(LEFT);
    textSize(18);
    fill(255, 94, 62);
    text("Total number of zip codes: " + NUM_ZIPCODES, 
      20, displayHeight - 180);
    text("Minimum x-coordinates: " + MIN_X, 
      20, displayHeight - 150);
    text("Maximum x-coordinates: " + MAX_X, 
      20, displayHeight - 120);
    text("Minimum y-coordinates: " + MIN_Y, 
      20, displayHeight - 90);
    text("Maximum y-coordinates: " + MAX_Y, 
      20, displayHeight - 60);
    println("Total number of zip codes: " + NUM_ZIPCODES);
    println("Minimum x-coordinates: " + MIN_X);
    println("Maximum x-coordinates: " + MAX_X);
    println("Minimum y-coordinates: " + MIN_Y);
    println("Maximum y-coordinates: " + MAX_Y);
  }
  for (int i = 1; i <= NUM_ZIPCODES; i++) {
    // split the data and save as Place objects
    String[] pieces = split(data[i], "\t");
    String[] pieces2 = split(pieces[3], ", ");
    place[i] = new Place(pieces[0], pieces2[0], 
      pieces2[1], float(pieces[1]), 
      float(pieces[2]));
  }
  println("Data Loaded:");

  // call the method show and draw the data
  for (int i = 1; i <= NUM_ZIPCODES; i++) {
    place[i].draw(MIN_X, MAX_X, MIN_Y, MAX_Y);
  }
} // setup()