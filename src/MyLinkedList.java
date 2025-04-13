public class MyLinkedList<T> implements MyList<T> {
    // Internal class representing a node in the linked list
    private class MyNode {
        T data; // Node's data
        MyNode next; // Reference to the next node
        MyNode prev; // Reference to the previous node

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head; // First node of the list
    private MyNode tail; // Last node of the list
    private int size; // Size of the list

    // Adds an item to the end of the list
    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Sets the element at the specified index
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }

    // Adds an element at the specified index
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (size == 0) tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            MyNode previous = current.prev;
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }

        size++;
    }

    // Adds an element to the beginning of the list
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Adds an element to the end of the list
    @Override
    public void addLast(T item) {
        add(size, item);
    }

    // Gets the element at the specified index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    // Gets the first element in the list
    @Override
    public T getFirst() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return head.data;
    }

    // Gets the last element in the list
    @Override
    public T getLast() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return tail.data;
    }

    // Removes the element at the specified index
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    // Removes the first element in the list
    @Override
    public void removeFirst() {
        if (size == 0) throw new IndexOutOfBoundsException();
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    // Removes the last element in the list
    @Override
    public void removeLast() {
        if (size == 0) throw new IndexOutOfBoundsException();
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    // Sorts the list using insertion sort
    @Override
    public void sort() {
        if (size <= 1) return;

        MyNode current = head.next;

        while (current != null) {
            T key = current.data;
            MyNode prev = current.prev;
            while (prev != null && ((Comparable<T>) prev.data).compareTo(key) > 0) {
                prev.next.data = prev.data;
                prev = prev.prev;
            }
            if (prev == null) {
                head.data = key;
            } else {
                prev.next.data = key;
            }
            current = current.next;
        }
    }

    // Finds the index of the first occurrence of an object
    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // Finds the index of the last occurrence of an object
    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    // Checks if an object exists in the list
    @Override
    public boolean exists(Object object) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(object)) return true;
            current = current.next;
        }
        return false;
    }

    // Converts the list to an array
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    // Clears the list
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the size of the list
    @Override
    public int size() {
        return size;
    }

    // Returns a string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyNode current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}