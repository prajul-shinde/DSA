import static java.lang.IO.println;

class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        this.q = new ArrayDeque<>();
    }

    public void push(int value) {
        q.add(value);
        int size = q.size();
///        Rotates queue so new element moves to the front
        for (var i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int top() {
        return q.peek();
    }

    public int pop() {
        return q.poll();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

void main() {
    println("=== Test Case 1: Standard LeetCode Example ===");
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    println("top()   [Expected: 2]     -> Actual: " + myStack.top());
    println("pop()   [Expected: 2]     -> Actual: " + myStack.pop());
    println("empty() [Expected: false] -> Actual: " + myStack.empty());

    println("\n=== Test Case 2: Consecutive Operations & Emptying ===");
    myStack.push(3);
    println("top()   [Expected: 3]     -> Actual: " + myStack.top());
    println("pop()   [Expected: 3]     -> Actual: " + myStack.pop());
    println("pop()   [Expected: 1]     -> Actual: " + myStack.pop());
    println("empty() [Expected: true]  -> Actual: " + myStack.empty());
}