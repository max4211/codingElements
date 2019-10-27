package codingElements;

public class intSquare {
	public static int findInt(int n) {
		int low = 0;
		int high = (int)n/2;
		int mid;
		int k;
		while ((high-low)>1) {
			mid = findMid(low, high);
			k = (int) Math.pow(mid, 2);
			if (k <= n)
				low = mid;
			else
				high = mid;
		}
		
		return low;
	}
	
	public static int findMid(int low, int high) {
		return (int)(high+low)/2;
	}
	
	public static void main (String[] args) {
		int n = 11209;
		System.out.println("start: " + n + ", finish: " + findInt(n));
	}
}

/** Input an integer, output largest int whose square is less than or equal to that value
 * 
 */
