/*****************************************************************************
 * Assignment 6
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/01/2015
 *
 * The program that tests the implementation of the Binary Search Tree for Project 6[Part #1].
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
 * The class that tests the implementation fo the Binary Search Tree
 *
 * @author Xinyue(Lexie) Zhang (xzhang@brynmawr.edu)
 *****************************************************************************/

public class TestBST {
    // The main method
    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree();
        BST.add(6);
        BST.add(2);
        BST.add(3);
        BST.add(1);
        BST.add(8);
        BST.add(7);
        BST.add(10);
        BST.add(11);
        BST.find(5);
        int size = BST.size();
        int height = BST.height();
        System.out.println("Size is " + size);
        System.out.println("Height is " + height);
        BST.preOrder();
        BST.postOrder();
        for(int i = 0; i < 10; i+=2) {
            System.out.println(BST.find(i));
        }
    }
}