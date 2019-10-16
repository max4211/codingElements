package codingElements;

import java.util.ArrayList;
import java.util.HashSet;

public class spiralArray {
	
	/*
	 * Construct an algorithm that iterates through a 2d array and spirals the numbers
	 * Each side has a pattern (top increments by one, right increments by n, bottom decreases by 1, left decreases by n)
	 */
	
	public static int[] spiral(int n) {
		int[] guy = new int[n*n];
		// HashSet<Integer> mySet = createSet(n);
		// ArrayList<Integer> myList = createList(n);
		int side = 1;
		int expected = n;
		int last = 1;
		for (int i = 1; i <= n*n; i ++) {
			if (expected == 0)
				return guy;
			if (side == 1) {
				for (int j = last; j < last+expected; j ++)
					guy[i] = j;
				side = 2;
				i += expected;
				expected --;
				last = guy[i];
				continue;
			}
			if (side == 2) {
				for (int j = last; j < last+expected; j += n)
					guy[i] = j;
				side = 3;
				i += expected;
				expected --;
				last = guy[i];
				continue;
			}
			if (side == 3) {
				for (int j = last; j < last+expected; j --)
					guy[i] = j;
				side = 4;
				i += expected;
				expected --;
				last = guy[i];
				continue;
			}
			if (side == 4) {
				for (int j = last; j < last+expected; j -= n)
					guy[i] = j;
				side = 1;
				i += expected;
				expected --;
				last = guy[i];
				continue;
			}
		}
		return guy;
	}
	
	public static ArrayList<Integer> createList(int n) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i ++)
			myList.add(i);
		return myList;
	}
	
	public static HashSet<Integer> createSet(int n) {
		HashSet<Integer> mySet = new HashSet<Integer>();
		for (int i = 1; i <= n; i ++)
			mySet.add(i);
		return mySet;
	}
	
	public static void tester() {
		int n = 4;
		int[] myArray = spiral(n);
		System.out.println(myArray);
		for (int val: myArray)
			System.out.println(val);
	}
	
	public static void main (String[] args) {
		tester();
	}
	
	/*
	 * Pseudocode discussion: book advises divide and conquer and case analytics, but that seems stupid to me
	 * Idea: Use pattern recognitiona, math, and hashsets to spiral from the outside in
	 * Each side has a pattern (top increments by one, right increments by n, bottom decreases by 1, left decreases by n)
	 */
}
