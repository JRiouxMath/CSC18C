/*
 * Jeanine Rioux
 * CSC 18C  5/14/18 30 min
 * 5/19/18 1hour
 * 5/20/18 2.5 hours
 * Total time on project (4 hours)
 * Using the provided Deque Interface, Create a Deque class
 * and demonstrate functionality with a driver.
 */
package dequeimplementation;


public class DequeImplementation<T> implements DequeInterface<T>{
    
    
    private Node<T> head=null, tail=null;

    private int NumOfItems;

    // Queue constructor that starts with empty queue.
    public DequeImplementation()
    {
        NumOfItems = 0; // constructed empty
    }// end of default constructor.
    
    public DequeImplementation(T newItem)
    {
        Node<T> firstNode = new Node(newItem);
        head = firstNode;
        tail = firstNode;
        NumOfItems = 1;
    }// end constructor

    // returns true if the deque is empty (no items in deque) 
    // false if deque is (has at least one or more items in deque)
    public boolean isEmpty()
    {
        if (head == null)
                return true;
        else 
            return false;
    }
	
    // return the number of items currently in the deque
    public int size()
    {
        return NumOfItems;
    }// end method size to return size of deque
 
    // returns the value of the item currently at front of deque
    public T front()
    {
        if (head == null)
            return null;
        
        return head.getValue();
    }// end method front
	
    // returns the value of the item currently at the end of the deque
    public T back()
    {
        if (tail == null)
            return null;
        return tail.getValue();
    } // end method back
	
    // places parameter newItem onto the front of the deque
    public void enqueue_front(T newItem)
    {
        Node<T> newNode = new Node(newItem);
        if (head == null)
        {
            head = newNode;
            tail = head;
           
        }// end if head==null
        else
        {
            head.setPrevious(newNode);
            newNode.setNext(head);
            head = newNode;
        }// end else head !=null 
        
         NumOfItems++;
           
    }//end method enqueue_front

    // places parameter newItem onto the end of the deque
    public void enqueue_back(T newItem)
    {
        Node<T> newNode = new Node(newItem);
        if (head == null)
        {
            head = newNode;
            tail = head;
            
        }// end if head==null
        else
        {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }// end else head !=null
        NumOfItems++;
    }// end method enqueue_back

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T dequeue_front()
    {
        T FValue = null;
        
       if (head == null)
       {
           return FValue;
       }// end ret null
       else
       {
           FValue = head.getValue();
           Node<T> oldHead = head;
           head = head.getNext();
           oldHead.setNext(null);
           oldHead.setPrevious(null);
           
           NumOfItems--;
           return FValue;
       }// end else - remove value
               
    }//

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T dequeue_back()
    {
        T BValue = null;
        
       if (tail == null)
       {
           return BValue;
       }// end ret null
       else
       {
           BValue = tail.getValue();
           Node<T> oldTail = tail;
           tail = tail.getNext();
           oldTail.setNext(null);
           oldTail.setPrevious(null);
           
           NumOfItems--;
           return BValue;
       }// end e
    }// end method dequeue_back
    // display all of the contents in the deque from front to back
    public void display()
    {
        Node current = head;
        if (current != null)
        {
            for (int i = 0; i<NumOfItems; i++)
            {
                System.out.print(current.getValue() + " ");
                current = current.getNext();
            }// end for - display
        }//end if validation
        
    }// end method display
    
    private class Node<T> {
        private T value;
        private Node _previous, _next;
    
        public Node(T data) {
            value = data;
            _previous = null;
			_next = null;
        }// end Node constructor
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
            _next = nextNode;
        }// end node constructor

        public Node getNext() {
            return _next;
        }// end getNext

        public Node getPrevious() {
            return _previous;
        }//end getPrev

        public void setValue(T newValue)
        {
            value=newValue;
        }// end SetValue

        public T getValue() {
            return value;
        }// end getValue

        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }// end setNext

        public void setPrevious(Node newPreviousNode) {
            _next = newPreviousNode;
        }//end Node method setPrev
    }// end inner class Node
    
}//end class Deque implementation
