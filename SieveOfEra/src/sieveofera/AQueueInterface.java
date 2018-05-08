/*
 * Copied from Prof. Conrad's GitHub
 */
package sieveofera;

/**
 *
 * @author jrioux
 */
public interface AQueueInterface<T> {
    
	// returns true if the queue is empty (no items in queue) 
	// false if queue is not (has at least one or more items in queue)
    public boolean isEmpty();
	
	// return the number of items currently in the queue
    public int size();
 
	// returns the value of the item currently at front of queue
    public T front();
	
	// returns the value of the item currently at the end of the queue
    public T back();
	
	// places parameter newItem onto the end of the queue
	// // (this is synonymous to the enqueue method)
    public void push_back(T newItem);
	
	// places parameter newItem onto the end of the queue
	// (this is synonymous to the push_back method)
    public void enqueue(T newItem);
	
	// returns and removes the current item at the front of the queue
	// the item that is in the queue behind the item becomes the new front item
    public T pop_front();
	
	// returns and removes the current item at the front of the queue
	// (this is synonymous to the pop_front method)
    public T dequeue();
}