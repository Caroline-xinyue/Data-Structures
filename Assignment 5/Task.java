/*****************************************************************************
 *  A class that represents a task.
 *
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 *
 *****************************************************************************/
public class Task {
    private int timeStamp; // When a print request arrives (in ticks since 0)
    private int pages; // # pages of the print job [1..20]

    // Constructor
    /**
     * Set timeStamp to the parameter t, and set pages to a randomly generated number
     * between 1 to 20.
     * @param t the time a given is created
     */
    public Task(int t) {
        timeStamp = t;
        pages = (int) (1 + 20 * Math.random()); // randomly generated the number of pages for each task between 1 to 20 pages
    }

    // method getTimeStamp
    /** get the request time of each task created
     * @return the request time of each task
     */
    public int getTimeStamp() {
        return timeStamp;
    }

    // method getPages
    /** get the pages of each task created
     * @return the pages of each task
     */
    public int getPages() {
        return pages;
    }

    // method waitTime
    /** calculate the waiting time of each task created
     * @return the time a given task waits
     */
    public int waitTime(int currentTime) {
        return currentTime - timeStamp;
    }

    // method toString
    /** Prints out the information about the task created
     * @return a string about the information about the task including the time
     * it arrives and its pages.
     */
    public String toString() {
        return "Task@"+timeStamp+", "+pages+" pages.";
    }
}
