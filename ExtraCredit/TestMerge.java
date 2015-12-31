/*****************************************************************************
 * Assignment Extra Credit
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/05/2015
 *
 * Problem 3: Implement Mergesort.
 *
 * Create a class called Merge with one public  static method called
 * List<E> sort(List<E> sortMe). You can have as many private static helper
 * methods as you want. The sort() method should be a recursive method that
 * performs Merge Sort. You should write a driver for your merge sort algorithm
 * to test that it works correctly in a variety of circumstances.
 *****************************************************************************/
// import all the libraries
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Test the implementation of the recursive merge sort algorithm. In this implementation,
 * copies of the subLists are made, sorted, and then merged.
 *
 * Test cases:
 * empty list
 * one item
 * String
 * odd number
 * even number
 * other number format such as Float or Double
 *
 * @author: Xinyue Zhang (xzhang@brynmawr.edu)
 */
public class TestMerge {
    // main method to test the implementation of the recursive merge sort algorithm
    public static void main(String[] args) {
        List<Integer> toSort = new ArrayList<Integer>();
        // test for Empty list
        Merge.sort(toSort);
        System.out.println("The result of soring an empty list is " + toSort);
        // test for String List
        List<String> sortString = new ArrayList<String>();
        String[] test = {"z", "d", "a", "t", "l", "y", "e"};
        for(String str : test) {
            sortString.add(str);
        }
        Merge.sort(sortString);
        System.out.println("The result of soring a list of String is " + sortString);

        // test for Integer List
        String response = "y";
        Scanner userInput;
        System.out.println("Input an integer, and this program will sort the list of integers that you input");
        do {
            try {
                System.out.println("Please input an integer");
                userInput = new Scanner(System.in);
                toSort.add(userInput.nextInt());
                Merge.sort(toSort);
                System.out.println("After adding the input integer, now the sorted list becomes " + toSort);
                System.out.println("Do you want to sort again?\nPlease input n for no and y for yes.");
                userInput = new Scanner(System.in);
                response = userInput.next();
            } catch(InputMismatchException nfe) {
                System.out.println("Your input is of a wrong type. Please input an integer!");
            }
        } while(response.equals("y"));
    }
}