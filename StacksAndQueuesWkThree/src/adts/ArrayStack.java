package adts;

import interfaces.StackInterface;

public class ArrayStack<E> implements StackInterface<E> {

	protected E[] stack;
	protected int top = -1;
	protected final int DEFAULT_CAPACITY = 7;

	// Constructors
	public ArrayStack() {
		stack = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public ArrayStack(int capacity) {
		stack = (E[]) new Object[capacity];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == stack.length - 1;
		}

	@Override
	public void push(E element) { //Adds new element to top of stack
		top++; //Add to 'top' of index by 1 to point to next place in stack
		stack[top] = element; //Places new element at the top of the stack
	}

	@Override
	public E pop() { //remove and return element at the top of the stack
		E temp = stack[top]; //Stores element in temp
		stack[top] = null; //Set the top and clear it
		top--; // Decrement top index to next element down the stack
		return temp;
	}

	@Override
	public E peek() { // Finds the elements at the top of stack without removing it
		return stack[top]; // Access and return the element at the index 'top' in the array 'stack

	}

	public String toString() {
		StringBuilder stackStr = new StringBuilder("stack:\n ");
		for (int i = top; i >= 0; i--) {
			stackStr.append(stack[i] + "\n ");
		}
		return stackStr.toString();
	}

}