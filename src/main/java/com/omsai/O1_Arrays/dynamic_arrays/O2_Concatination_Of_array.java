//https://leetcode.com/problems/concatenation-of-array/description/
/*
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i]
for 0 <= i < n (0-indexed).
Specifically, ans is the concatenation of two nums arrays.
Return the array ans.
Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
* */

import static java.lang.IO.print;
import static java.lang.IO.println;

void printArray(int[] arr) {
    print("[");
    for (int i = 0; i < arr.length; i++) {
        print(arr[i] + " ");
    }
    print("]");
}


private int[] getConcatenation(int[] nums) {

    int n = nums.length;
    int[] ans = new int[2 * n];
    for (var i = 0; i < n; i++) {
        ans[i] = nums[i];
        ans[i + n] = nums[i];
    }
    return ans;
}

void main() {
    int[] nums = {1, 2, 1};

    print("Original array: ");
    printArray(nums);
    println();

    int[] result = getConcatenation(nums);

    print("Concatenated array: ");
    printArray(result);
    println();
}