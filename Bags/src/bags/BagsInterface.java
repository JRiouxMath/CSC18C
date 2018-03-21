/*
 * Jeanine Rioux
 * CSC 18C 3/20/18
 */
package bags;

public interface BagsInterface<T> {
    // return the current size of the bag, or the number of elements in the bag
    public int getSize();
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isEmpty();
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isFull();
    
    // add item to bag, returns true if successful, false if not
    public boolean add(T item);
    
    // returns true if item is removed from bag
    public boolean remove(T item);
    
    // clear the bag of all items
    public void clear();
    
    // returns true if item found in bag
    public boolean contains(T item);
    
    // returns array of items in bag
    public T[] toArray();

    // resize the array - left as an assignment
    public void resize();
	
    // sorts the bag from smallest to largest value - left as an assignment
    public void sort();
}