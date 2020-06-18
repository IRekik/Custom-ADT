import java.util.*;

public class SeqList <E> {
	// Inner Node class
	private class Node {
		// Three attributes: previous, next and the element
		Node previous;
		Node next;
		E element;
		
		private Node (E el, Node prev, Node nt) {
			element=el;
			previous=prev;
			next=nt;
		}
	}
	public SeqList (){
		size=0;
		head = null;
		tail = null;
	}
	// Three attributes: the size of the list, the element at the head and the tail element
	private int size;
	private Node tail;
	private Node head;
	
	public boolean isEmpty() {
		boolean nyess= (size == 0);
		return nyess;
	}
	
	// Getters 
	public E getHead() {
		return head.element;
	}
	public E getTail() {
		return tail.element;
	}
	
	// Method to return the size of the list
	public int size() {
		return size;
	}
	
	// Methods to add an element to the List
	public void addLast (E el)
	{
		Node temp = new Node(el, null, tail);
		// if statement to check if the tail is not null (empty) and the opposite of the head
		if (tail != null) {
			tail.next=temp;
		}
		if (head == null) {
			head = temp;
		}
		tail=temp;
		size++;
		System.out.println("Program added the element "+ el);
	}
	public void addFirst(E el) {
		Node temp = new Node(el, head,tail);
		if (head != null) {
			head.previous=temp;
		}
		if (tail == null) {
			head=temp;
		}
		tail=temp;
		size++;
		System.out.println("Prgram added the element "+el);
	}
	// Methods to remove elements
	public E removeFirst() {
		// save the head
		Node temp= head;
		head.previous=null;
		head = head.next;
		// Variable that will store the deleted element
		E deleted = temp.element;
		System.out.println("Program deleted the element "+ deleted);
		return deleted;
	}
	public E removeLast() {
		Node temp=tail;
		tail.next=null;
		head=head.next;
		E deleted =temp.element;
		System.out.println("Program deleted the element "+ deleted);
		return deleted;
	}
	// Methods to iterate forward (from head to tail) and backward (from tail to head)
	public void iterateBackward() {
		Node temp = tail;
		// While loop to iterate from the tail to the head
		while (temp != null) {
			System.out.println(temp.element);
			temp=temp.previous;
		}
	}
	public void iterateForward() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.element);
			temp=temp.next;
		}
	}
	// Method to remove a specific element. Calls the find method and remove it
	public void remove (E el) {
		if (this.contains(el)) {
			Node temp=find(el);
			Node previousTemp=temp.previous;
			Node nextTemp=temp.next;
			temp.next.previous=previousTemp;
			temp.previous.next=nextTemp;
			temp.next=null;
			temp.previous=null;
			size--;
		}
	}
	// Contains method that checks if it contains a specific element
	public boolean contains (E el) {
		Node temp = head;
		boolean doesContains = false;
		// While loop that will execute until the element is found
		while (temp.element != null) {
			if (temp.element == el) {
				doesContains=true;
				break;
			}
			temp=temp.next;
		}
		if (!doesContains) {
			System.out.println("Element not found");
		}
		return doesContains;
	}
	// Find method to search for a specific item
	public Node find (E element) {
		Node analyzedPosition = head;
		boolean isFound = false;
		int counter = 0;
		// While loop that will go through each node until it finds the right element
		while (analyzedPosition != null) {
			counter++;
			analyzedPosition=analyzedPosition.next;
			if (analyzedPosition.element == element) {
				isFound=true;
				break;
			}
		}
		// If element has been found
		if (isFound) {
			System.out.println("The program moved "+counter+ " times starting from the head position to obtain that ID");
		}
		else {
			System.out.println("No ID has been found");
			return null;
		}
		return analyzedPosition;
	}
	public Node findI(int index) {
		Node position = head;
		int counter=0;
		boolean isFound = false;
		while (position != null) {
			counter++;
			position=position.next;
			if (counter == index) {
				isFound=true;
				break;
			}
		}
		if (isFound) {
			System.out.println("The program moved "+counter+" times starting from the head to obtain this ID");
		}
		else {
			System.out.println("No ID has been found");
		}
		return null;
	}
	public int indexOf (E el) {
		Node temp = head;
		int counter = 0;
		try {	
			while (temp.element  != el) {
				temp=temp.next;
				counter++;
			}
			System.out.println("Program found the element at index "+counter);
			return counter;
		}
		catch (Exception e) {
			System.out.println("Nothing has been found");
		}
		return 0;
	}
	public E atIndex(int i) {
    	Node temp = head;
    	int counter=0;
    	try {
    		while(temp != null) {
    			temp = temp.next;
    			counter++;
    			if(i==counter) {
    				break;
    			}
    		}
    		if (counter==i) {
    			return temp.element;
    		}
    	}
    	catch(Exception e) {
    		System.out.println("Unable to find anything at this index");
    	}
    	return null;
    }
}
