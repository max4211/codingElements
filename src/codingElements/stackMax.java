package codingElements;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class stackMax {
	
	ArrayList<Integer> myStack;
	PriorityQueue<Integer> myQueue;
	int mySize;
	int myMax;
	
	public stackMax() {
		myMax = 0;
		mySize = 0;
		myStack = new ArrayList<Integer>();
		myQueue = new PriorityQueue<Integer>();
	}
	
	public int pop() {
		int temp;
		if (mySize == 0)
			throw new NullPointerException("Stack is empty, cannot pop at this time");
		else {
			temp = myStack.get(mySize);
			myStack.remove(mySize);
			mySize --;
			// TODO Update maximum value
			myQueue.remove(temp);
			myMax = getMax();
		}
		return temp;
	}
	
	public void push(int n) {
		mySize += 1;
		myStack.add(n);
		// TODO Add to max array
		myQueue.add(n);
		myMax = getMax();
	}
	
	public int peek() {
		return myStack.get(mySize);
	}
	
	public int getMax() {
		return myQueue.peek();
	}
	
	public static void peekMe(stackMax guy) {
		System.out.println("peek: " + guy.peek());
	}
	
	public static stackMax popMe(stackMax guy) {
		int temp = guy.pop();
		System.out.println("popping: " + temp);
		return guy;
	}
	
	public static stackMax pushMe(stackMax guy, int n) {
		guy.push(n);
		System.out.println("pushing: " + n);
		return guy;
	}
	
	public static void maxMe(stackMax guy) {
		System.out.println("getting max: " + guy.getMax());
	}
	
	public static void main (String[] args) {
		stackMax guy = new stackMax();
		pushMe(guy, 2);
		pushMe(guy, 4);
		pushMe(guy, -7);
		pushMe(guy, 9);
		peekMe(guy);
		popMe(guy);
		maxMe(guy);
	}
	
}

/* Pseudocode discussion: Design a stack with push/pop and max operations
 * Idea: Have parallel data types, one to hold stack (arrayList?), one to keep track of maximum values
 * Data type to hold maximum values (priority queue with maximum comparator)
 */
