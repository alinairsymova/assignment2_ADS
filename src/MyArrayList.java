public class MyArrayList <T> implements MyList <T> {
    private Object[] elements; // Array to store the elements
    private int size; // Number of elements in the list

    // Constructor: Initializes the array with a default size of 10
    public MyArrayList() {
        elements = new Object[10];
    }

    // Inner interface for iteration over the list
    public interface MyIterator<T> {
        boolean hasNext(); // Checks if there is another element to iterate over
        T next(); // Returns the next element
    }

    // Adds an element to the end of the list. Expands the array if necessary.
    @Override
    public void add(T item) {
        if (size == elements.length) {
            // Double the size of the array if it's full
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = (T) elements[i];
            }
            elements = newElements;
        }
        elements[size] = item; // Add the new item
        size++; // Increment size
    }

    // Sets the value of an element at the specified index
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(); // Ensure index is within valid range
        elements[index] = item; // Set the item at the specified index
    }

    // Adds an element at a specific index and shifts elements to the right
    @Override
    public void add(int index, T item) {
        // Shift elements from index onwards to the right
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = item; // Insert the new item
        size++; // Increment size
    }

    // Adds an element to the beginning of the list
    @Override
    public void addFirst(T item) {
        add(0, item); // Uses the add method to insert at index 0
    }

    // Adds an element to the end of the list
    @Override
    public void addLast(T item) {
        add(size, item); // Uses the add method to insert at the last index
    }

    // Retrieves the element at the specified index
    @Override
    public T get(int index) {
        return (T) elements[index]; // Return the element at the specified index
    }

    // Retrieves the first element in the list
    @Override
    public T getFirst() {
        return (T) elements[0]; // Return the first element
    }

    // Retrieves the last element in the list
    @Override
    public T getLast() {
        return (T) elements[size - 1]; // Return the last element
    }

    // Removes the element at the specified index and shifts remaining elements to the left
    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1]; // Shift elements left
        }
        size--; // Decrease size
    }

    // Removes the first element from the list
    @Override
    public void removeFirst() {
        remove(0); // Uses the remove method to remove the first element
    }

    // Removes the last element from the list
    @Override
    public void removeLast() {
        remove(size - 1); // Uses the remove method to remove the last element
    }

    // Sorts the elements in the list using bubble sort
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> current = (Comparable<T>) elements[j];
                if (current.compareTo((T) elements[j + 1]) > 0) {
                    // Swap elements if they're in the wrong order
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    // Returns the index of the first occurrence of the specified object, or -1 if not found
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i; // Found the object, return its index
            }
        }
        return -1; // Object not found
    }

    // Returns the index of the last occurrence of the specified object, or -1 if not found
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i; // Found the object, return its index
            }
        }
        return -1; // Object not found
    }

    // Returns true if the object exists in the list, otherwise false
    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return true; // Object exists
            }
        }
        return false; // Object does not exist
    }

    // Converts the list to an array of objects
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i]; // Copy elements to the array
        }
        return array; // Return the array
    }

    // Clears the list by resetting the array and size
    @Override
    public void clear() {
        elements = new Object[10]; // Reinitialize the array with default size
        size = 0; // Reset the size
    }

    // Returns the number of elements in the list
    @Override
    public int size() {
        return size; // Return the current size
    }

    // Creates and returns an iterator for the list
    public MyIterator<T> iterator() {
        return new MyArrayListIterator(); // Return a new iterator
    }

    // Inner iterator class to iterate through the list
    private class MyArrayListIterator implements MyIterator<T> {
        private int current = 0; // Keep track of the current position

        // Returns true if there is another element to iterate
        @Override
        public boolean hasNext() {
            return current < size; // Check if there's a next element
        }

        // Returns the next element in the iteration
        @Override
        public T next() {
            return (T) elements[current++]; // Return the current element and move to the next
        }
    }

    // Custom string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("["); // Start with an opening bracket
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]); // Append each element
            if (i < size - 1) sb.append(", "); // Add a comma between elements
        }
        sb.append("]"); // Close with a closing bracket
        return sb.toString(); // Return the string representation
    }
}
