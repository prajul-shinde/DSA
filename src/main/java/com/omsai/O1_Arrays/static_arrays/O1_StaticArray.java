import static java.lang.IO.print;
import static java.lang.IO.println;

class StaticArray {
    int[] data;
    int size;  // no of elements can be stored
    int noOfElements; // no of elements currently stored

    public StaticArray(int size) {
        this.size = size;
        this.data = new int[size];
        this.noOfElements = 0;
    }

    public void insertAtEnd(int element) {
        //[10 20 30 40 50] noOfElements = 5, size = 5
        if (noOfElements >= size) {
            throw new IllegalStateException("array is full");
        }
        data[noOfElements] = element;
        noOfElements++;
    }

    public void printArray() {
        print("[");
        for (var i = 0; i < noOfElements; i++) {
            print(data[i] + " ");
        }
        print("]");
    }

    public void insertMiddle(int index, int element) {
        // [10 20 30 0 0]
        //[10 15 20 30 0]
        if (noOfElements >= size) {
            throw new IllegalStateException("array is full");
        }
        if (index < 0 || index > noOfElements) {
            throw new IllegalArgumentException("invalid index " + index);
        }
        // move elements to right
        for (var i = noOfElements; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        noOfElements++;
    }

    public void removeMiddle(int index) {
        if (noOfElements <= 0) {
            throw new IllegalStateException("array is empty");
        }
        //[10 15 20 30 0]
        if (index < 0 || index >= noOfElements) {
            throw new IllegalArgumentException("invalid index " + index);
        }
        //shift left
        for (var i = index; i < noOfElements - 1; i++) {
            data[i] = data[i + 1];
        }
        noOfElements--;
        data[noOfElements] = 0;
    }

    public void removeFromEnd() {
        if (noOfElements <= 0) {
            throw new IllegalStateException("array is empty");
        }
        noOfElements--;
        data[noOfElements] = 0;
    }
}

void main() {
    StaticArray arr = new StaticArray(5);

    arr.insertAtEnd(10);
    arr.insertAtEnd(20);
    arr.insertAtEnd(30);
    print("After inserting 10, 20, 30: ");
    arr.printArray();
    println();
    arr.insertMiddle(1, 15);
    print("After inserting 15 at index 1: ");
    arr.printArray();
    println();

    arr.removeMiddle(2);
    print("After removing index 2 (the 20): ");
    arr.printArray();
    println();

    arr.removeFromEnd();
    print("After removing from end: ");
    arr.printArray();
    println();

}