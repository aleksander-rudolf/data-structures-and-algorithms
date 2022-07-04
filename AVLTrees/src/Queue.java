/*
 * Information from https://www.techiedelight.com/queue-implementation-in-java/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class.
 */

public class Queue {

    private Node[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
 
    /**
     * Constructor
     * @param size
     */
    Queue(int size) {
        arr = new Node[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    /**
     * Dequeue the front element
     * @return Node
     */
    public Node dequeue() {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        Node x = arr[front];
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
 
    /**
     * Add an item to the queue
     * @param item
     */
    public void enqueue(Node item) {
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
