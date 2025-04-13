public abstract class MyArrayList <T>  implements MyList <T> {
    private Object[] elements;
    private int size;

        public MyArrayList() {
        elements = new Object[10];
    }

    public interface MyIterator<T> {
        boolean hasNext();
        T next();
    }


    @Override
    public void add(T item) {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = (T) elements[i];
            }
            elements = newElements;
        }

        elements[size] = item;
        size++;
    }


    @Override
    public void set (int index, T item) {
        if ( index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        elements[index]=item;
    }

    @Override
    public void add (int index, T item) {
      for (int i= size - 1; i >= index; i--) {
          elements [i+1] = elements[i];
          }
        elements[index] = item;
      size++;
    }

    @Override
    public void addFirst (T item) {
        add (0, item);
    }

    @Override
    public void addLast (T item) {
        add(size, item);
    }

    @Override
    public T get (int index) {
        return (T) elements[index];
    }

    @Override
    public T getFirst () {
        return (T) elements [0];
    }

    @Override
    public T getLast () {
        return (T) elements [size - 1];
    }

    @Override
    public void remove (int index){
        for ( int i = index; i < size ; i ++)
            elements [i] = elements [i+1];
        size--;
    }

    @Override
    public void removeFirst () {
         remove(0);
    }

    @Override
    public void removeLast () {
        remove(size - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> current = (Comparable<T>) elements[j];
                if (current.compareTo((T) elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf (Object object) {
        for (int i = size -1 ; i >= 0; i--)
            if (elements[i].equals(object)){
                return i;
            }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }


    @Override
    public void clear () {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public int size () {
        return size;
    }

    public MyIterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements MyIterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            return (T) elements[current++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


}
