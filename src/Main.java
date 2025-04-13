public class Main {
    private static MyArrayList<Integer> list;

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>() {};
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(2, 7);

        list.add(4, 6);
        list.addFirst(0);
        list.addLast(10);
        System.out.println("num of index 4" + list.get(4));
        System.out.println("first num " + list.getFirst());
        System.out.println("last num " + list.getLast());
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        System.out.println("list with removed nums " + list);
        list.sort( );
        System.out.println("sorted list" +  list);
        System.out.println("index of num " + list.indexOf(2));
        System.out.println("index of num " + list.lastIndexOf(1));
        System.out.println("does it exist" + list.exists(4));
        list.toArray();
        System.out.println("list after toArray" + list);
        System.out.println("size of list" + list.size());
        list.clear();
        System.out.println("list after clear" + list);

    }
}
