public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void add(T item) {
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    public T remove() {
        if (heap.size() == 0) throw new IndexOutOfBoundsException("Heap is empty");
        T root = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            siftDown(0);
        }
        return root;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int leftChild;
        int rightChild;
        int smallest;

        while ((leftChild = 2 * index + 1) < heap.size()) {
            rightChild = leftChild + 1;
            smallest = leftChild;

            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                smallest = rightChild;
            }

            if (heap.get(index).compareTo(heap.get(smallest)) <= 0) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}