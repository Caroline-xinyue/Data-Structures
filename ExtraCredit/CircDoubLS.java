/*****************************************************************************
 * Assignment Extra Credit
 * Name:      Xinyue(Lexie) Zhang
 * E-mail:    xzhang@brynmawr.edu
 * Course:    CS 206
 * Submitted: 12/05/2015
 *
 * Problem 1: Implement a circular double linked list from scratch.
 *
 * Your class should implement the SimplifiedList2 interface, and it should use your
 * own Node class that is doubly linked. It is up to you to decide what fields to have
 * in your CircularLinkedList class. In addition to the methods defined in SimplifiedList2,
 * create a splice method, that takes a list and allows you to splice an arbitrary sized
 * sublist into the current list at any point in the list. 
 * Once you have implemented the class, write a driver class that creates 2 
 * CircularLinkedList<Number>, One of <Float> and one of <Integer>. Each list
 * should be populated with 10 random numbers, and then one should be spliced
 * into the other at a random position. Your driver should first create each 
 * list, then print each list, then splice one list into the other, then print
 * each list again.
 *****************************************************************************/
// import all the libraries
import java.util.Random;
import java.lang.Number;

/**
 * Implements the circular double linked list
 *
 * @author: Xinyue Zhang (xzhang@brynmawr.edu)
 */
public class CircDoubLS<E> implements SimplifiedList2<E> {
    // Data files
    Node<E> head;
    Node<E> tail;
    int size;


    // Constructor
    public CircDoubLS() {
        this.head = null;
        this.tail = this.head;
        this.size = 0;
    }

    // Constructor
    public CircDoubLS(E headItem) {
        this.head = new Node<E>(headItem);
        this.tail = this.head;
        head.setNext(head);
        head.setPrevious(head);
        this.size = 0;
    }

    // getNode method
    /**
     * the getNode method
     * @param index The index of the Node
     * @return the Node at index index
     */
    public Node<E> getNode(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        Node<E> temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    @Override
    // add method
    /**
     * Add at the end
     * @param item The item to add
     * @return true if the item is added; otherwise, false
     */
    public boolean add(E item) {
        if(this.head == null) {
            this.head = new Node<E>(item);
            this.tail = head;
            head.setNext(head);
            head.setPrevious(head);
            size++;
            return true;
        }
        Node<E> prevNode = getNode(size - 1);
        Node<E> nextNode = getNode(0);
        tail = new Node<E>(item, prevNode, nextNode);
        prevNode.setNext(tail);
        nextNode.setPrevious(tail);
        size++;
        return true;
    }

    @Override
    // add at index method
    /**
     * Add at the index
     * @param index The index of the item
     * @param item The item to add
     * @return true if the item is added; otherwise, false
     */
    public boolean add(int index, E item) {
        if(index < 0 || index > size) {
            return false;
        }
        if(index == size) {
            add(item);
        }
        Node<E> prevNode;
        if(index == 0) {
            prevNode = tail;
        } else {
            prevNode = getNode(index - 1);
        }
        Node<E> nextNode = prevNode.getNext();
        Node<E> thisNode = new Node<E>(item, prevNode, nextNode);
        prevNode.setNext(thisNode);
        nextNode.setPrevious(thisNode);
        if(index == 0) {
            head = thisNode;
        }
        size++;
        return true;
    }

    @Override
    // remove method
    /**
     * Remove at the index
     * @param index The index of the item
     * @return the item being removed
     */
    public E remove(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        Node<E> removeNode = getNode(index);
        E removeVal = removeNode.getValue();
        Node<E> prevNode = removeNode.getPrevious();
        Node<E> nextNode = removeNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);
        removeNode.setPrevious(null);
        removeNode.setNext(null);
        if(index == 0) {
            head = nextNode;
        } else if(index == size - 1) {
            tail = prevNode;
        }
        size--;
        return removeVal;
    }

    @Override
    // set method
    /**
     * Set the item at the index
     * @param index The index of the item
     * @param item The item to set
     * @return the original item
     */
    public E set(int index, E item) {
        if(index < 0 || index >= size) {
            return null;
        }
        Node<E> setNode = getNode(index);
        E oldValue = setNode.getValue();
        setNode.setValue(item);
        return oldValue;
    }

