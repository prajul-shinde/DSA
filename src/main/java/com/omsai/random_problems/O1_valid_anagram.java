void main() {
    // Test cases
    String s1 = "anagram", t1 = "nagaram";
    String s2 = "rat", t2 = "car";

    System.out.println("\"" + s1 + "\" and \"" + t1 + "\" are anagrams? " + isAnagram(s1, t1)); // Expected: true
    System.out.println("\"" + s2 + "\" and \"" + t2 + "\" are anagrams? " + isAnagram(s2, t2)); // Expected: false
}

private boolean isAnagram(String s1, String t1) {

    // 1. they must be identical
    if (s1.length() != t1.length())
        return false;

    // 2. maintain character count
    var counts = new java.util.HashMap<Character, Integer>();

    // 3. process both simultaneously
    for (var i = 0; i < s1.length(); i++) {
        char charS1 = s1.charAt(i);
        char charT1 = t1.charAt(i);

        // increment count for character from string s
        counts.put(charS1, counts.getOrDefault(charS1, 0) + 1);
        // decrement count for character from string t
        counts.put(charT1, counts.getOrDefault(charT1, 0) - 1);
    }
    // 4. If all characters cancel out to 0, they are anagrams
    for (var count : counts.values()) {
        if (count != 0)
            return false;
    }
    return true;

}