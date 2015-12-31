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
import java.util.List;
import java.util.ArrayList;

/** 
 * Implements the recursive merge sort algorithm. In this version,
 * copies of the subLists are made, sorted, and then merged.
 *
 * @author: Xinyue Zhang (xzhang@brynmawr.edu)
 */
public class Merge {
    /** Sort the array using the merge sort algorithm.
     * pre: list contains Comparable objects
     * post: list is sorted
     * @param sortMe The list to be sorted
     * @return the sorted list
     */
    public static <T extends Comparable<T>> List<T> sort(List<T> sortMe) {
        if(sortMe == null) {
            return null;
        }
        // A list with one element is sorted already
        if(sortMe.size() > 1) {
            // Split list into halves
            int halfSize = sortMe.size() / 2;
            List<T> left = (List<T>) new ArrayList();
            for(int i = 0; i < halfSize; i++) {
                left.add(sortMe.get(i));
            }
            List<T> right = (List<T>) new ArrayList();
            for(int i = halfSize; i < sortMe.size(); i++) {
                right.add(sortMe.get(i));
            }
            // Sort the halves
            sort(left);
            sort(right);

            // Merge the halves
            merge(sortMe, left, right);
        }
        return sortMe;
    }

    /** Merge two sequences
     * pre: left and right are sorted
     * post: output is the merged result and is sorted
     * @param output The destination
     * @param left The left input
     * @param right The right input
     */
    private static <T extends Comparable<T>> void merge(List<T> output, List<T> left, List<T> right) {
        int i = 0; // index for List left
        int j = 0; // index for List right
        int k = 0; // index for List output
        // While there is data in both input sequences
        while(i < left.size() && j < right.size()) {
            T nextLeft = left.get(i);
            T nextRight = right.get(j);
            if(nextLeft.compareTo(nextRight) < 0) {
                output.set(k++,nextLeft);
                i++;
            } else {
                output.set(k++,nextRight);
                j++;
            }
        }
        // assert: one of the sequences has more items to copy.
        // Copy remaining input from left sequence into the output.
        while(i < left.size()) {
            output.set(k++, left.get(i++));
        }
        // Copy remaining input from right sequence into output.
        while(j < right.size()) {
            output.set(k++, right.get(j++));
        }
    }
}