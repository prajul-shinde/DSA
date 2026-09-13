import static java.lang.IO.println;


private int countStudents(int[] students, int[] sandwiches) {
    Queue<Integer> queue = new ArrayDeque<>();
    for (int student : students)
        queue.add(student);
    int sandwichIdx = 0;
    int unableToEatCount = 0;
    while (!queue.isEmpty() && unableToEatCount < queue.size()) {
        if (queue.peek() == sandwiches[sandwichIdx]) {
            queue.poll();
            sandwichIdx++;
            unableToEatCount = 0;
        } else {
            queue.add(queue.poll());
            unableToEatCount++;
        }
    }
    return queue.size();
}

void main() {
    println("=== Test Case 1: Standard Example ===");
    int[] students1 = {1, 1, 0, 0};
    int[] sandwiches1 = {0, 1, 0, 1};
    println("Expected: 0 | Actual: " + countStudents(students1, sandwiches1));

    println("\n=== Test Case 2: Unable to Eat ===");
    int[] students2 = {1, 1, 1, 0, 0, 1};
    int[] sandwiches2 = {1, 0, 0, 0, 1, 1};
    println("Expected: 3 | Actual: " + countStudents(students2, sandwiches2));

    println("\n=== Test Case 3: All Students Get Food ===");
    int[] students3 = {0, 0, 0};
    int[] sandwiches3 = {0, 0, 0};
    println("Expected: 0 | Actual: " + countStudents(students3, sandwiches3));
}
