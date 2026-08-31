import static java.lang.IO.print;
import static java.lang.IO.println;

class ListNode {

    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedList {
    private ListNode head;
    private ListNode tail;

    public SinglyLinkedList() {
        /*Without a dummy node, the head can be null.
          If you want to insert or delete at index 0, you have to write special if/else logic
          because there is no "node before index 0" to attach pointers to.
         */
        this.head = new ListNode(-1);
        this.tail = head;
    }

    public void insertEnd(int element) {
        this.tail.next = new ListNode(element);
        this.tail = this.tail.next;
    }

    public void printList() {
        print("List: ");
        var curr = this.head.next;
        while (curr != null) {
            print(curr.value + "->");
            curr = curr.next;
        }
        println("null");
    }

    public void insert(int index, int element) {
        var curr = this.head;
        // move the node before target index
        for (var i = 0; i < index && curr != null; i++)
            curr = curr.next;
        if (curr != null) {
            var newNode = new ListNode(element);
            // connect new node to rest of list
            // 20 -> 30 -> null
            newNode.next = curr.next;
            // link current to new node
            // 10->20->30->null
            curr.next = newNode;

            // update tail if inserted at end
            if (newNode.next == null)
                this.tail = newNode;
        }
    }

    public void removeEnd() {
        if (head.next == null) return;

        var curr = this.head;
        // move till node before end
        while (curr.next != this.tail)
            curr = curr.next;

        // set new tail
        curr.next = null;
        this.tail = curr;
    }

    public void remove(int index) {
        var curr = this.head;
        // move before the node we want to delete
        for (var i = 0; i < index && curr != null; i++)
            curr = curr.next;
        // Did we stop on a real node before reaching the target index?"
        // Does the node we actually want to delete exist?
        if (curr != null && curr.next != null) {
            // if deleting tail move tail back
            if (curr.next == tail) {
                tail = curr;
            }
            // skip the node
            curr.next = curr.next.next;
        }
    }
}

void main() {

    var list = new SinglyLinkedList();
    println("--- Adding 10, 30 ---");
    list.insertEnd(10);
    list.insertEnd(30);
    list.printList(); // 10 -> 30 -> null

    println("\n--- Inserting 20 in Middle (Index 1) ---");
    list.insert(1, 20);
    list.printList(); // 10 -> 20 -> 30 -> null

    println("\n--- Inserting 5 at Front (Index 0) ---");
    list.insert(0, 5);
    list.printList(); // 5 -> 10 -> 20 -> 30 -> null

    println("\n--- Removing End ---");
    list.removeEnd();
    list.printList(); // 5 -> 10 -> 20 -> null

    println("\n--- Removing Middle (Index 1: the 10) ---");
    list.remove(1);
    list.printList(); // 5 -> 20 -> null
}