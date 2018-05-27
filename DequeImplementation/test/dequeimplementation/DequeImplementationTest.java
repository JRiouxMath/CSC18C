/*
 * Jeanine Rioux
 * CSC 18C 5/20/18
 * DequeImplemnetation Test Class
 */
package dequeimplementation;

//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.NullPointerException;

/**
 *
 * @author jrioux
 */
public class DequeImplementationTest {
    
    public DequeImplementationTest() {
    }
    
    

    /**
     * Test of isEmpty method, of class DequeImplementation.
     */
    @Test
    public void testIsEmptyTrue() {
        System.out.println("isEmpty - True");
        DequeImplementation instance = new DequeImplementation();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    @Test
    public void testIsEmptyFalse() {
        System.out.println("isEmpty - False");
        DequeImplementation instance = new DequeImplementation();
        instance.enqueue_front(5);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    /**
     * Test of size method, of class DequeImplementation.
     */
    @Test
    public void testSizeNull() {
        System.out.println("size - null");
        DequeImplementation instance = new DequeImplementation();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSizeNotNull() {
        System.out.println("size - not null");
        DequeImplementation instance = new DequeImplementation(5);
        instance.enqueue_back(3);
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of front method, of class DequeImplementation.
     */
    @Test
    public void testFrontNull() {
        System.out.println("front - Null");
        DequeImplementation instance = new DequeImplementation();
        Object expResult = null;
        Object result = instance.front();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFrontNotNull() {
        System.out.println("front - Not Null");
        DequeImplementation instance = new DequeImplementation(5);
        Object expResult = 5;
        Object result = instance.front();
        assertEquals(expResult, result);
    }

    /**
     * Test of back method, of class DequeImplementation.
     */
    @Test
    public void testBack() {
        System.out.println("back");
        DequeImplementation instance = new DequeImplementation(5);
        instance.enqueue_back(9);
        Object expResult = 9;
        Object result = instance.back();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBack_null() {
        System.out.println("back - null");
        DequeImplementation instance = new DequeImplementation();
        Object expResult = null;
        Object result = instance.back();
        assertEquals(expResult, result);
    }

    /**
     * Test of enqueue_front method, of class DequeImplementation.
     */
    @Test
    public void testEnqueue_front() {
        System.out.println("enqueue_front");
        Object newItem = 5;
        DequeImplementation instance = new DequeImplementation(7);
        instance.enqueue_front(newItem);
        assertEquals(instance.dequeue_front(), newItem);
    }

    /**
     * Test of enqueue_back method, of class DequeImplementation.
     */
    @Test
    public void testEnqueue_back() {
        System.out.println("enqueue_back");
        Object newItem = 5;
        DequeImplementation instance = new DequeImplementation(6);
        instance.enqueue_back(newItem);
        assertEquals(instance.dequeue_back(), newItem);

    }

    /**
     * Test of dequeue_front method, of class DequeImplementation.
     */
    @Test
    public void testDequeue_front() {
        System.out.println("dequeue_front - value");
        DequeImplementation instance = new DequeImplementation(10);
        instance.enqueue_front(9);
        Object expResult = 9;
        Object result = instance.dequeue_front();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testDequeue_front_null() {
        System.out.println("dequeue_front - null");
        DequeImplementation instance = new DequeImplementation();
        Object expResult = null;
        Object result = instance.dequeue_front();
        assertEquals(expResult, result);
    }

    /**
     * Test of dequeue_back method, of class DequeImplementation.
     */
    @Test
    public void testDequeue_back() {
        System.out.println("dequeue_back");
        DequeImplementation instance = new DequeImplementation();
        instance.enqueue_front(10);
        instance.enqueue_front(9);
        Object expResult = 10;
        Object result = instance.dequeue_back();
        assertEquals(expResult, result); 
    }
    
    @Test //(expected = NullPointerException)
    public void testDequeue_back_null() {
        System.out.println("dequeue_back - null");
        DequeImplementation instance = new DequeImplementation();
        Object expResult = null;
        Object result = instance.dequeue_back();
        assertEquals(expResult, result); 
    }

    /**
     * Test of display method, of class DequeImplementation.
     */
    @Test
    public void testDisplay() {
        System.out.println("display");
        DequeImplementation instance = new DequeImplementation(5);
        instance.enqueue_back(6);
        instance.enqueue_front(4);
        String expResult = "4 5 6";
        instance.display();
        System.out.println("Is it: " + expResult);

    }
    
}
