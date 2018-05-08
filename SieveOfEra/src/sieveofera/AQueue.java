/*
 * Copied from Prof. Conrad's Github.
 */
package sieveofera;

public class AQueue<T> implements AQueueInterface<T>
{
	// linked list containing the items in the queue
    private Node<T> head=null, tail=null;
	
	// current number of items in queue
    private int numberOfItems;
	
	// Queue constructor that starts with empty queue.
    public AQueue()
	{
		numberOfItems=0; // no items yet!
	}
	
	// displays current contents of the queue
    public void display()
	{
		Node current=head;
		for(int i=0;i<numberOfItems;i++)
		{
			System.out.print(current.getValue()+" ");
			current=current.getNext();
			if ( current==null ) break;
		}
	}
	
	// ----- functions/methods in the interface that must be implemented -----
	
	// returns true if the queue is empty (no items in queue) 
	// false if queue is (has at least one or more items in queue)
    public boolean isEmpty()
	{
		return numberOfItems==0;
	}
	
	// return the number of items currently in the queue
    public int size()
	{
		return numberOfItems;
	}
 
	// returns the value of the item currently at front of queue
    public T front()
	{
		if ( head==null ) return null;
		return head.getValue(); // return item stored at head node
	}
	
	// returns the value of the item currently at the end of the queue
    public T back()
	{
		if ( tail==null ) return null;
		return tail.getValue(); // return item stored at tail node
	}
	
	// places parameter item onto the end of the queue
    public void push_back(T newItem)
	{
		// if head node is null, make head and tail node contain the first node
		if ( head == null)
		{
			head = new Node(newItem);
			tail=head; // when first item is enqueued, head and tail are the same
			numberOfItems++; // increment the number of items in the queue
		}
		else
		{
			Node<T> newNode = new Node(newItem);
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail=newNode;
			numberOfItems++;
		}
	}
	
    public void enqueue(T newItem) // this is the same concept as push_back
	{
		this.push_back(newItem); // since it's the same as push_back, just call push_back
	}
	
	// returns and removes the current item at the front of the queue
	// the item that is in the queue behind the item becomes the new front item
    public T pop_front()
	{
		T headDataValue = null;
		if ( numberOfItems > 0 )
		{
			headDataValue = head.getValue();
			Node<T> oldHead=head;
			head=head.getNext();
			oldHead.setNext(null);
			oldHead.setPrevious(null);
						
			numberOfItems--;
		}
		return headDataValue;  // returns the data value from the popped head, null if queue empty
	}
	
    public T dequeue() // this is the same concept as pop_front
	{
		return this.pop_front(); // since it's the same as pop_front, just call pop_front
	}
	
	// Node Inner Class
    private class Node<T> {
        private T value;
        private Node _previous, _next;
    
        public Node(T data) {
            value = data;
            _previous = null;
			_next = null;
        }
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
			_next = nextNode;
        }
		
        public Node getNext() {
            return _next;
        }
		
		public Node getPrevious() {
            return _previous;
        }
        
		public void setValue(T newValue)
		{
			value=newValue;
		}

        public T getValue() {
            return value;
        }
    
        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
		public void setPrevious(Node newPreviousNode) {
            _next = newPreviousNode;
        }
    }
}