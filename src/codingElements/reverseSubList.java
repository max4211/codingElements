package codingElements;

import java.util.ArrayList;

public class reverseSubList {
	
	public static ListNode reverseList(ListNode myList, int index1, int index2) {
		ListNode head = myList;
		for (int i = 1; i <= index1; i ++)
			myList = myList.next;
		ListNode midHead = myList;
		ListNode midDum = myList;
		for (int i = index1; i <= index2; i ++) {
			myList = myList.next;
		}
		return myList;
	}
	
	// Helper method to reverse part of a list
	public static ListNode helpReverse(ListNode myList) {
		ArrayList<Integer> vals = new ArrayList<Integer>();
		while (myList.next != null) {
			vals.add(myList.val);
			myList = myList.next;
		}
		ListNode sentinel = myList;
		for (int i = vals.size()-1; i >= 0; i --) {
			myList.next = new ListNode(vals.get(i));
			myList = myList.next;
		}
		return sentinel;
	}
	
	public static void tester() {
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode myList = createList(nums);
		System.out.println("\noriginal list: ");
		printList(myList);
		ListNode revList = helpReverse(myList);
		System.out.println("\nreversed list: ");
		printList(revList);
	}
	
	public static ListNode createList(int[] nums) {
		ListNode sentinel = new ListNode(nums[0]);
		ListNode current = sentinel;
		int temp;
		for (int i = 1; i < nums.length; i ++) {
			current.next = new ListNode(0);
			current = current.next;
			temp = nums[i];
			current.val = temp;
		}
		return sentinel;
	}
	
	public static void printList(ListNode myList) {
		while (myList != null) {
			System.out.print(myList.val);
			myList = myList.next;
		}
	}
	
	public static void main (String[] args) {
		tester();
	}
	
}
