/*
 * Jeanine Rioux
 * CSC 18C  5/7/18
 * Extra Credit Queue Assignment: Sieve of Eratosthenes
 * Must use Prof's Queue class.
*/
package sieveofera;
import java.util.Scanner;

public class SieveOfEra {

   
    public static void main(String[] args) {
        int hiNum;
        int p;
        boolean flag = false;
        AQueue<Integer> queueOfIntegers = new AQueue<>();
        AQueue<Integer> queueOfPrimes = new AQueue<>(); //2) Empty Queue to hold primes
        
        Scanner kb= new Scanner(System.in);
        System.out.println("Enter a number to be the upper limit:");
        hiNum = kb.nextInt();
        
        // 1) Enqueues integers from 2 to hiNum into queueOfIntegers
        for (int i = 2; i<=hiNum; i++)
        {
            queueOfIntegers.enqueue(i);
            
        }// end enqueueing for loop
        
        //3) Do-While last node is < SQRT(hiNum)
        do
        {
            //4&5) Get next prime from QofInt, put in QofP
            p = queueOfIntegers.front();
            queueOfPrimes.enqueue(p);
            
            queueOfIntegers.enqueue(queueOfIntegers.dequeue());
            do 
            {
                
               if (queueOfIntegers.front()==p)
               {    
                   queueOfIntegers.dequeue();
                   flag = true;
               }// end if to check if have looped through queue
               else if (queueOfIntegers.front()%p==0) 
               {
                   queueOfIntegers.dequeue();
               }// end elseif when front is multiple of p
               else
                   queueOfIntegers.enqueue(queueOfIntegers.dequeue());
           
            
                   
            }while (flag==false);//shift ints up in queue
            flag = false;
            
            
        }while (queueOfIntegers.front()< (Math.sqrt(hiNum)+1)); //9) while to close do/while
        
        while(!queueOfIntegers.isEmpty())
            queueOfPrimes.enqueue(queueOfIntegers.dequeue());
        
        System.out.println("\nFinal list of Primes:");
            queueOfPrimes.display();
       
    }
    
}
