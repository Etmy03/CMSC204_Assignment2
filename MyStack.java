/**
 *  @author etmybarbosa
 */
import java.util.ArrayList;

/** Interface for a generic Stack data structure
 * 
 * @param <T> data type
 */
public class MyStack<T> implements StackInterface<T>{

	int SIZE;
	ArrayList<T> data;
	int top = 0;
	int numOfVar = 0;
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	public MyStack(int s) {
		SIZE = s;
		data = new ArrayList<T>(s);
	}
	public MyStack() {
		SIZE =7;
		data = new ArrayList<T>(SIZE); 
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty(){
		if(top == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull(){
		if(top == SIZE) {
			return true;
		}
		return false;
	}
	
	

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException{
		try {
			if(isEmpty()) {
				throw new StackUnderflowException();
			}
			numOfVar --;
			T temp = data.get(--top);
			data.remove(top);
			return temp;
		}catch(Exception e) {
			throw new StackUnderflowException();
		}
		
	}
	
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException{
		try {
			if(isEmpty()) {
				throw new StackUnderflowException();
			}
			T temp = data.get(--top);
			top += 1;
			return temp;
		}catch(Exception e) {
			throw new StackUnderflowException();
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return numOfVar;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException{
		if(isFull()) {
			throw new StackOverflowException();
		}
		numOfVar ++;
		top += 1;
		data.add(e);
		return true;
	}
	
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString(){
		String str = "";
		for(int i=0; i<size();i++) {
			str += data.get(i);
		}
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter){
		String str = "";
		for(int i=0; i<size();i++) {
			str += data.get(i) + delimiter;
		}
		return str.substring(0, str.length()-1);
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list){
		for(int i=0; i<list.size(); i++) {
			try {
				T temp = list.get(i);
				push(temp);
			}catch(StackOverflowException e) {
				e.getMessage();
			}
		}
	}
}
