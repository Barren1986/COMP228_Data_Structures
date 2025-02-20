package apps;
import nodes.LLNode;

public class LLPlay {

	public static void main(String[] args) {

		// Create a new node with the character 'A'
		LLNode<Character> newNode = new LLNode('A'); //Instantiates a new node object with data 'A'
		LLNode<Character> head = newNode; // Sets the head of the linked list to point to the first node.

		// Create a new node with the character 'T'
		newNode = new LLNode('T'); //Instantiated a new node object
		newNode.setNext(head); // Links the newly created 'T' node to the node holding 'A'
		head = newNode; // The `head` now points to the top of the list ('T' -> 'A')

		// Create a new node with the character 'A'
		newNode = new LLNode('A'); // Instantiates a new node object with data 'A'
		newNode.setNext(head); // Links the newly created 'A' node to the node holding 'T'
		head = newNode; // The `head` now points to the top of the list ('A' -> 'T' -> 'A')

		// Create a new node with the character 'D'
		newNode = new LLNode('D'); // Instantiates a new node object with data 'D'
		newNode.setNext(head); // Links the newly created 'D' node to the node holding 'A'
		head = newNode; // The `head` now points to the top of the list ('D' -> 'A' -> 'T' -> 'A')

		LLNode<Character> ptr = head; //Reference variable - not an object

		while (ptr != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getNext();
		}

	}
}
