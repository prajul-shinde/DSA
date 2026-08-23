import static java.lang.IO.print;
import static java.lang.IO.println;

class DynamicArray {

    private int[] data;
    private int size;
    private int noOfElements;

    public DynamicArray() {
        this.size = 1;
        this.data = new int[this.size];
        this.noOfElements = 0;
    }

    void insertAtEnd(int element) {
        if (noOfElements == size) {
            resize();
        }
        data[noOfElements] = element;
        noOfElements++;
    }

    void insertMiddle(int index, int element) {
        if (index < 0 || index > noOfElements) {
            throw new IllegalArgumentException("invalid index");
        }
        if (noOfElements >= size) {
            resize();
        }

        // move to right
        for (var i = noOfElements; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        noOfElements++;
    }

    void removeMiddle(int index) {
        if (noOfElements <= 0) {
            throw new IllegalStateException("Array is empty");
        }
        if (index < 0 || index >= noOfElements) {
            throw new IllegalArgumentException("invalid index " + index);
        }

        // move to left
//        [10 20 30]
        for (var i = index; i < noOfElements - 1; i++) {
            data[i] = data[i + 1];
        }
        noOfElements--;
        data[noOfElements] = 0;

    }

    void removeFromEnd() {
        if (noOfElements <= 0) {
            throw new IllegalStateException("Array is empty");
        }
        noOfElements--;
        data[noOfElements] = 0;
    }

    int get(int index) {
        if (index < 0 || index >= noOfElements) {
            throw new ArrayIndexOutOfBoundsException("invalid index " + index);
        }
        return data[index];
    }

    void printArray() {
        print("[");
        for (var i = 0; i < noOfElements; i++) {
            print(data[i] + " ");
        }
        print("]");
    }

    private void resize() {
        this.size = 2 * this.size;
        int[] temp = new int[this.size];
        for (var i = 0; i < noOfElements; i++) {
            temp[i] = data[i];
        }
        this.data = temp;
    }
}

void main() {

    DynamicArray arr = new DynamicArray();

    println("=== 1. Testing insertAtEnd & Automatic Resizing ===");
    // Capacity starts at 1. Inserting 4 elements forces resize() to trigger automatically!
    arr.insertAtEnd(10);
    arr.insertAtEnd(20);
    arr.insertAtEnd(30);
    arr.insertAtEnd(40);

    print("Array after inserting 10, 20, 30, 40: ");
    arr.printArray();
    println();

    println("\n=== 2. Testing insertMiddle ===");
    arr.insertMiddle(2, 25); // Insert 25 at index 2
    print("After inserting 25 at index 2: ");
    arr.printArray();
    println();

    println("\n=== 3. Testing get() ===");
    println("Element at index 2: " + arr.get(2));
    println("Element at index 0: " + arr.get(0));

    println("\n=== 4. Testing removeMiddle ===");
    arr.removeMiddle(1); // Removes 20 from index 1
    print("After removing index 1: ");
    arr.printArray();
    println();

    println("\n=== 5. Testing removeFromEnd ===");
    arr.removeFromEnd();
    print("After removing from end: ");
    arr.printArray();
    println();

}