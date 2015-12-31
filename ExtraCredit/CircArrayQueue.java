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
import java.util.*;
/** 
 * Implements the Queue interface using a circular array.
 * 
 * @author Xinyue Zhang(xzhang@brynmawr.edu)
 */
public class CircArrayQueue<E> {
    //Data Fields
    /** Index of the front of the queue. */
    private int front;
    /** Index of the rear of the queue. */
    private int rear;
    /** Current size of the queue. */
    private int size;
    /** Current capacity of the queue. */
    private int capacity;
    /** Default capacity of the queue. */
    private static final int DEFAULT_CAPACITY = 10;
    /** Array to store the data. */
    private E[] theData;

    // Constructors
    /** Construct a queue with the default capacity.*/
    public CircArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    @SuppressWarnings("Unchecked")
    /**
     * Construct a queue with the specified initial capacity.
     * @param initCapacity the initial capacity
     */
    public CircArrayQueue(int initCapacity) {
        front = 0;
        rear = capacity - 1;
        size = 0;
        capacity = initCapacity;
        theData = (E[])new Object[capacity];
    }

    // Public Methods
    /** Inserts an item at the rear of the queue.
     * post: item is added to the rear of the queue.
     * @param item The element to add
     * @return true (always successful)
     */
    public boolean offer(E item) {
        if(size == capacity) {
            grow();
        }
        rear = (rear + 1) % capacity;
        size++;
        theData[rear] = item;
        return true;
    }

    /**
     * Removes the entry at the front of the queue and returns it if the queue is not empty.
     * post: front references item that was second in the queue.
     * @return The item removed if successful or null if not
     */
    public E poll() {
        if(size == 0) {
            return null;
        }
        E item = theData[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Private method
    /**
     * Double the capacity and reallocate the data
     * pre: The array is filled to capacity
     * post: The capacity is doubled and the first half of the expanded array is filled with data
     */
    @SuppressWarnings("Unchecked")
    private void grow() {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];
        int j = front;
        for(int i = 0; i < size; i++) {
            newData[i] = theData[j];
            j = (j+1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        theData = newData;
    }
    
    /**
     * Returns the item at the front of the queue without removing it.
     * @return The item at the front of the queue if successful;
     *         return null if the queue is empty.
     */
    public E peek() {
        if(size == 0) {
            return null;
        }
        E item = theData[front];
        return item;
    }
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = front; i < capacity; i++) {
            result += theData[i] + " ";
        }
        if(front > rear) {
            for(int i = 0; i <= rear; i++) {
                result += theData[i] + " ";
            }
        }
        return result;
    }

    public String display() {
        String result = "";
        if(front > rear) {
            for(int i = 0; i <= rear; i++) {
                result += theData[i] + " ";
            }
        }
        for(int i = front; i < capacity; i++) {
            result += theData[i] + " ";
        }
        return result;
    }

    public Iterator<E> iterator() {
        return new Iter();
    }

    // Private class
    /** Inner class to implement the Iterator<E> interface. */
    private class Iter implements Iterator<E> {
        // Data Fields
        // index of next element
        private int index;
        // Count of elements accessed so far */
        private int count = 0;

        // Methods
        // Constructor
        /** Initializes the Iter object to reference the first queue element.
         *
         */
        public Iter() {
            index = front;
        }

        /** Returns true if there are more elements in the queue to access. */
        @Override
        public boolean hasNext() {
            return count < size;
        }

        /** Returns the next element in the queue.
         * pre: index references the next element to access.
         * post: index and count are incremented
         * @return The element with subscript index
         */
        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = theData[index];
            index = (index + 1) % capacity;
            front = index;
            count++;
            return returnValue;
        }

        /** Remove the item accessed by the Iter object - not implemented.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
