package adts;

// Imports
import interfaces.QueueInterface;
import nodes.LLNode;

public class LLQ<E> implements QueueInterface<E> {

	LLNode<E> front; //This is the head of the linked list
	LLNode<E> rear; // This is the tail of the linked list

	@Override
	public void enqueue(E element) {
		LLNode<E> newNode = new LLNode<E>(element);
		if (front == null) {
			front = rear = newNode; // works only for first add!
		} else {
			// second and later
			rear.setNext(newNode);
			rear = newNode;
		}
	}

	@Override
	public E dequeue() {
		E temp = front.getData();
		front = front.getNext();
		if (front == null) {
			rear = null;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder qStr = new StringBuilder("queue: ");
		LLNode<E> ptr = front; // Points to the top of the stack
		while (ptr != null) {
			qStr.append(ptr.getData() + " ");
			ptr = ptr.getNext();
		}
		return qStr.toString();
	}

}
