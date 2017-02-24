import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E> {

	
	
	// Your variables
	// You can include a reference to a tail if you want
	Node<E> head;
	Node<E> tail;
	int size;  // BE SURE TO KEEP TRACK OF THE SIZE

	
	// implement this constructor
	public CircularLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public CircularLinkedList(E item) {
		head = new Node<E>(item);		
		tail= head;
		head.next = tail;
		size = 1;
	}
	
	// writing helper functions for add and remove, like the book did can help
	// but remember, the last element's next node will be the head!



	// attach a node to the end of the list
	// Be sure to handle the adding to an empty list
	// always returns true 
	public boolean add(E e) {
		this.add(size, e);
		return true;
	}

	
	// need to handle
	// out of bounds
	// empty list
	// adding to front
	// adding to middle
	// adding to "end"
	// REMEMBER TO INCREMENT THE SIZE
	public boolean add(int index, E e){
		if(this.size == 0){
			head = new Node<E>(e);
			tail = head;
			head.next = tail;
		} else if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		} else if(index == size) {
			tail.next = new Node<E>(e);
			tail = tail.next;
			tail.next = head;
		} else {
			int i = 0;
			Node<E> temp = head;
			
			while(i < index -1){
				temp = temp.next;
				i++;
			}
			
			Node<E> add = new Node<E>(e);
			add.next = temp.next;
			temp.next = add;
		}
		size++;
		return true;
	}

	// I highly recommend using this helper method
	// Return Node<E> found at the specified index
	// be sure to handle out of bounds cases
	private Node<E> getNode(int index ) {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		} else {
			Node<E> temp = head;
			int i = 0;
			while(i < index){
				temp = temp.next;
				i++;
			}
			return temp;
		}
	}

	
	
	// remove must handle the following cases
	// out of bounds
	// removing the only thing in the list
	// removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
	// removing the last thing (if you have a tail)
	// removing any other node.
	// REMEMBER TO DECREMENT THE SIZE
	public E remove(int index) {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		} else if(index == size-1) {
			Node<E> temp = this.getNode(index-1);
			temp.next = head;
			tail = temp;
		} else if(this.size == 1){
			head = null;
			tail = null;
		} else if(index == 0){
			tail.next = head.next;
			head = tail.next;
		} else {
			Node<E> temp = this.getNode(index-1);
			temp.next = temp.next.next;
		}
		size--;
		return null;
	}
	
	
	
	
	// Turns your list into a string
	// Useful for debugging
	public String toString(){
		Node<E> current =  head;
		StringBuilder result = new StringBuilder();
		if(size == 0){
			return "";
		}
		if(size == 1) {
			return head.getElement().toString();
			
		}
		else{
			do{
				result.append(current.getElement());
				result.append(" ==> ");
				current = current.next;
			} while(current != head);
		}
		return result.toString();
	}
	
	
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}
	
	// provided code
	// read the comments to figure out how this works and see how to use it
	// you should not have to change this
	// change at your own risk!
	private class ListIterator<E> implements Iterator<E>{
		
		Node<E> nextItem;
		Node<E> prev;
		int index;
		
		@SuppressWarnings("unchecked")
		//Creates a new iterator that starts at the head of the list
		public ListIterator(){
			nextItem = (Node<E>) head;
			index = 0;
		}

		// returns true if there is a next node
		// this is always should return true if the list has something in it
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size != 0;
		}
		
		// advances the iterator to the next item
		// handles wrapping around back to the head automatically for you
		public E next() {
			// TODO Auto-generated method stub
			prev =  nextItem;
			nextItem = nextItem.next;
			index =  (index + 1) % size;
			return prev.getElement();
	
		}
		
		// removed the last node was visited by the .next() call 
		// for example if we had just created a iterator
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		public void remove() {
			int target;
			if(nextItem == head) {
				target = size - 1;
			} else{ 
				target = index - 1;
				index--;
			}
			CircularLinkedList.this.remove(target); //calls the above class
		}
		
	}
	
	
	// Solve the problem in the main method
	// The answer of n = 13,  k = 2 is 
	// the 11th person in the ring (index 10)
	public static void main(String[] args){
		CircularLinkedList<Integer> list =  new CircularLinkedList<Integer>();
		int n = 11;
		int k = 2;
		
		int i = 1;
		while(i <= n){
			list.add(i);
			i++;
		}
		System.out.println(list);
		
		// use the iterator to iterate around the list
		Iterator<Integer> iter = list.iterator();
		
		while(list.size > 1){
			i = 0;
			while(i<k){
				iter.next();
				i++;
			}
			iter.remove();
			System.out.println(list);
		}
	}



	
}