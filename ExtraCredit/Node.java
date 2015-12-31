
/**
 * The node class for a linked list
 */
public class Node<E> {

    /**
     * The data of type E
     */
    private E value;

    /**
     * a link to the previous Node with data of type E
     */
    private Node<E> previous;

    /**
     * a link to the next Node with data of type E
     */
    private Node<E> next;


    /** a constructor to construct a 'head' node
     * (with previous and next null)
     * @param item - the data of type E to store
     */
    public Node(E item) {
        value = item;
        previous = null;
        next = null;
    }

    /**
     * a constructor to construct a 'tail' node
     * (with next null)
     * @param item - the data of type E to store
     * @param prevNode = the reference to previous.
     */
    public Node(E item, Node<E> prevNode) {
        value = item;
        previous = prevNode;
        next = null;
    }

    /**
     * a constructor to construct a node
     * with next and previous specified
     * @param item - the value of type E to store
     * @param prevNode = the reference to previous.
     * @param nextNode = the reference to next.
     */
    public Node(E item, Node<E> prevNode, Node<E> nextNode) {
        value = item;
        previous = prevNode;
        next = nextNode;
    }

    /**
     * an accessor to value
     * @return value - the value of type E at the node
     */
    public E getValue() {
        return value;
    }

    /**
     * mutator to value
     * @param item - the new value of type E at the node
     */
    public void setValue(E item) {
        value = item;
    }

    /**
     * an accessor to previous
     * @return the previous node
     */
    public Node<E> getPrevious() {
        return previous;
    }

    /**
     * an accessor to next
     * @return the next node
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * mutator to previous
     * @param node - the new value for previous
     */
    public void setPrevious(Node<E> node) {
        previous = node;
    }

    /**
     * mutator to next
     * @param node - the new value for next
     */
    public void setNext(Node<E> node) {
        next = node;
    }

    /**
     * @return the value's string.
     */
    public String toString() {
        return value.toString();
    }

    public String toStringList() {
        if(next == null) {
            return value.toString();
        }
        return value.toString() + "->" + next.toStringList();
    }
}
