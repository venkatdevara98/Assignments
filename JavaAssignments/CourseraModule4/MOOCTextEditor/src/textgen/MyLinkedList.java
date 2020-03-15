package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head=null;
		tail=null;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) throws NullPointerException
	{
		LLNode<E> newNode=new LLNode<>(element);
		size+=1;
		if(head==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			tail=newNode;
		}
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		LLNode<E> iter=head;
		if(index>size-1||index<0)
			throw new IndexOutOfBoundsException();
		while(index!=0) {
			iter=iter.next;
			index--;
		}
		return iter.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		LLNode<E> iter=head;
		LLNode<E> newNode=new LLNode<>(element);
		size+=1;
		if(index==0){
			newNode.next=head;
			head=newNode;
			return;
		}
        while(index-1!=-1) {
        	iter=iter.next;
        	index--;
        }
        newNode.next=iter.next;
        iter.next=newNode;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		E data;
		if(index>size-1)
			throw new IndexOutOfBoundsException();
		if(index==0) {
			data=head.data;
			head=head.next;
			size-=1;
			return data;
		}
		LLNode<E> iter=head;
		while(index-1!=-1) {
			iter=iter.next;
			index--;
		}
		data=iter.next.data;
		iter.next=iter.next.next;
		size-=1;
		return data;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException
	{
		E oldData;
		if(index>size-1)
			throw new IndexOutOfBoundsException();
		LLNode<E> iter=head;
		while(index>0) {
			iter=iter.next;
		}
		oldData=iter.data;
		iter.data=element;
		return oldData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
