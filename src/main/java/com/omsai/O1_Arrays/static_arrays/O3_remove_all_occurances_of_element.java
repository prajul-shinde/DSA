import static java.lang.IO.print;
import static java.lang.IO.println;

// https://leetcode.com/problems/remove-element/description/

//remove all occurrences of val in nums
private int removeElement(int[] nums, int val) {
    // WRITE YOUR LOGIC HERE
    if (nums.length == 0)
        return 0;
    int writer = 0;
    for (var reader = 0; reader < nums.length; reader++) {
        if (nums[reader] != val) {
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
            int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
            int val = 2;

            print("Original array: ");
            printArray(nums, nums.length);
            println();
            println("Value to remove: " + val);
            println();

            int k = removeElement(nums, val);

            println("Remaining elements count (k): " + k);
            print("Logical array (first " + k + " elements): ");
            printArray(nums, k);
            println();
        }