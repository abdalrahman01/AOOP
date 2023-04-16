/**
 * 
 */
package lab1.E7;


import java.util.*;

/**
 * @author Abd Alrahman
 *
 */
public class Stack {

	/**
	 * The head element of a stack
	 */
	private Node first;
	public int n; // size 

	private class Node {
		Integer item;
		Node next;
		
		public Node(Integer i, Node nex) {
			item = i; 
			next = nex;
		}
	}

	
	public Stack() {
		
	}

	/**
	 * @summary insert a new integer to the stack
	 * @param e Integer 
	 */
	public void push(Integer e) {
		if (n == 0) {
			first = new Node(e,null);
		}
		else {
			first = new Node(e, first);
		}
		n++;
	}

	/**
	 * @summary get the last element inserted to the stack, and remove it 
	 * @return the last Integer pushed to the stack
	 */
	public Integer pop() {
		if (n==0)
			return null;
		Integer temp = first.item;
		if (n==1) {
			first = null;
		}
		else 
		{
			first = first.next;
		}
		
		
		
		n--;
		return temp;
	}

	/**
	 * @summury inserts the set of n elements on top of the stack (en is placed on top of the stack)
	 * @param n int number of elements
	 * @param e Integer[] the elements
	 */
	public void push(int n, Integer[] e) {
		for(int i = 0; i < n; i++)
			push(e[i]);
	}

	/**
	 * @summary removes and returns the n elements from the top of the stack (the 
	 * implemented method returns the n elements as a list, where considering the order, the element 
	 * on top of the stack is the last element in the list
	 * @param n int how many elements to be poped and removed. 
	 * @return a list of integer
	 */
	public List<Integer> pop(int n) {
		if (n == 0)
			return null;
		Integer[] result = new Integer[n];
		for (int i = n-1; i >= 0; i--) {
			result[i] = pop();
		}
		
		
		return Arrays.asList(result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
