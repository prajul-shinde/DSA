// find missing number in consecutive array
void main() {
    IO.println(findMissing(new int[]{1, 2, 4, 5, 6})); // 3
    IO.println(findMissing(new int[]{2, 3, 1, 5}));    // 4
    IO.println(findMissing(new int[]{2}));             // 1 (first number missing)
    IO.println(findMissing(new int[]{1}));             // 2 (last number missing)
    IO.println(findMissing(new int[]{}));              // 1 (n = 1, only 1 exists)
}

/// For {1, 2, 4, 5, 6}:
///
/*
 n = 5 + 1 = 6
 Expected sum: 6 * 7 / 2 = 21
 Actual sum: 1 + 2 + 4 + 5 + 6 = 18
 Missing: 21 - 18 = 3
*/

/// The formula n * (n + 1) / 2 gives the sum of 1 to n.

private int findMissing(int[] arr) {
    var n = arr.length + 1;
    long expectedSum = (long) n * (n + 1) / 2;
    long actualSum = 0;
    for (var num : arr) actualSum += num;

    // whatever left is missing number
    return (int) (expectedSum - actualSum);
}