    @Override
    // get method
    /**
     * Get the item at the index
     * @param index The index of the item
     * @return the item at the index
     */
    public E get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return getNode(index).getValue();
    }

    @Override
    // contains method
    /**
     * Check containment
     * @param item The item to check containment
     * @return true if the item is contained in the CirDoubLS; otherwise, false
     */
    public boolean contains(E item) {
        if(head == null) {
            return false;
        }
        Node<E> temp = head;
        while(!temp.getNext().equals(head)) {
            if(temp.getValue().equals(item)) {
                return true;
            }
            temp = temp.getNext();
        }
        return temp.getValue().equals(item);
    }

    @Override
    // isEmpty method
    /**
     * Check whether the list is empty
     * @param item The item to check containment
     * @return true if the item is contained in the CirDoubLS; otherwise, false
     */
    public boolean isEmpty() {
        return head == null && tail == null && size == 0;
    }

    @Override
    // clear method
    /**
     * To clear the list and reset the size of the list
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    // get size method
    /**
     * Get the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    @Override
    // check isFull method
    /**
     * Check whether the list is full
     * @return true if the list is full; otherwise, false
     */
    public boolean isFull() {
        return false;
    }

    // splice method
    /**
     * Splice one list into another. Both list are modified in this implementation.
     * @param list The list to splice from
     * @param start The start index of the list which we splice from
     * @param end The end index of the list which we splice from
     * @param s The start index of the list to splice into
     * @return true if the splice is successful; otherwise, false
     */
    public boolean splice(CircDoubLS<E> list, int start, int end, int s) {
        if(list == null || start >= end || start < 0 || end > size || s < 0 || s > list.size) {
            return false;
        }
        int n = end - start;
        Node<E> startNode = list.getNode(start);
        Node<E> endNode = list.getNode(end - 1);
        Node<E> listEnd = list.getNode(end);
        Node<E> thisEnd = getNode(s);
        Node<E> thisStart = getNode(s - 1);
        // splice the parameter list into this list
        if(thisStart == null) {
            head = startNode;
            endNode.setNext(thisEnd);
            thisEnd.setPrevious(endNode);
            head.setPrevious(tail);
            tail.setNext(head);
        } else if (thisEnd == null) {
            thisStart.setNext(startNode);
            startNode.setPrevious(thisStart);
            endNode.setNext(head);
            head.setPrevious(endNode);
            tail = endNode;
        } else {
            thisStart.setNext(startNode);
            startNode.setPrevious(thisStart);
            endNode.setNext(thisEnd);
            thisEnd.setPrevious(endNode);
        }
        // reconstruct the parameter list where we splice from
        if(start == 0 || end == list.size) {
            if (start == 0) {
                list.head = listEnd;
            }
            if (end == list.size) {
                list.tail = list.getNode(start - 1);
            }
            if(start != 0 || end != list.size) {
                list.tail.setNext(list.head);
                list.head.setPrevious(list.tail);
            }
        } else {
            list.getNode(start - 1).setNext(listEnd);
            listEnd.setPrevious(list.getNode(start - 1));
        }
        list.size -= n;
        size += n;
        return true;
    }

    @Override
    // toString method
    /**
     * Print out the CircDoubLS
     * @return the string representation of this Circular Doubly Linked List
     */
    public String toString() {
        String result = "";
        Node<E> temp = head;
        if(temp == null) {
            return "empty";
        }
        if(temp.getNext().equals(head)) {
            return head.getValue() + "<->" + temp.getValue();
        }
        while(!temp.getNext().equals(head)) {
            result =  result + temp.getValue() + "<->";
            temp = temp.getNext();
        }
        result = result + tail.getValue() + "<->" + head.getValue();
        return result;
    }
    
    /**
     * Main method to partially test the CircDoubLS implementation.
     * Full detailed testing is provided in the class named TestCircDoubLS.java.
     */
    public static void main(String[] args) {
        CircDoubLS<Number> listInt = new CircDoubLS<Number>();
        Node<Number> nodePrev1, nodePrev2, nodePrev3;
        Node<Number> nodeNext1, nodeNext2, nodeNext3;
        int[] integers = {15, 8, 9, 1, 3, 0, 2, 11, 5};
        for(Integer integer : integers) {
            listInt.add(integer);
        }
        listInt.add(3, 4);
        nodePrev1 = listInt.getNode(3).getPrevious();
        nodeNext1 = listInt.getNode(3).getNext();
        Number prev1 = nodePrev1.getValue();
        Number next1 = nodeNext1.getValue();
        System.out.println(prev1);
        System.out.println(next1);
        nodePrev2 = listInt.getNode(4).getPrevious();
        nodeNext2 = listInt.getNode(2).getNext();
        Number prev2 = nodePrev2.getValue();
        Number next2 = nodeNext2.getValue();
        System.out.println(prev2);
        System.out.println(next2);
        System.out.println("\n/****** After removing ******/");
        listInt.remove(3);
        nodePrev3 = listInt.getNode(3).getPrevious();
        nodeNext3 = listInt.getNode(2).getNext();
        Number prev3 = nodePrev3.getValue();
        Number next3 = nodeNext3.getValue();
        //Number num = listInt.get(3);
        System.out.println(prev3);
        System.out.println(next3);
    }
}