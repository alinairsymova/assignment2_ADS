public interface MyList<T> {

    void add(T item); // Adds an element to the end of the list

    void set(int index, T item); // Replaces the element at the specified index with a new one

    void add(int index, T item); // Inserts an element at the specified index

    void addFirst(T item); // Adds an element to the beginning of the list

    void addLast(T item); // Adds an element to the end of the list

    T get(int index); // Retrieves the element at the specified index

    T getFirst(); // Returns the first element in the list

    T getLast(); // Returns the last element in the list

    void remove(int index); // Removes the element at the specified index

    void removeFirst(); // Removes the first element in the list

    void removeLast(); // Removes the last element in the list

    void sort(); // Sorts the list in ascending order

    int indexOf(Object object); // Returns the index of the first occurrence of the given object

    int lastIndexOf(Object object); // Returns the index of the last occurrence of the given object

    boolean exists(Object object); // Checks if the object exists in the list

    Object[] toArray(); // Converts the list to an array

    void clear(); // Removes all elements from the list

    int size(); // Returns the number of elements in the list
}
