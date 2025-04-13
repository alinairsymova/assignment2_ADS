public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Adds an element to the heap and maintains the heap property
    public void add(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    // Removes the root (minimum element) from the heap and returns it
    public T remove() {
        if (heap.size() == 0) throw new IndexOutOfBoundsException("Heap is empty");

        T root = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, last);
            siftDown(0); // Restore the heap property by sifting down the root
        }

        return root;
    }

    // Ensures the heap property is maintained after adding an element
    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            // Swap the element with its parent if it's smaller
            swap(index, parent);
            index = parent;
        }
    }

    // Ensures the heap property is maintained after removing the root
    private void siftDown(int index) {
        int leftChild;
        int rightChild;
        int smallest;

        while ((leftChild = 2 * index + 1) < heap.size()) {
            rightChild = leftChild + 1;
            smallest = leftChild;

            // If the right child exists and is smaller than the left child, choose the right child
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                smallest = rightChild;
            }

            // If the current element is smaller than or equal to the smallest child, heap property is restored
            if (heap.get(index).compareTo(heap.get(smallest)) <= 0) break;

            // Swap the element with the smallest child
            swap(index, smallest);
            index = smallest;
        }
    }

    // Swaps two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Returns the size of the heap
    public int size() {
        return heap.size();
    }

    // Checks if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }
}
