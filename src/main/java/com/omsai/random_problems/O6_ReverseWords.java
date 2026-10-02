void main() {
    String[] testCases = {
            "the sky is blue",           // Standard case -> "blue is sky the"
            "  hello world  ",          // Leading and trailing spaces -> "world hello"
            "a good   example",         // Multiple spaces between words -> "example good a"
            "  Bob    Loves  Alice   ", // Mixed extra spaces -> "Alice Loves Bob"
            "Alice",                    // Single word -> "Alice"
            "   ",                      // Only spaces -> ""
            "",                         // Empty string -> ""
            null                        // Null input -> ""
    };

    for (String s : testCases) {
        String inputStr = (s == null) ? "null" : "\"" + s + "\"";
        String result = reverseWords(s);
        System.out.println("Input: " + inputStr + " -> Output: \"" + result + "\"");
    }
}

private String reverseWords(String s) {
    if (s == null || s.strip().isEmpty())
        return "";
    String[] words = s.strip().split("\\s+");
    var left = 0;
    var right = words.length - 1;
    while (left < right) {
        var temp = words[left];
        words[left] = words[right];
        words[right] = temp;
        left++;
        right--;
    }
    return String.join(" ", words);
}