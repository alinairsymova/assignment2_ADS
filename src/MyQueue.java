public class MyQueue<T> {

    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Enqueues an item to the queue (adds it to the end of the list)
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Dequeues an item from the queue (removes the item at the front of the list)
    public T dequeue() {
        if (list.size() == 0) throw new IndexOutOfBoundsException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    // Peeks at the front item of the queue without removing it
    public T peek() {
        if (list.size() == 0) throw new IndexOutOfBoundsException("Queue is empty");
        return list.getFirst();
    }

    // Returns the size of the queue (number of items in the list)
    public int size() {
        return list.size();
    }

    // Checks if the queue is empty (if the list size is 0)
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
