package apps;
import adts.ArrayQOfStringsFF0;

public class QofStrPlay {

	public static void main(String[] args) {

		ArrayQOfStringsFF0 myQ = new ArrayQOfStringsFF0();
		System.out.println(myQ.isEmpty() ? "myQ is empty" : "myQ is not empty");

		myQ.enqueue("cat");
		myQ.enqueue("bird");
		myQ.enqueue("dog");
		System.out.println(myQ);  // Li H Be H
		myQ.dequeue();
		System.out.println("after one dequeue -" + myQ);
		myQ.dequeue();
		System.out.println("after two dequeue -" + myQ);
		myQ.dequeue();
		System.out.println("after three dequeue -" + myQ);
		
		/* /
		System.out.println(myQ.isEmpty() ? "myQ is empty" : "myQ is not empty");
		System.out.println(myQ.isFull()  ? "myQ is full"  : "myQ is not full");
		System.out.println(myQ.dequeue());  // explicitly test dequeue return value
		System.out.println(myQ);  // H Be H
		myQ.dequeue();
		myQ.dequeue();
		myQ.dequeue();
		System.out.println(myQ);
		System.out.println(myQ.isEmpty() ? "myQ is empty" : "myQ is not empty");
		System.out.println(myQ.isFull()  ? "myQ is full"  : "myQ is not full");
		/**/
	}

}
