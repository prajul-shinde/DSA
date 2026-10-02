//    return indices of the two numbers such that they add up to target.
void main() {

    // Test cases covering edge cases and standard scenarios
    int[][] testCases = {
            {2, 7, 11, 15},   // target = 9  -> [0, 1]
            {3, 2, 4},        // target = 6  -> [1, 2]
            {3, 3},           // target = 6  -> [0, 1] (duplicate numbers)
            {-1, -8, 4, 5},   // target = -4 -> [0, 2] (negative numbers)
            {1},              // target = 2  -> [] (less than 2 elements)
            null              // target = 5  -> [] (null array)
    };
    int[] targets = {9, 6, 6, -4, 2, 5};

    for (int i = 0; i < testCases.length; i++) {
        int[] nums = testCases[i];
        int target = targets[i];
        int[] result = twoSum(nums, target);
        System.out.println("Array: " + (nums == null ? "null" : java.util.Arrays.toString(nums))
                + ", Target: " + target
                + " -> Indices: " + java.util.Arrays.toString(result));
    }
}

private int[] twoSum(int[] nums, int target) {
    // Edge Case 1: Null or array length < 2 cannot form a pair
    if (nums == null || nums.length < 2)
        return new int[0];
    // Map stores: Key = Number needed, Value = Index of that number
    Map<Integer, Integer> map = new HashMap<>();
    for (var i = 0; i < nums.length; i++) {
        // Calculate the exact 'missing piece' needed to reach target
        // Algebra: if nums[i] + complement = target, then complement = target - nums[i]
        var complement = target - nums[i];
        if (map.containsKey(complement))
            // Found a valid pair!
            // map.get(complement) -> retrieves the index of the matching earlier number
            // i                   -> is the current index of the second number
            return new int[]{map.get(complement), i};
        // If complement was not found yet, save the current number and its index in the map
        // This makes it available for future numbers in the loop to match against
        map.put(nums[i], i);
    }
    // Edge Case 2: No two numbers in the array sum up to the target
    return new int[0];
}
