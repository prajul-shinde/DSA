// find the length of the longest substring without duplicate characters.
void main() {
    IO.println(lengthOfLongestSubstring("abcabcbb")); // 3
    IO.println(lengthOfLongestSubstring("bbbbb"));    // 1
    IO.println(lengthOfLongestSubstring("pwwkew"));   // 3
    IO.println(lengthOfLongestSubstring("abba"));     // 2
    IO.println(lengthOfLongestSubstring(""));         // 0
    IO.println(lengthOfLongestSubstring(null));
}

private int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) return 0;
    Map<Character, Integer> lastSeen = new HashMap<>();
    int maxLength = 0;
    int left = 0;  // start of window
    for (int right = 0; right < s.length(); right++) {
        char current = s.charAt(right);
        Integer prevIndex = lastSeen.get(current);
        if (prevIndex != null) {
            // move left ahead of duplicate
            left = Math.max(left, prevIndex + 1);
        }
        // record most recent index where current seen
        lastSeen.put(current, right);
        //window size is right-left + 1
        // + 1 is there because indices are inclusive.
        // For example, left = 2 and right = 4 covers indices 2, 3, 4,
        // which is 3 characters (4 - 2 + 1).
        maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
}