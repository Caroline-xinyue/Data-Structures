/*****************************************************************************
 * Assignment 5
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 11/10/2015
 *
 * The main program for project 5.
 *
 * This program simulates a printer
 *****************************************************************************/
// import all the interfaces
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
/*****************************************************************************
 *  A class that simulates a printer
 *
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 *
 *****************************************************************************/
public class PrinterSimulator {
    // main method
    /** Simulate a printer for 1 minute where the printer prints 20 pages per minute
     * Simulate another printer for 1 minute where the printer prints 5 pages per minute.
     * Prints out the total number of tasks, the cumulative waiting time, the average waiting
     * time per student and the waiting time each task if not 0.
     *
     * @param args potential user input in the console --not used
     */
    public static void main(String[] args) {
        simulate(3600, 10); // printer rate of 10 pages per minute
        //simulate(3600, 5); // printer rate of 5 pages per minute
    }

    // method simulate
    /** Simulate the waiting time for seconds[the parameter] seconds
     * with a printer rate of ppm pages per minute.
     * @param seconds times of simulation in seconds
     * @param ppm pages per minute that the printer can print
     */
    public static void simulate(int seconds, int ppm) {
        // Data Fields
        Printer printer = new Printer(ppm);
        Task taskNow = null;
	// The queue of all the tasks
        Queue<Task> printerQueue = new LinkedList<Task>();
	// The arraylist to store the waittime for each task
        ArrayList<Integer> waitingTime = new ArrayList<Integer>();

        int numTask = 0;
        int waitTimeTotal = 0;
        int waitTimeAverage = 0;

        // Simulate methods
        for(int tick = 0; tick < seconds; tick++) {
	    // Add each randomly generated tasks to the queue
            if(newPrintTask()) {
                Task newTask = new Task(tick);
                printerQueue.offer(newTask);
                numTask++;
            }
            if(!printer.busy() && !printerQueue.isEmpty()) {
		// Store the waittime for each task in an Arraylist
                if(taskNow != null) {
                    waitingTime.add(taskNow.waitTime(tick));
                }
                taskNow = printerQueue.poll();
                printer.startNext(taskNow);
            }
	    // Tick through each task
            printer.tick();
        }
	// Calculate the cumulative waiting time for all the tasks
        for(int i = 0; i < waitingTime.size(); i++) {
            waitTimeTotal += waitingTime.get(i);
        }
	// Calculate the average waiting time per person
        waitTimeAverage = waitTimeTotal/10;

	// Print the results to the console
        System.out.println("There are " + numTask + " tasks in this simulation.");
        System.out.println("Cumulative waiting time is " + waitTimeTotal + " seconds.");
        System.out.println("Average waiting time per student is " + waitTimeAverage + " seconds.");
        for(int i = 0; i < waitingTime.size(); i++) {
            System.out.println("The waiting time for the " + (i + 1) + "th task is " + waitingTime.get(i) + " seconds.");
        }
    }

    // method newPrintTask
    /** randomly generate print tasks with the possibility of 1/180,
     * i.e. the expected value of the print tasks rate is 20 tasks per hour.
     * @return true if new print tasks are generated; false otherwise
     */
    public static boolean newPrintTask() {
        Random rand = new Random();
        return (180 == (1 + rand.nextInt(180))); // in seconds
    }
}
