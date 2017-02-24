/*
 * Implement a reference based queue
 */
public class Queue<E> {
	
	private Node<E> front;
	private Node<E> back;

	public Queue() {
		front = null;
		back  = null;
	}
	
	public Queue(E element) {
		front = null;
		back  = null;
		this.enqueue(element);
	}
	
	/*
	 * places element in the back of the Queue
	 */
	public void enqueue(E element){
		Node<E> temp = new Node<E>(element);
		
		if(front == null){
			front = temp;
			back = temp;
			temp.next = null;
		} else {
			back.next = temp;
			back = temp;
		}
	}
	
	/*
	 * remove the front node of the queue and return it
	 */
	public E dequeue(){
		E retval = front.element;
		
		front = front.next;
		
		return retval;
	}
	
	/*
	 * Look at the front of the queue and return it, without removing
	 */
	public E peek(){
		return front.element;
	}
	
	//returns the size of the queue
	public int size(){
		Node<E> current = front;
		int size = 0;
		
		while(current != null){
			current = current.next;
			size++;
		}
		
		return size;
	}
}


