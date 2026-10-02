void main() {
    char[][] testCases = {
            {'h', 'e', 'l', 'l', 'o'},            // Odd length
            {'H', 'a', 'n', 'n', 'a', 'h'},      // Even length
            {'A'},                                // Single character
            {},                                   // Empty array
            null                                  // Null input
    };
    for (char[] s : testCases) {
        System.out.print("Original: " + (s == null ? "null" : new String(s)));
        reverseString(s);
        System.out.println(" -> Reversed: " + (s == null ? "null" : new String(s)));
    }
}

private void reverseString(char[] s) {

    if (s == null || s.length <= 1)
        return;
    var left = 0;
    var right = s.length - 1;
    while (left < right) {
        var temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
    }
}
