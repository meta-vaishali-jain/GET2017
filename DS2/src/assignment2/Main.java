package assignment2;

public class Main {
	public static void main(String args[]){
		UserDefinedQueue<Integer> queue=new UserDefinedQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(10);
		queue.enqueue(20);
		System.out.println(queue.getFront());
		queue.makeEmpty();
		System.out.println(queue.getFront());
		
		
	}
}
