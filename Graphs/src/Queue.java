/*
 * Information from https://www.techiedelight.com/queue-implementation-in-java/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

public class Queue {
	
    private int[] arr;      //Array to store queue elements
    private int front;      //Front points to the front element in the queue
    private int rear;       //Rear points to the last element in the queue
    private int capacity;   //Maximum capacity of the queue
    private int count;      //Current size of the queue
 
    /**
     * Constructor
     * @param size
     */
    Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    /**
     * Dequeue the front element
     * @return Node
     */
    public int dequeue() {
    	
        //Check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        int x = arr[front];
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
 
    /**
     * Add an item to the queue
     * @param item
     */
    public void enqueue(int  item) {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    /**
     * Gets the size of the queue
     * @return int
     */
    public int getSize() {
        return count;
    }
 
    /**
     * Check if the queue is empty or not
     * @return boolean
     */
    public boolean isEmpty() {
        return (getSize() == 0);
    }
 
    /**
     * Check if the queue is full or not
     * @return boolean
     */
    public boolean isFull() {
        return (getSize() == capacity);
    }
}

