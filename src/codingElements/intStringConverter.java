package codingElements;

public class intStringConverter {

	/*
	 * TODO: Add in negative functionailty (this is trivial, not going to waste my time this way)
	 * Construct an algorithm that inter converts ints and strings without using built in libraries
	 */
	
	public static String itos(int n) {
		StringBuilder sb = new StringBuilder();
		int digit;
		while (true) {
			digit = n%10;
			n = (int)n/10;
			if (digit == 0 && n < 10)
				return sb.reverse().toString();
			sb.append(digit);
		}
	}
	
	public static int stoi(String s) {
		int power = s.length()-1;
		int total = 0;
		char tempC; int tempI;
		for (int i = 0; i < s.length(); i ++) {
			tempC = s.charAt(i);
			tempI = tempC - '0';
			total += tempI*Math.pow(10, power);
			power --;
		}
		return total;
	}
	
	public static void tester() {
		String s = "1234";
		int n = 1234;
		
		int s2 = stoi(s);
		String n2 = itos(n);
		
		System.out.println("Int: " + s2);
		System.out.println("Str: " + n2);
	}
	
	public static void divTest() {
		int n = 124;
		int four = (int)n%10;
		n = n/10;
		int two = (int)n%10;
		n = n/10;
		int one = (int)n%10;
		n = n/10;
		int zero = (int)n%10;
		
		System.out.println("four: " + four + "\ntwo: " + two + "\none: " + one + "\nzero: " + zero);
	}
	
	public static void main (String[] args) {
		tester();
	}
	
	/*
	 * Pseudocode discussion
	 * For String to int, go char by char, adding this to a number (using math.pow(10))
	 * For int to String, use string builder to fill in, then reverse, then convert toString (use module 10 and divide by 10)
	 * ^^ StringBuilder(sb).reverse().toString() will take care of it all for me
	 */
}
