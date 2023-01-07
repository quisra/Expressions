/**
 * 
 */

/**
 * @author Richfield Quist
 *
 */
public class Stack<E> {
	
	public static final int CAPACITY=1000; // default array capacity
	private E[ ] data; // generic array used for storage
	private int t = -1; // index of the top element in stack
	public Stack( ) { this(CAPACITY); } // constructs stack with default capacity
	public Stack(int capacity) { // constructs stack with given capacity
		data = (E[ ]) new Object[capacity]; // safe cast; compiler may give warning
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return (t + 1);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t == -1);
	}

	public void push(E e)throws IllegalStateException {
		// TODO Auto-generated method stub
		if (size( ) == data.length) throw new IllegalStateException("Stack is full");
		 data[++t] = e;
	}

	public E peek() {
		// TODO Auto-generated method stub
		if (isEmpty( )) return null;
		 return data[t];
	}

	public E pop() {
		// TODO Auto-generated method stub
		if (isEmpty( )) return null;
		E answer = data[t];
		data[t] = null; // dereference to help garbage collection
		t--;
		return answer;
	}
	
	
	
	
	
	
	
//	/*
//	 * Returns the number of elements in the stack
//	 * @return number of elements in the stack
//	 */
//	int size( );
//	
//	/*
//	 * Tests whether the stack is empty.
//	 * @return true if the stack is empty, false otherwise
//	 */
//	boolean isEmpty();
//	
//	/*
//	 * Inserts an element at the top of the stack.
//	 * @param e the element to be inserted
//	 */
//	void push(E e);
//	
//	/**
//	* Returns, but does not remove, the element at the top of the stack.
//	* @return top element in the stack (or null if empty)
//	*/
//	E peek( );
//	
//	/**
//	* Removes and returns the top element from the stack.
//	* @return element removed (or null if empty)
//	*/
//	E pop( );
	

}
