package codingElements;

import java.util.Stack;

public class stackRPN {
	
	public static boolean print = true;

	public static int calc(String s) {
		Stack<Integer> nums = new Stack<Integer>();
		String letter;
		String[] splitter = s.split(",");
		for (int i = 0; i < splitter.length; i ++) {
			letter = splitter[i];
			if (print)
				System.out.println("letter: " + letter); 
			if (letter.equals("+") || letter.equals("-") || letter.equals("/") || letter.equals("x"))
				nums = operate(nums, letter);
			else
				nums.push(Integer.parseInt(letter));
			System.out.println("nums.peek(): " + nums.peek());
		}
		return nums.peek();
	}
	
	public static Stack<Integer> operate(Stack<Integer> nums, String letter) {
		int i1 = nums.pop();
		int i2 = nums.pop();
		int temp = 0;
		
		if (letter.equals("+"))
			temp = i1+i2;
		if (letter.equals("-"))
			temp = i1-i2;
		if (letter.equals("x"))
			temp = i1*i2;
		if (letter.equals("/"))
			temp = i1/i2;
		
		if (print)
			System.out.println(i1 + letter + i2 + "=" + temp);
		
		nums.push(temp);
		return nums;
	}
	
	public static void main (String[] args) {
		String s = "3,4,+,2,x,1,+";
		int result = calc(s);
		System.out.println(s + " = " + result);
	}
}
