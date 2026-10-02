//find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.
void main() {
    int[][] testCases = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4}, // Standard case -> Max Sum = 6 (Subarray: [4, -1, 2, 1])
            {1},                              // Single positive element -> Max Sum = 1
            {5, 4, -1, 7, 8},                 // All positive / mostly positive -> Max Sum = 23
            {-1, -2, -3, -4},                 // All negative numbers -> Max Sum = -1 (Subarray: [-1])
            {-2, -1},                         // Negative numbers -> Max Sum = -1
            {},                               // Empty array -> 0
            null                              // Null input -> 0
    };

    for (int[] nums : testCases) {
        int result = maxSubArray(nums);
        System.out.println("Array: " + (nums == null ? "null" : java.util.Arrays.toString(nums))
                + " -> Max Subarray Sum: " + result);
    }
}

private int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0)
        return 0;
    var currentSum = nums[0];
    var maxSum = nums[0];
    for (var i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}