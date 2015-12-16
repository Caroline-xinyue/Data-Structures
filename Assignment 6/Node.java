/*****************************************************************************
 * Assignment 6
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/01/2015
 *
 * The program that implements the Node class for Project 6 [Part #1].
 *
 * This program reads the file from "Xinyue_A6_data.txt" using java.util.Scanner,
 * parse the data and stores it into a Binary Search Tree of Place objects. In the main
 * program, it first reads the data and prints out the number of entries and the height
 * of the tree. Later, it asks user to input a right formatted town and state, search and
 * compare them inside the Binary Search Tree and then prints out all the related information
 * to the Console Window. The program will keep running until the user types "n" indicating they
 * don't want to search again.
 *****************************************************************************/

/*****************************************************************************
 *  A Node class for the implementation of the Binary Search Tree.
 *
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 *
 *****************************************************************************/
public class Node<E> {
    // Data Fields
    public E data;
    public Node<E> left;
    public Node<E> right;

    /**
     * The constructor of Node<E>
     * @param data The data to be added to the Node.
     */
    public Node(E data) {
        this.data = data;
    }
}
