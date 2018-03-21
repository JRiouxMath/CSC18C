/*
 * 
 * Jeanine Rioux
 * CSC 18C 3/20/18
 */
package bags;

public class BagsDemo {

    public static void main(String[] args) {
        Bags<String> bag_of_strings = new Bags<String>(5);
        
        bag_of_strings.add("Hello");
        bag_of_strings.add("World!");
        bag_of_strings.add("Structures1");
        bag_of_strings.add("Data");
        bag_of_strings.add("Structures2");
        bag_of_strings.remove("Structures1");
        
        bag_of_strings.sort();
        
        Bags<Person> persons_bag = new Bags<Person>(9);
        persons_bag.add(new Person("Edsger","Dijkstra"));
        persons_bag.add(new Person("Guido","van Rossum"));
        persons_bag.add(new Person("Paul","Conrad"));
        persons_bag.add(new Person("Bjarn","Stroustrup"));
        persons_bag.add(new Person("Ada","Lovelace"));
        persons_bag.add(new Person("Grace","Hopper"));
        // two persons with same lastname but different firstnames to test
        // update of compareTo when handling persons with same lastnames
        persons_bag.add(new Person("John","Doe"));
        persons_bag.add(new Person("Jane","Doe"));
        persons_bag.add(new Person("Jeanine", "Rioux"));
        
        System.out.println(persons_bag.toString());
        persons_bag.sort();
        System.out.println("Sorted bag of persons:");
        System.out.println(persons_bag.toString());
        System.out.println("\nSize of bag_of_persons=" + persons_bag.getSize() );
        
        System.out.println();
		
        System.out.println("Size of bag_of_strings=" + bag_of_strings.getSize() );
        System.out.println("Contents of bag_of_strings:");
        Object[] a = bag_of_strings.toArray();
        for(int i=0;i<a.length;i++)
        {
            System.out.printf("a[%d]=%s\n",i,a[i]);    
        }// end for loop print bag_of_string
        
        System.out.println();

	Bags<Double> bag_of_doubles = new Bags<Double>(25);
        
	// fill the bag of floats with some floating point values
        for(int i=0;i<50;i++)
	{
            if ( i%3 == 0 ) bag_of_doubles.add( i*2.375 );
            else if ( i%3 == 1 ) bag_of_doubles.add ( -i*1.875 );
            else bag_of_doubles.add( (i%500) / 1.4142 ); 
        }// end for loop to populate bag_of_doubles           
	
        
	bag_of_doubles.sort();
		
        System.out.println("Size of bag_of_doubles=" + bag_of_doubles.getSize() );
        System.out.println("Contents of bag_of_doubles:");
        Object[] ab = bag_of_doubles.toArray();
        for(int i=0;i<ab.length;i++) 
        {
            System.out.printf("ab[%d]=%s\n",i,ab[i]);
        }// end for loop to print bag_of_doubles
    }// end main method
    
}// end class BagDemo