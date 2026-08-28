
/// You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
///
/// You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
///
/// An integer x.
/// Record a new score of x.
/// '+'.
/// Record a new score that is the sum of the previous two scores.
/// 'D'.
/// Record a new score that is the double of the previous score.
/// 'C'.
/// Invalidate the previous score, removing it from the record.
/// Return the sum of all the scores on the record after applying all the operations.

import static java.lang.IO.println;

// https://leetcode.com/problems/baseball-game/description/

/**
 * Problem 1: Baseball Game
 * Integer = push score
 * "C" = invalidate (pop)
 * "D" = double last valid score and push
 * "+" = sum last two valid scores and push
 */
private int calPoints(String[] operations) {
    Stack<Integer> stack = new Stack<>();
    for (var op : operations) {
        switch (op) {
            case "+" -> {
                var first = stack.pop();
                var second = stack.peek();
                var sumOfPrev = first + second;
                stack.push(first);
                stack.push(sumOfPrev);
            }
            case "D" -> {
                var prev = stack.peek();
                stack.push(prev * 2);
            }
            case "C" -> {
                stack.pop();
            }
            default -> stack.push(Integer.parseInt(op));
        }
    }
    var totalSum = 0;
    while (!stack.isEmpty())
        totalSum += stack.pop();
    return totalSum;
}

void main() {
    String[] ops1 = {"5", "2", "C", "D", "+"};
    println("Test Case 1:");
    println("Input: ops = [\"5\", \"2\", \"C\", \"D\", \"+\"]");
    println("Expected Output: 30");
    println("Your Output:     " + calPoints(ops1));
    println();

    String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
    println("Test Case 2:");
    println("Input: ops = [\"5\", \"-2\", \"4\", \"C\", \"D\", \"9\", \"+\", \"+\"]");
    println("Expected Output: 27");
    println("Your Output:     " + calPoints(ops2));
    println();

    String[] ops3 = {"1", "C"};
    println("Test Case 3:");
    println("Input: ops = [\"1\", \"C\"]");
    println("Expected Output: 0");
    println("Your Output:     " + calPoints(ops3));
}