public class Main {
    public static void main(String[] args) {
        // MyArrayList
        MyArrayList<Integer> listArray = new MyArrayList<Integer>() {};
        listArray.add(1);
        listArray.add(2);
        listArray.add(3);
        listArray.add(4);
        listArray.set(2, 7);
        listArray.add(4, 6);
        listArray.addFirst(0);
        listArray.addLast(10);
        System.out.println("num of index 4: " + listArray.get(4));
        System.out.println("first num: " + listArray.getFirst());
        System.out.println("last num: " + listArray.getLast());
        listArray.remove(2);
        listArray.removeFirst();
        listArray.removeLast();
        System.out.println("listArray with removed nums: " + listArray);
        listArray.sort();
        System.out.println("sorted listArray: " + listArray);
        System.out.println("index of num 2: " + listArray.indexOf(2));
        System.out.println("index of num 1: " + listArray.lastIndexOf(1));
        System.out.println("does 4 exist? " + listArray.exists(4));
        listArray.toArray();
        System.out.println("listArray after toArray: " + listArray);
        System.out.println("size of listArray: " + listArray.size());
        listArray.clear();
        System.out.println("listArray after clear: " + listArray);

        System.out.println("===================================");

        // MyLinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>() {};
        linkedList.add(0);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.set(2, 7);
        linkedList.add(8);
        linkedList.add(1);
        linkedList.add(4, 6);
        linkedList.addFirst(0);
        linkedList.addLast(10);
        System.out.println("num of index 4: " + linkedList.get(4));
        System.out.println("first num: " + linkedList.getFirst());
        System.out.println("last num: " + linkedList.getLast());
        linkedList.remove(2);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("linkedList with removed nums: " + linkedList);
        linkedList.sort();
        System.out.println("sorted linkedList: " + linkedList);
        System.out.println("index of num 2: " + linkedList.indexOf(2));
        System.out.println("index of num 1: " + linkedList.lastIndexOf(1));
        System.out.println("does 4 exist? " + linkedList.exists(4));
        linkedList.toArray();
        System.out.println("linkedList after toArray: " + linkedList);
        System.out.println("size of linkedList: " + linkedList.size());
        linkedList.clear();
        System.out.println("linkedList after clear: " + linkedList);
    }
}
