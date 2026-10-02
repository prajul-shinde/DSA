void main() {
    String[] testCases = {
            "leetcode",      // Standard case -> 'l' at index 0
            "loveleetcode",  // Standard case -> 'v' at index 2
            "aabbcc",        // All repeating -> -1
            "z",             // Single character -> 0
            "",              // Empty string -> -1
            null,            // Null input -> -1
            "𐍈a𐍈b"           // Unicode/Emoji surrogate pairs -> 'a' at index 2 (16-bit units)
    };

    for (String s : testCases) {
        int result = firstUniqChar(s);
        System.out.println("Input: " + (s == null ? "null" : "\"" + s + "\"") + " -> Index: " + result);
    }
}

private int firstUniqChar(String s) {
    if (s == null || s.length() == 0)
        return -1;
    if (s.length() == 1)
        return 0;
    Map<Character, Integer> counts = new LinkedHashMap<>();
    for (var i = 0; i < s.length(); i++)
        counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);

    for (var entry : counts.entrySet()) {
        if (entry.getValue() == 1) {
            return s.indexOf(entry.getKey());
        }
    }
    return -1;
}