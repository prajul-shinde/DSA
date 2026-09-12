import static java.lang.IO.print;
import static java.lang.IO.println;

/// curr!=tail is to prevent accidental deletion of dummy tail node and out of bound things
class DoublyLinkedListNode {

    private int value;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode(-1);
        this.tail = new DoublyLinkedListNode(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void insertAtBeginning(int value) {
        var newNode = new DoublyLinkedListNode(value);
        newNode.prev = head;
        newNode.next = head.next;

        head.next.prev = newNode;
        head.next = newNode;
    }

    public void insertAtEnd(int value) {
        var newNode = new DoublyLinkedListNode(value);
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void printForward() {
        var curr = this.head.next;
        print("Forward:  head <-> ");
        while (curr != tail) {
            print(curr.value + "<-> ");
            curr = curr.next;
        }
        println("tail");
    }

    public void insert(int index, int value) {
        if (index < 0) return;
        var curr = head;
        for (var i = 0; i < index && curr != tail; i++)
            curr = curr.next;

        if (curr != tail) {
            var newNode = new DoublyLinkedListNode(value);
            newNode.next = curr.next;
            newNode.prev = curr;

            curr.next.prev = newNode;
            curr.next = newNode;
        }

    }

    public void removeEnd() {
        if (tail.prev == head) return; // list is empty
        removeNode(tail.prev);
    }


    public void removeFromBeginning() {
        if (head.next == tail) return; // list is empty
        removeNode(head.next);
    }


    private void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    public void remove(int index) {
        if (index < 0) return;
        var curr = head.next;
        for (var i = 0; i < index && curr != tail; i++)
            curr = curr.next;
        if (curr != tail) removeNode(curr);
    }

    public void printBackward() {
        print("Backward: tail <-> ");
        var curr = tail.prev;
        while (curr != head) {
            print(curr.value + "<-> ");
            curr = curr.prev;
        }
        println("head");
    }
}

void main() {
    DoublyLinkedList list = new DoublyLinkedList();

    println("=== 1. Testing insertAtBeginning & insertAtEnd ===");
    list.insertAtBeginning(20);
    list.insertAtBeginning(10); // List: 10 <-> 20
    list.insertAtEnd(40);
    list.insertAtEnd(50);       // List: 10 <-> 20 <-> 40 <-> 50
    list.printForward();

    println("\n=== 2. Testing insert(index, value) ===");
    println("Inserting 5 at Index 0 (Front):");
    list.insert(0, 5);
    list.printForward(); // 5 <-> 10 <-> 20 <-> 40 <-> 50

    println("Inserting 30 at Index 3 (Middle):");
    list.insert(3, 30);
    list.printForward(); // 5 <-> 10 <-> 20 <-> 30 <-> 40 <-> 50

    println("Inserting 60 at Index 6 (End):");
    list.insert(6, 60);
    list.printForward(); // 5 <-> 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> 60

    println("\n=== 3. Testing removeFromBeginning & removeEnd ===");
    println("Removing from beginning (removes 5):");
    list.removeFromBeginning();
    list.printForward(); // 10 <-> 20 <-> 30 <-> 40 <-> 50 <-> 60

    println("Removing from end (removes 60):");
    list.removeEnd();
    list.printForward(); // 10 <-> 20 <-> 30 <-> 40 <-> 50

    println("\n=== 4. Testing remove(index) ===");
    println("Removing index 0 (removes 10):");
    list.remove(0);
    list.printForward(); // 20 <-> 30 <-> 40 <-> 50

    println("Removing index 2 (removes 40):");
    list.remove(2);
    list.printForward(); // 20 <-> 30 <-> 50

    println("\n=== 5. Verifying Backward Traversal Integrity ===");
    list.printBackward(); // tail <-> 50 <-> 30 <-> 20 <-> head
}