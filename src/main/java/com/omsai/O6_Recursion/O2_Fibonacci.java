import static java.lang.IO.println;

void main() {
    println("=== 1. Base Cases (n = 0, n = 1) ===");
    println("fib(0) -> Expected: 0 | Actual: " + fibonacci(0));
    println("fib(1) -> Expected: 1 | Actual: " + fibonacci(1));

    println("\n=== 2. Standard Fibonacci Numbers ===");
    println("fib(2) -> Expected: 1 | Actual: " + fibonacci(2));
    println("fib(3) -> Expected: 2 | Actual: " + fibonacci(3));
    println("fib(4) -> Expected: 3 | Actual: " + fibonacci(4));
    println("fib(5) -> Expected: 5 | Actual: " + fibonacci(5));
    println("fib(6) -> Expected: 8 | Actual: " + fibonacci(6));

    println("\n=== 3. Larger Fibonacci Number ===");
    println("fib(10) -> Expected: 55 | Actual: " + fibonacci(10));
}

private int fibonacci(int n) {
    if (n <= 1)
        return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}