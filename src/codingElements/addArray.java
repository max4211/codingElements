package codingElements;

public class addArray {
	/*
	 * Goal: Write an algorithm to do array addition
	 */
	
	public static int[] addition(int[] D, int increment) {
		int digit; int carry = -1;
		boolean first = true;
		for (int i = D.length-1; i >= 0; i --) {
			digit = D[i];
			if (carry == 0)
				return D;
			if (first) {
				carry = (int)Math.floor((digit+increment)/10);
				D[i] = (digit+increment)%10;
				first = false;
				continue;
			} else {
				D[i] = (digit+carry)%10;
				carry = (int)Math.floor((digit+carry)/10);	
			}
		}
		return D;
	}
	
	public static void tester() {
		int[] D = new int[] {1,2,9};
		int increment = 21;
		D = addition(D, increment);
		for (int num: D)
			System.out.println(num);
	}
	
	public static void main (String[] args) {
		tester();
	}
	
	/*
	 * Idea: Do handwritten addition, using temporary variables to store remainder
	 * Work from the back, ending when there is no more remainder
	 * Best case is O(1) complexity, worst case is O(n)
	 * Space complexity is O(1)
	 */
}
