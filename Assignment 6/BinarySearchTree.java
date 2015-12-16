/*****************************************************************************
 * Assignment 6
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/01/2015
 *
 * The program that implements the Binary Search Tree for Project 6 [Part #1].
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
 *  A class that implements the Binary Search Tree
 *
 *  @author Xinyue Zhang (xzhang@brynmawr.edu)
 *
 *****************************************************************************/
public class BinarySearchTree<E extends Comparable<E>> implements TreeInterface<E> {
    // implement all methods in TreeInterface.java
    
    // Data Fields
    private Node<E> root;
    private int size;
    private int height;
    private int newHeight;
    private static int count = 0;

    /**
     * get the size of the tree
     * @return the number of items in the tree
     */
    public int size() {
        return size;
    }
    
    /**
     * Empty the tree of all nodes and set size and height to 0
     */
    public void clear() {
        root = null;
        size = 0;
        height = 0;
        newHeight = 0;
    }

    /**
     * Height can be determined by the lowest depth that an
     * add() has put a node,  or the lowest depth that a
     * traversal has visited.
     * @return the height the tree, 0 means null root
     */
    public int height() {
        return height;
    }

    /**
     * The add method
     * @param item the Item to add
     */
    public void add(E item) {
        if(root == null) {
            root = new Node<E>(item);
            size++;
            height = 1;
        } else {
            newHeight++;
            add(item, root);
            size++;
            newHeight = 0;
        }
    }

    /**
     * The add helper method
     * @param item the Item to find
     * @param node The node of the Binary Search Tree
     */
    private void add(E item, Node<E> node) {
        if(item.compareTo(node.data) < 0) {
            if(node.left == null) {
                node.left = new Node<E>(item);
            } else {
                add(item, node.left);
            }
            newHeight++;
        } else if(item.compareTo(node.data) > 0) {
            if(node.right == null) {
                node.right = new Node<E>(item);
            } else {
                add(item, node.right);
            }
            newHeight++;
        } else {
            throw new RuntimeException("Item already existed");
        }
        if(newHeight > height) {
            height = newHeight;
        }
    }
    /**
     * The find method
     * @param item the Item to find
     * @return the data of type E stored within the Binary Search Tree.
     */
    public E find(E item) {
        count = 0;
        if(root == null) {
            return null;
        }
        return find(item, root);
    }
    
    /**
     * The find helper method
     * @param item the Item to find
     * @param node The node of the Binary Search Tree
     * @return the data of type E stored within the Binary Search Tree.
     */
    private E find(E item, Node<E> node) {
        if(node == null) {
            return null;
        }
        int comparison = item.compareTo(node.data);
        count++;
        if(comparison == 0) {
            return node.data;
        } else if(comparison < 0) {
            count++;
            return find(item, node.left);
        } else {
            return find(item, node.right);
        }
    }
    
    /**
     * Get the number of count.
     * @return the number of comparisons to find an item.
     */
    public int getCount() {
        return count;
    }

    /**
     * Print items in Pre-order traversal.
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * PreOrder helper method using recursion.
     * @param node The node of the Binary Search Tree
     */
    private void preOrder(Node<E> node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    /**
     * Print items in in-order traversal.
     */
    public void inOrder() {
        inOrder(root);
    }
    
    /**
     * InOrder helper method using recursion.
     * @param node The node of the Binary Search Tree
     */
    private void inOrder(Node<E> node) {
        if(node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }
    /**
     * Print items in Post-order traversal.
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * PostOrder helper method using recursion.
     * @param node The node of the Binary Search Tree
     */
    private void postOrder(Node<E> node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }


}

