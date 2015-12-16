/** A class to print out all the prime numbers between 1 and 100.
 *  @author Xinyue Zhang xzhang@brynmawr.edu
 */

public class Prime {
    //Method 
    /** 
     * Test the primality of the number given in the parameter. The boolean result is based on finding possible factors of the given number. If there is such a factor, the number is composite and returns false; otherwise, returns true.
     * @param n the number between 1 and 100 whose primality is to be tested
     * @return A boolean value true or false: true if the number is prime; false if the number is composite
     */
    
    public static boolean isPrime(int n) {
	// return false for all numbers less than one by definition
	if(n <= 1) return false;
	// return true for the only even prime 2
	if(n == 2) return true;
	// return false for other even numbers
	if(n % 2 == 0) return false;

	// return false for all composite  numbers that are divisible by odd numbers starting from 3 and ending at the square root of n. Since we are testing the potential factors of n, the last divisor we need to test is the square root of n because all the factors bigger than Math.sqrt(n) must also have another factor smaller than Math.sqrt(n) which we have already tested.
	for(int i = 3; i <= Math.sqrt(n); i+=2) {
	    if(n % i == 0) {
		return false;
	    }
	}
	// return true for all the numbers left that are not composite
        return true;
    }

    // main method
    /** 
     * Prints out all the prime numbers between 1 and 100 with index formatted, and the total number of them. 
     * @param potential user input in the console
     */
    
    Public Static Void main(String[] args) {
	System.out.println("Here are the prime numbers between 1 and 100: ");
	// count the prime numbers
	int count = 0;
	// print out all the prime numbers with index, and format them using the escape sequence \t (Tab character).
	for(int i >= 1; i <= 100; i++) {
	    if(isPrime(i)) {
		System.out.println(count + "\t" + i);
		count++;
	    }
	}
	System.out.println();
	// print out the number of prime numbers
	System.out.println("There are " + count + " prime numbers between 1 and 100");
    }
}
