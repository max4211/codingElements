package codingElements;

import java.util.Collections;

public class arrayOperations {

	/*
	 * Construct an algorithm that modifies an existing char array
	 */
	
	public static char[] operate(char[] myArray) {
		myArray = scan1(myArray);
		
		return myArray;
	}
	
	public static char[] swapAB(char[] myArray) {
		int lastA = 0;
		int lastB = 0;
		
		return myArray;
	}
	
	public static char[] scan1(char[] myArray) {
		int nextChange = 0;
		int nextLeave = myArray.length-1;
		char temp;
		for (int i = 0; i < myArray.length; i ++) {
			temp = myArray[i];
			if (temp == 'a' || temp == 'b') {
				myArray = arSwap(myArray, i, nextChange);
				nextChange ++;
			} else {
				myArray = arSwap(myArray, i, nextLeave);
				nextLeave --;
			}
		}
		return myArray;
	}
	
	// Swap values in char array
	public static char[] arSwap(char[] myArray, int i1, int i2) {
		char t1; char t2;
		t1 = myArray[i1];
		t2 = myArray[i2];
		myArray[i1] = t2;
		myArray[i2] = t1;
		return myArray;
	}
	public static void tester() {
		char[] myArray = new char[]{'a', 'd', 'c', 'c', 'b', 'z', 'q', 'y'};
		char[] newArray = operate(myArray);
		for (char c: newArray)
			System.out.println(c);
	}
	
	public static void main (String[] args) {
		tester();
	}
	
	/*
	 * Pseudocode discussion: Easy with O(n) space, want to do this in O(n) time - multiple scans> - and O(1) space with swapping
	 * Idea, use invariants and swapping to first custom sort the array
	 * Leave all untouched values in the back, keep all values you will mess with in the front
	 * Then scan through the front again, pairing a's and b's as often as possible
	 * Finally, rewrite a's as d's, convert paired b's to d's
	 * Left over b's should be removed (concat array with array properties)
	 * Problem statement implies no leftover as (guessing array will be of constant size, so #a's = #b's?
	 */
}
