public class Place {
  /*********************************************************
   * Represents a place
   *
   * @author Xinyue Zhang (xzhang@brynmawr.edu)
   *
   ********************************************************/
  // data fields
  private String zipCode;
  private String town;
  private String state;
  private float x, y;

  // constructor
  public Place(String zipCode, String town, String state, float x, 
    float y) {
    this.zipCode = zipCode;
    this.town = town;
    this.state = state;
    this.x = x;
    this.y = y;
  }

  /** Plots the zip code in the sketch window
   * 
   * @param MIN_X minimum values of the mapped x-cordinates
   *              of all the zip codes
   * @param MAX_X maximum values of the mapped x-cordinates
   *              of all the zip codes
   * @param MIN_Y minimum values of the mapped y-cordinates
   *              of all the zip codes
   * @param MAX_Y maximum values of the mapped y-cordinates
   *              of all the zip codes
   */
  public void draw(float MIN_X, float MAX_X, float MIN_Y, 
    float MAX_Y) {
    strokeWeight(1.5);
    // plot all other zip codes in black
    stroke(0);
    // plot all the zip codes in PA in a red color
    if (state.equals("PA")) {
      stroke(255, 0, 0);
    }
    // map the x and y coordinates to the sketch proportions
    cordX = map(x, MIN_X, MAX_X, 10, width - 10);
    cordY = map(y, MIN_Y, MAX_Y, height - 10, 10);
    // draw the point
    point(cordX, cordY);
  }
}