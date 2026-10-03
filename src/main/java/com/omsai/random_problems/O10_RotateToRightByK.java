//Rotating right by k moves the last k elements to the front. You can get there with three reversals, in place, using O(1) extra space:
//
//[1,2,3,4,5,6,7]   k = 3
//[7,6,5,4,3,2,1]   1. reverse the whole array
//[5,6,7,4,3,2,1]   2. reverse the first k
//[5,6,7,1,2,3,4]   3. reverse the remaining n - k
void main() {

    int[] a = {1, 2, 3, 4, 5, 6, 7};
    rotate(a, 3);
    IO.println(Arrays.toString(a)); // [5, 6, 7, 1, 2, 3, 4]

    int[] b = {1, 2, 3, 4, 5, 6, 7};
    rotate(b, 10);                  // 10 % 7 = 3, same as above
    IO.println(Arrays.toString(b)); // [5, 6, 7, 1, 2, 3, 4]

    int[] c = {1, 2, 3};
    rotate(c, 0);                   // nothing changes
    IO.println(Arrays.toString(c)); // [1, 2, 3]

    int[] d = {1, 2, 3};
    rotate(d, 3);                   // full rotation, nothing changes
    IO.println(Arrays.toString(d)); // [1, 2, 3]

    int[] e = {1};
    rotate(e, 5);                   // single element
    IO.println(Arrays.toString(e)); // [1]
}

private void rotate(int[] nums, int k) {
    // nothing to rotate
    if (nums == null || nums.length <= 1) return;

    // k can be bigger than n (rotating n times gives the same array),
    // and the double % also handles a negative k
    int n = nums.length;
    k = ((k % n) + n) % n;
    if (k == 0) return;

    reverse(nums, 0, n - 1); // whole array
    reverse(nums, 0, k - 1); // first k elements
    reverse(nums, k, n - 1); // remaining n-k elements
}

private void reverse(int[] nums, int left, int right) {
    while (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
}