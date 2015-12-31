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
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * Test the implementation of the circular double linked list
 *
 * @author: Xinyue Zhang (xzhang@brynmawr.edu)
 */
public class TestCircDoubLS {
    // The main method to test the implementation of the circular double linked list.
    public static void main(String[] args) {
        boolean print = true;
        Scanner scan = new Scanner(System.in);
        /* Creating object of Circular Doubly Linked List */
        CircDoubLS list = new CircDoubLS();
        CircDoubLS<Number> listInt = new CircDoubLS<Number>();
        CircDoubLS<Number> listFloat = new CircDoubLS<Number>();
        System.out.println("Circular Doubly Linked List Test\n");
        String response = "y";
        /*  Perform list operations  */
        do {
            System.out.println("\nCircular Doubly Linked List Operations\n");
            System.out.println("1. add item at end");
            System.out.println("2. add item at position");
            System.out.println("3. remove item at position");
            System.out.println("4. set item at position");
            System.out.println("5. check containment");
            System.out.println("6. check empty");
            System.out.println("7. get size");
            System.out.println("8. clear the list");
            System.out.println("9. splice the the listFloat list into the listInt list");

            int choice = scan.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter integer element to insert");
                        list.add(scan.nextInt());
                        break;
                    case 2:
                        System.out.println("Enter integer element to insert");
                        int num1 = scan.nextInt();
                        System.out.println("Enter position");
                        int pos1 = scan.nextInt();
                        if (pos1 < 0 || pos1 > list.size())
                            System.out.println("Invalid position\n");
                        else
                            list.add(pos1, num1);
                        break;
                    case 3:
                        System.out.println("Enter position to remove");
                        int pos2 = scan.nextInt();
                        if (pos2 < 0 || pos2 >= list.size())
                            System.out.println("Invalid position\n");
                        else
                            list.remove(pos2);
                        break;
                    case 4:
                        System.out.println("Enter integer element to set");
                        int num2 = scan.nextInt();
                        System.out.println("Enter position");
                        int pos3 = scan.nextInt();
                        if (pos3 < 0 || pos3 >= list.size())
                            System.out.println("Invalid position\n");
                        else
                            list.set(pos3, num2);
                        break;
                    case 5:
                        System.out.println("Enter integer element to check containment");
                        int num3 = scan.nextInt();
                        boolean contain = list.contains(num3);
                        if (contain) {
                            System.out.println("True");
                        } else {
                            System.out.println("False");
                        }
                        break;
                    case 6:
                        System.out.println("Empty status = " + list.isEmpty());
                        break;
                    case 7:
                        System.out.println("Size = " + list.size() + " \n");
                        break;
                    case 8:
                        list.clear();
                        break;
                    case 9:
                        Random random = new Random();
                        for(int i = 0; i < 10; i++) {
                            listInt.add(random.nextInt(50));
                        }
                        for(int j = 0; j < 10; j++) {
                            listFloat.add(random.nextFloat()*random.nextInt(50));
                        }
                        System.out.println("The Circular Doubly Linked List = "+ "\n" + listInt + "\n" + listFloat);

                        System.out.println("Please input the start index of listFloat that you want to start splicing");
                        int start = scan.nextInt();
                        System.out.println("Please input the end index of listFloat that you want to start splicing");
                        int end = scan.nextInt();
                        System.out.println("Please input the index of listInt that you want to splice into");
                        int begin = scan.nextInt();

                        boolean spliced = listInt.splice(listFloat, start, end, begin);
                        System.out.println("\n/****** After splicing...  ******/");
                        if(spliced) {
                            System.out.println("The Circular Doubly Linked List is spliced successfully");
                        } else {
                            System.out.println("The Circular Doubly Linked List is not spliced successfully"
                                    + "\nPlease check the parameter of the splice method");
                        }
                        System.out.println("The Circular Doubly Linked List = "+ "\n" + listInt + "\n" + listFloat);
                        print = false;
                        listInt.clear();
                        listFloat.clear();
                        break;
                    default:
                        System.out.println("Wrong Entry \n ");
                        break;
                }
            /*  Display List  */
                if(print) {
                    System.out.println(list.toString());
                }
                System.out.println("\nDo you want to continue (Type y or n) \n");
                response = scan.next();
            } catch (InputMismatchException ime) {
                System.out.println("Your input is of a wrong type. Please input an integer!");
            }
        } while (response.equals("y"));
    }
}
