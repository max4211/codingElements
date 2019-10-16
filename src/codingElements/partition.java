package codingElements;

public class partition {
	/*
	 * Write a function that takes an array and an index and partitions the array
	 */
	public static int[] partPivot (int[] A, int index) {
		int nextSmall = 0;
		int nextLarge = A.length - 1;
		int temp;
		int pivot = A[index];
		for (int i = 0; i < A.length; i ++) {
			System.out.println("index: " + i);
			temp = A[i];
			if (temp < pivot) {
				A = swapBoys(A, i, nextSmall);
				nextSmall ++;
				continue;
			} 
			if (temp == pivot) {
				A = swapBoys(A, i, index);
				index ++;
				continue;
			}
			if (temp > pivot) {
				A = swapBoys(A, i, nextLarge);
				nextLarge --;
				// i --;
			}
		}
		return A;
	}
	
	public static int[] swapBoys(int[] A, int t1, int t2) {
		int temp2 = A[t2];
		int temp1 = A[t1];
		A[t1] = temp2;
		A[t2] = temp1;
		System.out.println(temp1 + " <--> " + temp2);
		return A;
	}
	
	public static void tester() {
		int[] A = new int[] {1, 2, 1, 5, 1, 4, 5};
		int index = 3;
		int[] sorted = partPivot(A, index);
		for (int num: sorted)
			System.out.println(num);
	}
	
	public static void main (String[] args) {
		tester();
	}
	
	/*
	 * Pseudocode disussion: Want to use constant space O(1), O(n) space is trivial
	 * Idea: Go through values, maintaining pointers to next small and next large
	 * Issues appear to arise if the pivot has lots of values greater than or less than itself
	 * 
	 * Current issue, what if the value equals the pivot, how to account for this?
	 * 
	 * Status - incomplete - use invariants to solve, solution makes sense
	 */
}
