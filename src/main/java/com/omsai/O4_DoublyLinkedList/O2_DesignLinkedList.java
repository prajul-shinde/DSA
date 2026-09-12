import static java.lang.IO.println;

// https://leetcode.com/problems/design-linked-list/

class Node {

    private int value;
    private Node next;
    private Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {

    private Node head;
    private Node tail;

    public MyLinkedList() {
        // Initialize your data structure here (Singly or Doubly Linked List with sentinel nodes)
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int index) {
        if (index < 0) return -1;
        var curr = this.head.next;
        for (var i = 0; i < index && curr != tail; i++)
            curr = curr.next;
        if (curr == tail) return -1;
        return curr.value;
    }

    public void addAtHead(int val) {
        // WRITE YOUR LOGIC HERE
        var newNode = new Node(val);
        newNode.prev = this.head;
        newNode.next = this.head.next;

        this.head.next.prev = newNode;
        this.head.next = newNode;
    }

    public void addAtTail(int val) {
        // WRITE YOUR LOGIC HERE
        var newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void addAtIndex(int index, int val) {
        // WRITE YOUR LOGIC HERE
        if (index < 0) return;
        var curr = head;
        for (var i = 0; i < index && curr != tail; i++)
            curr = curr.next;

        if (curr != tail) {
            var newNode = new Node(val);
            newNode.next = curr.next;
            newNode.prev = curr;

            curr.next.prev = newNode;
            curr.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        // WRITE YOUR LOGIC HERE
        if (index < 0) return;
        var curr = head.next;
        for (var i = 0; i < index && curr != tail; i++)
            curr = curr.next;

        if (curr != tail) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr.next = null;
            curr.prev = null;
        }
    }
}

void main() {
    println("=== Test Case 1: Standard LeetCode Example ===");
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
    println("get(1) [Expected: 2] -> Actual: " + myLinkedList.get(1));
    myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
    println("get(1) [Expected: 3] -> Actual: " + myLinkedList.get(1));

    println("\n=== Test Case 2: Edge Operations & Out of Bounds ===");
    MyLinkedList list2 = new MyLinkedList();
    println("get(0) on empty list [Expected: -1] -> Actual: " + list2.get(0));

    list2.addAtHead(7);
    list2.addAtHead(2);
    list2.addAtHead(1);              // 1 -> 2 -> 7
    list2.addAtIndex(3, 0);          // 1 -> 2 -> 7 -> 0
    list2.deleteAtIndex(2);          // 1 -> 2 -> 0
    list2.addAtHead(6);              // 6 -> 1 -> 2 -> 0
    list2.addAtTail(4);              // 6 -> 1 -> 2 -> 0 -> 4
    println("get(4) [Expected: 4] -> Actual: " + list2.get(4));

    println("\n=== Test Case 3: Invalid Index Operations ===");
    MyLinkedList list3 = new MyLinkedList();
    list3.addAtHead(1);
    list3.addAtIndex(5, 10);         // Out-of-bounds index > length; should do nothing
    println("get(1) [Expected: -1] -> Actual: " + list3.get(1));
    list3.deleteAtIndex(5);          // Out-of-bounds index; should do nothing
    println("get(0) [Expected: 1]  -> Actual: " + list3.get(0));
}