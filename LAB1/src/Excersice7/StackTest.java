/**
 * 
 */
package Excersice7;

/**
 * @author Abd Alrahman
 *
 */

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.List;

public class StackTest {
	
	Stack myStack;
	
	@Before 
	public void setup() {
		myStack = new Stack();
	}
	
	@Test 
	public void testPushOneAtTime() {
		for (int i = 0; i < 100; i++) {
			myStack.push(i);
		}
		assertEquals(myStack.n, 100);
	}
	
	@Test 
	public void testFifo() {
		for (int i = 0; i < 100; i++) {
			myStack.push(i);
		}
		assertEquals(myStack.n, 100);
		for (int i = 99; i >= 0; i--) {
			assertEquals(myStack.pop(), (Integer)i);
			assertEquals(myStack.n, i);
		}
	}
	
	@Test 
	public void testPopWhenStackEmpty() {
		assertEquals(myStack.n, 0);
		assertEquals(myStack.pop(), null);
	}
	
	@Test 
	public void testPushArray() {
		Integer[] array = new Integer[] {1,2,3,4,5};
		myStack.push(5, array);
		assertEquals(myStack.n, 5);
		for(int i= 4; i >= 0; i--) {
			assertEquals(myStack.pop(), array[i]);
			assertEquals(myStack.n, i);
		}
		
	}
	@Test
	public void testPopArray() {
		Integer[] array = new Integer[] {1,2,3,4,5};
		myStack.push(5, array);
		assertEquals(myStack.n, 5);
		List<Integer> popedArray = myStack.pop(5); 
		for (int i = 0; i < 5; i++) {
			assertEquals(array[i],popedArray.get(i));
		}
		assertEquals(myStack.n, 0);
	}
	
	
}
