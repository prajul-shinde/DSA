import static java.lang.IO.print;
import static java.lang.IO.println;


void main() {
    // 1. Create a list: 1 -> 2 -> 3 -> 4 -> null
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    printList("Original", head);

    // 2. Reverse it
    ListNode reversedHead = reverseList(head);

    printList("Reversed", reversedHead);
}

private ListNode reverseList(ListNode head) {
    // 1 -> 2 -> 3 -> 4 -> null
    ListNode prev = null;
    var curr = head;
    while (curr != null) {
        var temp = curr.next; // 2, 3 , 4
        curr.next = prev;   // 1 -> null , 2 -> 1 -> null, 3 -> 2 -> 1 -> null
        prev = curr; // 1, 2, 3 , 4
        curr = temp; // 2, 3 , 4 , null
    }
    return prev;
}

private void printList(String label, ListNode head) {
    print(label + ": ");
    var curr = head;
    while (curr != null) {
        print(curr.value + "-> ");
        curr = curr.next;
    }
    println("null");
}

class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}