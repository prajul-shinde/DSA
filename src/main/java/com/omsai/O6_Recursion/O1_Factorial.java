import static java.lang.IO.println;

void main() {
    println("=== 1. Base Cases (n = 0, n = 1) ===");
    println("0! -> Expected: 1   | Actual: " + factorial(0));
    println("1! -> Expected: 1   | Actual: " + factorial(1));

    println("\n=== 2. Standard Factorials ===");
    println("3! -> Expected: 6   | Actual: " + factorial(3));
    println("5! -> Expected: 120 | Actual: " + factorial(5));

    println("\n=== 3. Larger Factorial ===");
    println("7! -> Expected: 5040 | Actual: " + factorial(7));
}

private int factorial(int n) {
    if (n <= 1)
        return 1;
    return n * factorial(n - 1);
}