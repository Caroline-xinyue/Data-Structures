/*****************************************************************************
 * Assignment Extra Credit
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/05/2015
 *
 * Problem 2: Implement a Queue with a circular array instead of a linked list.
 *
 * You will need to write a grow method for when the size goes beyond your initial
 * capacity. Write testing code to verify that your queue works correctly and resizes
 * correctly.
 *****************************************************************************/
// import all the libraries
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Test the implementation of the Circular Array Queue.
 *
 * @author Xinyue Zhang(xzhang@brynmawr.edu)
 */
public class TestCircArrayQueue {
    // main method to test the implementation of the Circular Array Queue.
    public static void main(String[] args) {
        CircArrayQueue<Integer> testQueue = new CircArrayQueue<Integer>(10);
        System.out.println("Circular Array Queue Test\n");
        String response = "y";
        Scanner scan = new Scanner(System.in);
        /*  Perform list operations  */
        do {
            System.out.println("\nCircular Array Queue Operations\n");
            System.out.println("1. offer an item");
            System.out.println("2. pool the first item");
            System.out.println("3. peek the first item");
            System.out.println("4. get size");
            
            int choice = scan.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter integer element to insert");
                        testQueue.offer(scan.nextInt());
                        break;
                    case 2:
                        System.out.println("Pool the first item");
                        System.out.println(testQueue.poll());
                        break;
                    case 3:
                        System.out.println("Peek the first item");
                        System.out.println(testQueue.peek());
                        break;
                    case 4:
                        System.out.println("Size = " + testQueue.size() + " \n");
                        break;
                    default:
                        System.out.println("Wrong Entry \n ");
                        break;
                }
                System.out.println("Display the Queue: ");
                System.out.println(testQueue.toString());
                System.out.println("Visualize the Circular Array Queue implementation: ");
                System.out.println(testQueue.display());
                System.out.println("\nDo you want to continue (Type y or n) \n");
                response = scan.next();
            } catch (InputMismatchException ime) {
                System.out.println("Your input is of a wrong type. Please input an integer!");
            }
        } while (response.equals("y"));
    }
    }