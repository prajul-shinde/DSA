//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// remove duplicates in place

import static java.lang.IO.print;
import static java.lang.IO.println;

private int removeDuplicates(int[] nums) {
    if (nums.length == 0)
        return 0;
    int writer = 1;
    for (var reader = 1; reader < nums.length; reader++) {
        if (nums[reader] != nums[reader - 1]) {
            nums[writer] = nums[reader];
            writer++;
        }
    }
    return writer;
}

void printArray(int[] arr, int length) {
    print("[");
    for (int i = 0; i < length; i++) {
        print(arr[i] + " ");
    }
    print("]");
}

void main() {

    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    print("Original array: ");
    printArray(nums, nums.length);
    println();
    int k = removeDuplicates(nums);

    System.out.println("Unique elements count (k): " + k);
    println();
    System.out.print("Logical array (first " + k + " elements): ");
    printArray(nums, k);
    println();
}

