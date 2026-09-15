import static java.lang.IO.print;
import static java.lang.IO.println;

// https://leetcode.com/problems/reverse-linked-list/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        var newHead = reverseList(head.next);
        // Turn head.next's pointer around to point to current head
        head.next.next = head;   // 3->2
        // Sever original forward connection to prevent cycles
        head.next = null; // 3->2->null
        return newHead;
    }
}

// Helper methods for local execution
ListNode createList(int[] arr) {
    if (arr.length == 0) return null;
    ListNode head = new ListNode(arr[0]);
    ListNode curr = head;
    for (int i = 1; i < arr.length; i++) {
        curr.next = new ListNode(arr[i]);
        curr = curr.next;
    }
    return head;
}

void printList(ListNode head) {
    if (head == null) {
        println("null");
        return;
    }
    ListNode curr = head;
    while (curr != null) {
        print(curr.val + (curr.next != null ? " -> " : ""));
        curr = curr.next;
    }
    println("");
}

void main() {
    Solution sol = new Solution();

    println("=== Test Case 1: [1, 2, 3] ===");
    ListNode head1 = createList(new int[]{1, 2, 3});
    print("Original: ");
    printList(head1);
    print("Reversed: ");
    printList(sol.reverseList(head1));

    println("\n=== Test Case 2: [1, 2] ===");
    ListNode head2 = createList(new int[]{1, 2});
    print("Original: ");
    printList(head2);
    print("Reversed: ");
    printList(sol.reverseList(head2));

    println("\n=== Test Case 3: Empty List [] ===");
    ListNode head3 = createList(new int[]{});
    print("Original: ");
    printList(head3);
    print("Reversed: ");
    printList(sol.reverseList(head3));
}