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

class Queue {

    private ListNode left;  // front of queue front -> [1 2 3]
    private ListNode right; // back of queue [1 2 3] <- back

    public Queue() {
        this.left = null;
        this.right = null;
    }

    // push to back
    public void enqueue(int value) {
        var newNode = new ListNode(value);
        if (right != null)
            right.next = newNode;
        else
            left = newNode;
        right = newNode;
    }

    // pop from front
    public int dequeue() {
        if (left == null)
            return -1;

        var value = this.left.value;
        left = left.next;

        // if queue becomes empty reset right to null as well
        if (left == null)
            right = null;

        return value;
    }

    // O(1) - Look at front element without removing
    public int peek() {
        if (this.left == null) {
            return -1;
        }
        return this.left.value;
    }

    public boolean isEmpty() {
        return this.left == null;
    }

    public void printQueue() {
        print("Front -> ");
        ListNode cur = this.left;
        while (cur != null) {
            print(cur.value + " -> ");
            cur = cur.next;
        }
        println("Back (null)");
    }
}

void main() {
    Queue queue = new Queue();

    println("=== 1. Enqueue Operations (10, 20, 30) ===");
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.printQueue(); // 10 -> 20 -> 30 -> null

    println("\n=== 2. Dequeue Operations ===");
    println("Dequeued: " + queue.dequeue()); // 10
    queue.printQueue(); // 20 -> 30 -> null

    println("\n=== 3. Dequeue Until Empty ===");
    println("Dequeued: " + queue.dequeue()); // 20
    println("Dequeued: " + queue.dequeue()); // 30
    queue.printQueue(); // Front -> Back (null)

    println("\n=== 4. Enqueue After Complete Emptying (Bug Test) ===");
    queue.enqueue(40);
    queue.enqueue(50);
    queue.printQueue(); // 40 -> 50 -> null

    println("\n=== 5. Dequeue on Empty Queue Guard ===");
    queue.dequeue(); // 40
    queue.dequeue(); // 50
    queue.dequeue(); // Underflow guard triggers
}