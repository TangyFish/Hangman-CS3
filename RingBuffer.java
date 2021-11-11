package Guitar_Hero;

import java.util.Arrays;
import java.util.NoSuchElementException;

/******************************************************************************
 *  Name:    
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:    
 *  Partner NetID:   
 *  Partner Precept: 
 * 
 *  Description:  
 *
 * This is a template file for RingBuffer.java. It lists the constructors and
 * methods you need, along with descriptions of what they're supposed to do.
 *  
 * Note: it won't compile until you fill in the constructors and methods
 *       (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
	private double[] Buffer;
	private int cap;
	private int first;
	private int last;
	private int elems;
    // YOUR INSTANCE VARIABLES HERE
    // You are creating a circular queue.
    // Look up how to create a cirucular queue using an array.

    //must use and array   []

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        // YOUR CODE HERE

    	Buffer = new double[capacity];
    	cap = capacity;
    	elems = 0;
    	last = 0;
    	first =0;
    	
    }
    
    public RingBuffer(double[] init) {
        // YOUR CODE HERE
    	Buffer = init;
    	cap = init.length;
    	elems = init.length;
    	last = 0;
    	first =0;
    	
    }

    // return the capacity of this ring buffer
    public int capacity() {
        // YOUR CODE HERE
    	return cap;
    	
    }

    // return number of items currently in this ring buffer
    public int size() {
        // YOUR CODE HERE
    	return elems;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        // YOUR CODE HERE
    	return (elems==0);
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        // YOUR CODE HERE
    	return (elems==cap);
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        // YOUR CODE HERE
    	if (elems>=cap) {
    		throw new IllegalStateException() ;
    	}
    	Buffer[last] = x; last = wrap(last);
    	elems++;
    	
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        // YOUR CODE HERE
    	if (elems<=0) {
    		throw new NoSuchElementException() ;
    	}
    	double ret = Buffer[first];
    	Buffer[first] = 0; first = wrap(first);
    	elems--;
    	return ret;
    	
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        // YOUR CODE HERE
    	if (elems<=0) {
    		throw new NoSuchElementException() ;
    	}
    	return Buffer[first];
    }
    
    public int wrap(int a) {
    	if (a+1 >= cap) {
    		return 0;
    	}
    	return (a+1);
    }
    
    public String toString() {
    	
    	
    	double[] out = new double[elems];
    	int indexBuffer = first;
    	int i = 0;
    	if (isEmpty()) {
    		return Arrays.toString(out);
    	}
    	if(first == last) {
    		out[0] = Buffer[first]; 
    		indexBuffer = wrap(indexBuffer);
    		i++;
    	}
    	while(indexBuffer != last) {
    		out[i] = Buffer[indexBuffer];
    		indexBuffer = wrap(indexBuffer);
    		i++;
    	}
    	return Arrays.toString(out);
    	
    }
    

    // tests and calls every instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
    	RingBuffer x = new RingBuffer(12);
    	
    	for(double i = 0; i < 12; i++) {
    		x.enqueue((i /2));
    	}
    	System.out.println(x.toString());
    }
    

}
