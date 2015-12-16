/*****************************************************************************
 * Assignment 6
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/01/2015
 *
 * The main program that uses the Binary Search Tree implemention in Part #1 
 * for Project 6 [Part #2].
 *
 * This program reads the file from "Xinyue_A6_data.txt" using java.util.Scanner,
 * parse the data and stores it into a Binary Search Tree of Place objects. In the main
 * program, it first reads the data and prints out the number of entries and the height
 * of the tree. Later, it asks user to input a right formatted town and state, search and
 * compare them inside the Binary Search Tree and then prints out all the related information
 * to the Console Window. The program will keep running until the user types "n" indicating they
 * don't want to search again.
 *****************************************************************************/

/******************************************************************************
 * A program that uses the BST from part #1 to:
 
 * A. Use the add() method to add the following strings to the BST:
 * Cambridge
 * Crapo
 * Your birth place
 * Bryn Mawr
 * Boring
 * Hell
 * Walla Walla
 * Surprise
 * Joseph
 * Romance
 * Mars
 * Nuttsville
 * Rough and Ready
 * Dynamite
 * Good Grief
 * After adding the above, do a preorder, postorder, and inorder traversal 
 * (printing out each node as you visit). Also print out the number of entries 
 * in the tree, and its height. You will need use the three methods: preOrder(), 
 * postOrder(), and inOrder() that you implemented in the binary search tree class
 * from Part #1.
 
 * B. Clear the tree, and print out the number of items and its height. Then add 
 * the above towns in ascending order.
 * Print out the resulting tree's size, and height, and also the results of all three tree traversals.
 *
 * @author Xinyue(Lexie) Zhang (xzhang@brynmawr.edu)
 *
 ******************************************************************************/
public class PlaceBST {
    // Data Fileds
    static BinarySearchTree<String> place = new BinarySearchTree<String>();
    static int size = 0;
    static int height = 0;
    static String[] places = {"Cambridge","Crapo", "Xi'an", "Bryn Mawr", "Boring", "Hell", "Walla Walla", "Surprise",
                              "Joseph", "Romance", "Mars", "Nuttsville", "Rough and Ready", "Dynamite", "Good Grief"};
    static String[] placesOrdered = {"Boring","Bryn Mawr","Cambridge","Crapo","Dynamite","Good Grief","Hell","Joseph","Mars","Nuttsville","Romance",
                                     "Rough and Ready","Surprise","Walla Walla","Xi'an"};
    
    // the main method
    /**
     * The main method
     * @param potential user input in the console --not used
     */
    public static void main(String[] args) {
        System.out.println("/******  Adding places...  ******/");
        /**
                    Cambridge
             Bryn Mawr      Crapo
        Boring                                      Xi'an
                               Hell
                    Dynamite              Walla Walla
           Good Grief                 Surprise
                                Joseph
                                        Romance
                                   Mars         Rough and Ready
                                    Nuttsville
         **/
        for(String p : places) {
            place.add(p);
        }

        System.out.println("Doing a preOrder traversal:");
        place.preOrder();
        System.out.println();
        System.out.println("Doing a postOrder traversal:");
        place.postOrder();
        System.out.println();
        System.out.println("Doing an inOrder traversal:");
        place.inOrder();
        System.out.println();

        size = place.size();
        height = place.height();
        System.out.print("The current size of the tree is: ");
        System.out.println(size);
        System.out.print("The current height of the tree is: ");
        System.out.println(height);

        System.out.println();
        System.out.println("/******  Clearing the tree...  ******/");
        place.clear();
        System.out.println();

        size = place.size();
        height = place.height();
        System.out.print("After clearing the tree, the current size of the tree is: ");
        System.out.println(size);
        System.out.print("After clearing the tree, the current height of the tree is: ");
        System.out.println(height);

        System.out.println();
        System.out.println("/******  Adding places in ascending order...  ******/");
        for(String q : placesOrdered) {
            place.add(q);
        }

        size = place.size();
        height = place.height();
        System.out.print("After adding in ascending order, the new size of the tree is: ");
        System.out.println(size);
        System.out.print("After adding in ascending order, the new height of the tree is: ");
        System.out.println(height);

        System.out.println("Doing a preOrder traversal:");
        place.preOrder();
        System.out.println();
        System.out.println("Doing a postOrder traversal:");
        place.postOrder();
        System.out.println();
        System.out.println("Doing an inOrder traversal:");
        place.inOrder();
    }
}