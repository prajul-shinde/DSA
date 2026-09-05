import static java.lang.IO.print;
import static java.lang.IO.println;
// https://leetcode.com/problems/merge-two-sorted-lists/
void main() {
    println("Test Case 1:");
    ListNode l1 = createList(new int[]{1, 2, 4});
    ListNode l2 = createList(new int[]{1, 3, 4});
    print("list1:  ");
    printList(l1);
    print("list2:  ");
    printList(l2);
    print("Merged: ");
    printList(mergeTwoLists(l1, l2));
    println();

    println("Test Case 2:");
    ListNode l3 = createList(new int[]{});
    ListNode l4 = createList(new int[]{});
    print("list1:  ");
    printList(l3);
    print("list2:  ");
    printList(l4);
    print("Merged: ");
    printList(mergeTwoLists(l3, l4));
    println();

    println("Test Case 3:");
    ListNode l5 = createList(new int[]{});
    ListNode l6 = createList(new int[]{0});
    print("list1:  ");
    printList(l5);
    print("list2:  ");
    printList(l6);
    print("Merged: ");
    printList(mergeTwoLists(l5, l6));
}

private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    var dummy = new ListNode(-1);
    var tail = dummy;  // -1
    // compare elements while both lists have nodes remaining
    while (list1 != null && list2 != null) {
        if (list1.value <= list2.value) {
            tail.next = list1;
            list1 = list1.next;
        } else {
            tail.next = list2;
            list2 = list2.next;
        }
        tail = tail.next;
    }
    // directly attach whichever list still has elements left
    if (list1 != null) {
        tail.next = list1;
    } else if (list2 != null) {
        tail.next = list2;
    }
    // return head
    return dummy.next;
}

private ListNode createList(int[] arr) {
    var dummy = new ListNode(-1);
    var curr = dummy;
    for (var val : arr) {
        curr.next = new ListNode(val);
        curr = curr.next;
    }
    return dummy.next;
}

class ListNode {

    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

void printList(ListNode head) {
    print("[");
    var curr = head;
    while (curr != null) {
        print(curr.value + "-> ");
        curr = curr.next;
    }
    print("null");
    println("]");
}