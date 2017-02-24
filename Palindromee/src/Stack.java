/*
 * Implement a reference based stack
 */
public class Stack<E> {
	
	private Node<E> top;

	public Stack() {
		this.top = null;
	}
	
	
	/*
	 * places element on the top of the stack
	 */
	public void push(E element){
		Node<E> temp = new Node<E>(element);
		temp.next = top;
		top = temp;
	}
	
	/*
	 * remove the top node and return its contents
	 */
	public E pop(){
		if(top == null){
			return null;
		}
		
		E retval = top.element;
		top = top.next;
		
		return retval;
	}
	
	/*
	 * Look at the top element of the Stack and return it, without removing
	 */
	public E peek(){
		return top.element;
	}
	
	//returns the size of the stack
	public int size(){
		Node<E> current = top;
		int size = 0;
		
		while(current != null){
			current = current.next;
			size++;
		}
		
		return size;
	}

}
