import static java.lang.IO.println;

/// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
///
/// Implement the MinStack class:
///
/// MinStack() initializes the stack object.
/// void push(int value) pushes the element value onto the stack.
/// void pop() removes the element on the top of the stack.
/// int top() gets the top element of the stack.
/// int getMin() retrieves the minimum element in the stack.
/// You must implement a solution with O(1) time complexity for each function.
///
// https://leetcode.com/problems/min-stack/description/

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty())
            minStack.push(val);
        else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

void main() {
    println("=== Testing MinStack ===");

    MinStack minStack = new MinStack();

    println("Pushing -2, 0, -3...");
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    println("getMin(): " + minStack.getMin() + " | Expected: -3");

    println("\nPopping top element (-3)...");
    minStack.pop();

    println("top():    " + minStack.top() + " | Expected: 0");
    println("getMin(): " + minStack.getMin() + " | Expected: -2");
}