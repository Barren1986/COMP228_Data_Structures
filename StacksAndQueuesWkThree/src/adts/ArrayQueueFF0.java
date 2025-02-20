package adts;

import interfaces.QueueInterface;

import javax.swing.*;

public class ArrayQueueFF0<E> implements QueueInterface<E> {

	protected E[] queue;
	protected final int FRONT = 0;
	protected int rear = -1;

	public ArrayQueueFF0() {
		queue = (E[]) new Object[10];
	}

	public ArrayQueueFF0(int capacity) {
		queue = queue = (E[]) new Object[capacity];
	}

	public void enqueue(E element) {
		rear++;
		queue[rear] = element;
	}

	public E dequeue() {
		E temp = queue[FRONT];
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





