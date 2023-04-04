package Exercise8;

/**
 * A first-in, first-out bounded collection of MessageQueues.
 */
public class MessageQueue<T> {
    private T[] elements;
    private int head;
    private int tail;
    private int count;

    /**
     * Constructs an empty MessageQueue queue with the specified capacity.
     * 
     * @param capacity the maximum capacity of the queue
     * @precondition capacity > 0
     */
    public MessageQueue(int capacity) {
        elements = (T[]) new Object[capacity];
        count = 0;
        head = 0;
        tail = 0;
    }

    /**
     * Removes and returns the MessageQueueQueue at the head of the queue.
     * 
     * @return the MessageQueueQueue that has been removed from the queue
     * @precondition size() > 0
     */
    public T remove() {
        assert size() > 0 : "Queue is empty";
        T r = elements[head];
        elements[head] = null; // Avoid memory leaks
        head = (head + 1) % elements.length;
        count--;
        return r;
    }

    /**
     * Appends a MessageQueue to the tail of the queue.
     * 
     * @param aMessageQueue the MessageQueue to be appended
     * @precondition !isFull()
     */
    public void add(T aMessageQueue) {
        assert !isFull() : "Queue is full";
        if (count == elements.length) {
            // Double the size of the elements array
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < count; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = count;
        }
        elements[tail] = aMessageQueue;
        tail = (tail + 1) % elements.length;
        count++;
    }

    /**
     * Returns the total number of MessageQueues in the queue.
     * 
     * @return the total number of MessageQueues in the queue
     */
    public int size() {
        return count;
    }

    /**
     * Checks whether this queue is full.
     * 
     * @return true if the queue is full
     */
    public boolean isFull() {
        return count == elements.length;
    }

    /**
     * Returns the MessageQueue at the head of the queue without removing it.
     * 
     * @return the MessageQueue that is at the head of the queue
     * @precondition size() > 0
     */
    public T peek() {
        assert size() > 0 : "Queue is empty";
        return elements[head];
    }

    public static void main(String[] args) {
        MessageQueue<Integer> m = new MessageQueue<Integer>(10);
        for (int i = 0; i < 100; i++) {
            m.add(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(m.remove());
        }
    }

}
