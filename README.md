 Assignment 2

 Description
This project implements basic data structures in Java such as ArrayList, LinkedList, Stack, Queue, and Heap from scratch.

 Features
- `MyArrayList<T>`
- `MyLinkedList<T>`
- `MyStack<T>` (based on LinkedList)
- `MyQueue<T>` (based on ArrayList)
- `MyHeap<T>` (based on LinkedList)

 MyArrayList<T>
Dynamic array implementation
Methods: add, remove, get, set, clear, sort, addFirst, addLast, etc.

 MyLinkedList<T>
Doubly linked list
Methods: add, remove, get, set, indexOf, lastIndexOf, etc.

 MyStack<T>
Implements LIFO (Last-In-First-Out) structure
Uses MyLinkedList<T> internally
Methods: push, pop, peek, isEmpty

 MyQueue<T>
Implements FIFO (First-In-First-Out) structure
Uses MyArrayList<T> internally
Methods: enqueue, dequeue, peek, isEmpty

 MyHeap<T>
Min-heap implementation
Based on MyLinkedList<T>
Methods: add, remove, peek, heapify

Sample Output 
num of index 4: 6
first num: 0
last num: 10
list with removed nums: [1, 7, 4]
sorted list: [1, 4, 7]
index of num 2: -1
does it exist: true
size of list: 3
