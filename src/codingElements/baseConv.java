package codingElements;

import java.util.ArrayList;
import java.util.HashMap;

public class baseConv {
	/*
	 * Construct an algorithm that converts a number form one base to another
	 */
	
	static HashMap<Character, Integer> myMap;
	
	public static String convert(String s, int b1, int b2) {
		int n = decimal(s, b1);
		String s2 = newBase(n, b2);
		return s2;
	}
	
	// Helper function to convert value to new base
	public static String newBase(int n, int b2) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> myCache = createCache(n, b2);
		int index = myCache.size()-1;
		int digit;
		int myPow;
		String cipher;
		while (index>=0) {
			myPow = (int)Math.pow(b2, myCache.get(index));
			System.out.println(myPow);
			digit = (int)n/myPow;
			n = n%myPow;
			cipher = finalMap(digit);
			sb.append(cipher);
			index--;
		}
		return sb.toString();
	}
	
	// Helper to map digits to final insertion
	public static String finalMap(int digit) {
		String guy;
		if (digit < 10)
			guy = Character.toString((char)(digit+'0'));
		else
			guy = Character.toString((char)(digit+'A'-10));
		System.out.println(digit + " --> " + guy);
		return guy;
	}
	
	// Helper function to create cache from new base and value
	public static ArrayList<Integer> createCache(int n, int b2) {
		ArrayList<Integer> myCache = new ArrayList<Integer>();
		int exponent = 1;
		int power = 1;
		while (exponent < n) {
			myCache.add(exponent);
			power ++;
			exponent = (int)Math.pow(b2, power);
		}
		return myCache;
	}
	
	// Helper to convert new base value to base 10
	public static int decimal(String s, int b1) {
		int power = s.length()-1;
		int total = 0;
		int coeff;
		char temp;
		for (int i = 0; i < s.length(); i ++) {
			temp = s.charAt(i);
			coeff = myMap.get(temp);
			total += coeff*Math.pow(b1, power);
			power --;
		}
		return total;
	}
	
	public static void createMap() {
		myMap = new HashMap<Character, Integer>();
		for (int i = 0; i < 15; i ++) {
			if (i <  10) {
				myMap.put((char)(i+48), i);
			} else {
				myMap.put((char)('A'-10+i), i);
			}
		}
	}
	
	public static void tester() {
		String s = "615";
		int b1 = 7;
		int b2 = 13;
		String guy = convert(s, b1, b2);
		System.out.println(guy);
	}
	
	public static void main (String[] args) {
		createMap();
		// tester();
		
		ArrayList<Integer> myCache = createCache(306, 13);
		for (int num: myCache)
			System.out.println(num);
		/*
		int guy = decimal("615", 7);
		System.out.println(guy);
		 */
		

	}
	
	/*
	 * Pseudocode discussion: Hint is to convert to a mutually known base
	 * Idea - convert intermittently to base 10, then convert back to the new base
	 * Seems like brute force, lets solve this way then refine?
	 */
}
