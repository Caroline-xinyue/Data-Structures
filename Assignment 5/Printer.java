/*****************************************************************************
 *  A class that represents a printer
 *
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 *
 *****************************************************************************/
public class Printer {
    // Data Fields
    private int pageRate;		// pages per minute (ppm)
    private Task currentTask;	// current task on printer
    private int timeRemaining;	// time remaining on current task

    // Constructor
    /**
     * Set pageRate to the parameter ppm, and initialize currentTask and timeRemaining
     * @param ppm the pageRate of the printer
     */
    public Printer(int ppm) {
        pageRate = ppm;
        currentTask = null;
        timeRemaining = 0;
    }

    // method tick
    /** Tick through the task by decrementing the data field timeRemaining
     */
    public void tick() {
        if (currentTask != null) {
            timeRemaining--;
            if (timeRemaining == 0) {
                currentTask = null;
            }
        }
    }
    // method busy
    /** Check if the printer is busy.
     * @return true if the printer is busy, i.e. the currentTask
     * is not null; false otherwise
     */
    public boolean busy() {
        return currentTask != null;
    }

    // method startNext
    /** Start a new task from the printer
     * Takes in newTask as the parameter and set currentTask to newTask,
     * then, set the timeRemaining based on the pages of newTask, the pageRate
     * of the printer and change the unit into seconds.
     */
    public void startNext(Task newTask) {
        currentTask = newTask;
        timeRemaining = newTask.getPages() * 60 / pageRate; // in seconds
    }

}
