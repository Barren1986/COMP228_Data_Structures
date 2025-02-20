package adts;
import nodes.LLNode;
import interfaces.StackInterface;

public class LLStack<E> implements StackInterface<E> {

	LLNode top; // this is the head

	@Override
	public void push(E element) {
		LLNode<E> newNode = new LLNode(element);
		newNode.setNext(top);
		top = newNode;
	}

	@Override
	public E pop() {
		E temp = (E) top.getData();
		top = top.getNext();
		return temp;
	}

	@Override
	public E peek() {
		return (E) top.getData();
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public String toString() {
		StringBuilder stackStr = new StringBuilder("stack:\n ");
		LLNode<E> ptr = top; // Points to the top of the stack
		while (ptr != null) {
			stackStr.append(ptr.getData() + "\n");
			ptr = ptr.getNext();
		}
		return stackStr.toString();
	}

}
