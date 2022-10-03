/**
 *  @author etmybarbosa
 */
import java.util.ArrayList;

/** Interface for a generic Stack data structure
 * 
 * @param <T> data type
 */
public class MyQueue<T> implements QueueInterface<T>{

	int SIZE;
	ArrayList<T> data;
	int front = 0;
	int back = 0;
	int numOfVar = 0;
	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 
	 */
	public MyQueue(int s) {
		this.SIZE = s;
		data = new ArrayList<T>(s); 
	}
	
	public MyQueue() {
		SIZE =7;
		data = new ArrayList<T>(SIZE); 
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty(){
		if(numOfVar == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull(){
		if(numOfVar == SIZE) {
			return true;
		}
		return false;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException{
		try {
			if(isEmpty()) {
				throw new QueueUnderflowException();
			}
				T temp = data.get(front);
				front = (front+1)%SIZE;
				numOfVar --;
				return temp;
			
		}catch(Exception e) {
			throw new QueueUnderflowException();
		}
		
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size(){
		return numOfVar;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException{
		try {
			if(isFull()) {
				throw new QueueOverflowException();
			}
			data.add(back, e);
			back = (back+1)%SIZE;
			numOfVar++;
			return true;
		}catch(Exception x) {
			throw new QueueOverflowException();
		}
		
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString(){
		String str = "";
		for(int i=0; i<size();i++) {
			str += data.get(i);
		}
		return str;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter){
		String str = "";
		for(int i=0; i<size();i++) {
			str += data.get(i) + delimiter;
		}
		return str.substring(0, str.length()-1);
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	public void fill(ArrayList<T> list){
		for(int i=0; i<list.size(); i++) {
			try {
				T temp = list.get(i);
				enqueue(temp);
			}catch(QueueOverflowException e) {
				e.getMessage();
			}
		}
	}
	
}
