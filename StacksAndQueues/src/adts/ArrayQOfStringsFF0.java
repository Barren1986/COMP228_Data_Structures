package adts;

public class ArrayQOfStringsFF0 {

	protected String[] queue; // Implementation Level - must specify the index value. Only declared
	protected final int FRONT = 0;
	protected int rear = -1;

	// Constructor
	public ArrayQOfStringsFF0() {
		queue = new String[10];
	}

	public ArrayQOfStringsFF0(int capacity) {
		queue = new String[capacity];
	}

	public void enqueue(String element) {
		//rear++;
		queue[++rear] = element;
	}

	public String dequeue() {
		String temp = queue[FRONT];
		for (int i = 1; i <= rear; i++) {
			queue[i - 1] = queue[i];
		}
		queue[rear] = null;
		rear--;
		return null;
	}

	public boolean isEmpty() {
		if (rear == -1) { // shows that the queue is empty
			return true; // Queue is empty
		}
		return false; // Queue is not empty
	}

	public boolean isFull() {
		if (rear == queue.length - 1) {
			return true; // Queue is Full
		}
		return false; // Queue is not full
	}

	public String toString() {
		StringBuilder qStr = new StringBuilder("queue: ");
		for (int i = 0; i <= rear; i++) {
			qStr.append(queue[i] + " ");
		}
		return qStr.toString();
	}

}



