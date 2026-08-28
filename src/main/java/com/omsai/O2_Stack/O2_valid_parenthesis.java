///
/// https://leetcode.com/problems/valid-parentheses/
/// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
///
/// An input string is valid if:
///
/// Open brackets must be closed by the same type of brackets.
/// Open brackets must be closed in the correct order.
/// Every close bracket has a corresponding open bracket of the same type.
///

import static java.lang.IO.println;

/* Must close in correct order: () [] {}
 */

private boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (var i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '{' || c == '(' || c == '[')
            stack.push(c);
        else {
            if (stack.isEmpty()) return false;
            else {
                var lastParenthesis = stack.pop();
                if (c == ')' && lastParenthesis != '(') return false;
                if (c == '}' && lastParenthesis != '{') return false;
                if (c == ']' && lastParenthesis != '[') return false;
            }
        }
    }
    return stack.isEmpty();
}

void main() {
    String s1 = "()";
    println("Test Case 1:");
    println("Input: s = \"()\"");
    println("Expected Output: true");
    println("Your Output:     " + isValid(s1));
    println();

    String s2 = "()[]{}";
    println("Test Case 2:");
    println("Input: s = \"()[]{}\"");
    println("Expected Output: true");
    println("Your Output:     " + isValid(s2));
    println();

    String s3 = "(]";
    println("Test Case 3:");
    println("Input: s = \"(]\"");
    println("Expected Output: false");
    println("Your Output:     " + isValid(s3));
    println();

    String s4 = "([])";
    println("Test Case 4:");
    println("Input: s = \"([])\"");
    println("Expected Output: true");
    println("Your Output:     " + isValid(s4));
}

