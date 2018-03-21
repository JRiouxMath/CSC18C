/*
 * Programmer Name:  Jeanine Rioux
    Assignment Start: 3/20/28 (6:40)
    Assignment Completion:
    Total Hours for Assignment:
    Comments:
 */
package bags;

public final class Bags<T extends Object & Comparable> implements BagsInterface<T> {
    private T[] bag_items;
    private int num_items;
    
    public Bags() {
        bag_items = (T[])new Object[10]; // default 10 item bag
        this.num_items=0;
    }
    
    public Bags(int startSize)
    {
        bag_items = (T[])new Object[startSize];
        this.num_items=0;
    }
    
    // return the current size of the bag, or the number of elements in the bag
    public int getSize(){
        return this.num_items;
    }
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isEmpty() {
        return this.num_items == 0;
    }
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isFull() {
        return this.num_items == this.bag_items.length;
    }
    
    // add item to bag, returns true if successful, false if not
    public boolean add(T item) {
        if ( this.isFull() )
           resize();//return false; // cannot add more items
        bag_items[num_items++] = item;
        return true;
    }
    
    // returns true if item is removed from bag
    public boolean remove(T item) {
        if ( this.isEmpty() ) return false;
        for(int i=0;i<this.num_items;i++)
        {
            if ( this.bag_items[i]==item )
            {
                for(int j=i+1;j<this.num_items;j++)
                    this.bag_items[j-1]=this.bag_items[j];
                this.num_items--;
                return true;
            }
        }
        return false;
    }
    
    // clear the bag of all items
    public void clear()
    {
        this.num_items=0; // just reset numberOfEntries to zero and overwrite old data when we add new data
    }
    
    // returns true if item found in bag
    public boolean contains(T item) {
        for(int i=0;i<this.num_items;i++) if ( bag_items[i]==item ) return true;
        return false;
    }
    
    public T[] toArray() {
        T[] arr = (T[])new Object[this.num_items];
        for(int i=0;i<this.num_items;i++) arr[i]=this.bag_items[i];
        return arr;
    }            
    
    @Override 
    public String toString()
    {
        String out="{";
        for(int i=0;i<this.num_items-1;i++)
        {
            out = out + "{"+bag_items[i].toString()+"}, ";
        }
        out = out + "{"+bag_items[num_items-1]+"}}";
        return out;
    }// end toString
    
    public void resize()
    {
        int baglength = bag_items.length;
        baglength *=2;
        T[] temp_bag_items = (T[])new Object[baglength]; 
        for (int i = 0; i< bag_items.length; i++)
        {
            System.arraycopy(bag_items, i, temp_bag_items,i, 1);
        }// end for loop copying to temp
        
        bag_items = temp_bag_items;
        
        
        //return true;
    } // end method resize
    
    private void helper(T a[], int k, int n)
    {
        while ( k*2 + 1 < n ) { 
                    int child = 2*k + 1;    

                    if ((child + 1 < n) && (a[child].compareTo(a[child+1]))< 0) child++;        

                    if (a[k].compareTo(a[child]) < 0) {
                            //swap( a[child], a[k] );
                            T temp = a[child];
                            a[child] = a[k];
                            a[k] = temp;
                            k = child;  
                    }        
                    else            
                            return;    
            }
    }

    public void sort()
    {
            int N = this.num_items;

            for (int i = N/2; i >= 0; i--) { 
                    helper( bag_items, i, this.num_items);    
            }     

            while (N-1 > 0) {  
                    T temp = bag_items[N-1];
                    bag_items[N-1] = bag_items[0];
                    bag_items[0] = temp;
                    helper(bag_items, 0, N-1);
                    N--;
            }

    }
}
