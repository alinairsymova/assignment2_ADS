public class MyStack<T> {
    private MyArrayList<T> list; // Internal list to hold stack elements

    // Constructor to initialize an empty stack
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Pushes an item onto the stack (adds it to the end of the list)
    public void push(T item) {
        list.addLast(item);
    }

    // Pops an item from the stack (removes the item at the end of the list)
    public T pop() {
        if (list.size() == 0) throw new IndexOutOfBoundsException();
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    // Peeks at the top item of the stack without removing it
    public T peek() {
        if (list.size() == 0) throw new IndexOutOfBoundsException(); // Check if the stack is empty
        return list.getLast();
    }

    // Returns the size of the stack (number of items in the list)
    public int size() {
        return list.size();
    }

    // Checks if the stack is empty (if the list size is 0)
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
