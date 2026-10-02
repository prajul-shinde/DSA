void main() {
    int[][] testCases = {
            {0, 1, 0, 3, 12}, // Standard case -> [1, 3, 12, 0, 0]
            {0},              // Single element -> [0]
            {1, 2, 3, 4},     // No zeroes -> [1, 2, 3, 4]
            {0, 0, 0},        // All zeroes -> [0, 0, 0]
            {4, 2, 4, 0, 0, 3},// Zeroes in the middle -> [4, 2, 4, 3, 0, 0]
            {},               // Empty array -> []
            null              // Null input -> null
    };

    for (int[] nums : testCases) {
        System.out.print("Original: " + (nums == null ? "null" : java.util.Arrays.toString(nums)));
        moveZeroes(nums);
        System.out.println(" -> Result: " + (nums == null ? "null" : java.util.Arrays.toString(nums)));
    }
}

private void moveZeroes(int[] nums) {
    if (nums == null || nums.length <= 1)
        return;
    var write = 0;
    for (var read = 0; read < nums.length; read++) {
//        When read encounters a non-zero element,
//            we swap the values at read and write,
//                then increment write.
        if (nums[read] != 0) {
//            prevents unnecessary self-swaps when an array starts with non-zero elements.
            if (read != write) {
                var temp = nums[write];
                nums[write] = nums[read];
                nums[read] = temp;
            }
            write++;
        }
    }
}