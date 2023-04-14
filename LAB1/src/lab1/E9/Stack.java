/**
 * 
 */
package lab1.E9;


import java.util.*;

/**
 * @author Abd Alrahman
 *
 */
public class Stack<T> {

	/**
	 * The head element of a stack
	 */
	private Node<T> first;
	public int n; // size 

	private class Node<T> {
		T item;
		Node<T> next;
		
		public Node(T i, Node<T> nex) {
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
	public void push(T e) {
		if (n == 0) {
			first = new Node<T>(e,null);
		}
		else {
			first = new Node<T>(e, first);
		}
		n++;
	}

	/**
	 * @summary get the last element inserted to the stack, and remove it 
	 * @return the last Integer pushed to the stack
	 */
	public T pop() {
		if (n==0)
			return null;
		T temp = (T) first.item;
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
	public void push(int n, T[] e) {
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
	@SuppressWarnings("unchecked")
	public List<T> pop(int n) {
		if (n == 0)
			return null;
		T[] result = (T[]) new Object[n];
		for (int i = n-1; i >= 0; i--) {
			result[i] = pop();
		}
		
		
		return Arrays.asList(result);
	}
	
	public int size() {
		return n; 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Message> msgStack = new Stack<Message>();
		
		Message hello = new Message("Hello, World");
		
		msgStack.push(hello);
		
		for (int i = 0; i < 1000; i++) {
			msgStack.push(new Message("Hello, World " + i + "\n"));
		}
		
		System.out.println(msgStack.pop(10));
		System.out.println(msgStack.pop(10));
		System.out.println(msgStack.pop(10));
		System.out.println(msgStack.pop(10));
	}

}
