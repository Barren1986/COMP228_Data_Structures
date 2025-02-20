package adts;

public class ArrayQofStringsFF0 {
	
	protected String[] queue;
	protected final int FRONT = 0;
	protected int rear = -1;
	protected int DEFAULT_CAPACITY = 10;

	//Constructors
	public ArrayQofStringsFF0() {
		queue = new String[DEFAULT_CAPACITY];
	} //no-arg constructor
	
	public ArrayQofStringsFF0(int capacity) {
		queue = new String[capacity];
	}


	// Methods
	public void enqueue(String element) {
		rear++;
		queue[rear] = element;
	}
	
	public String dequeue() {
		String temp = queue[FRONT];
		for (int i = 1; i <= rear; i++) {
			queue[i-1] = queue[i];
		}
		queue[rear] = null;
		rear--;
		return temp;
	}
	
	public boolean isEmpty() {
		return rear == -1;
	}
	
	public boolean isFull() {
		return rear == queue.length - 1;
	}
	
	public String toString() {
		StringBuilder qStr = new StringBuilder("queue: ");
		for (int i = FRONT; i <= rear; i++) {
			qStr.append(queue[i] + " ");
		}
		return qStr.toString();
	}
	
}





