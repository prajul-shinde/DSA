import static java.lang.IO.print;
import static java.lang.IO.println;

//https://leetcode.com/problems/shuffle-the-array/description/

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].
* */

private int[] shuffle(int[] nums, int n) {
    // WRITE YOUR LOGIC HERE
    int[] result = new int[2 * n];

    for (int i = 0; i < n; i++) {
        result[2 * i] = nums[i];
        result[2 * i + 1] = nums[n + i];
    }
    return result;
}

void printArray(int[] arr) {
    print("[");
    for (int i = 0; i < arr.length; i++) {
        print(arr[i] + " ");
    }
    print("]");
}

void main() {
    int[] nums = {2, 5, 1, 3, 4, 7};
    int n = 3;

    print("Original array: ");
    printArray(nums);
    println();
    println("n = " + n);
    println();

    int[] result = shuffle(nums, n);

    print("Shuffled array: ");
    printArray(result);
    println();
}
