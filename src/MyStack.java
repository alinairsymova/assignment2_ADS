public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (list.size() == 0) throw new IndexOutOfBoundsException();
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (list.size() == 0) throw new IndexOutOfBoundsException();
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
