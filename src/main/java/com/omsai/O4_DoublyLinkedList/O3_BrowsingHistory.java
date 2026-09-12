import static java.lang.IO.println;

// https://leetcode.com/problems/design-browser-history/

class HistoryNode {
    private String url;
    private HistoryNode next;
    private HistoryNode prev;

    public HistoryNode(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {

    private HistoryNode curr;

    public BrowserHistory(String homepage) {
        // INITIALIZE YOUR DATA STRUCTURE HERE
        this.curr = new HistoryNode(homepage);
    }

    public void visit(String url) {
        // WRITE YOUR LOGIC HERE
        var newNode = new HistoryNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;

    }

    public String back(int steps) {
        // WRITE YOUR LOGIC HERE
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps) {
        // WRITE YOUR LOGIC HERE
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}

void main() {
    println("=== Test Case 1: Standard LeetCode Flow ===");
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

    browserHistory.visit("google.com");
    browserHistory.visit("facebook.com");
    browserHistory.visit("youtube.com");

    println("back(1) [Expected: facebook.com] -> Actual: " + browserHistory.back(1));
    println("back(1) [Expected: google.com]   -> Actual: " + browserHistory.back(1));
    println("forward(1) [Expected: facebook.com] -> Actual: " + browserHistory.forward(1));

    println("\n=== Test Case 2: Overwriting Forward History ===");
    println("Visiting 'linkedin.com' from facebook.com...");
    browserHistory.visit("linkedin.com"); // Clears forward history (youtube.com)

    println("forward(2) [Expected: linkedin.com] -> Actual: " + browserHistory.forward(2));
    println("back(2)    [Expected: google.com]   -> Actual: " + browserHistory.back(2));

    println("\n=== Test Case 3: Exceeding History Boundaries ===");
    println("back(7) [Expected: leetcode.com] -> Actual: " + browserHistory.back(7));
}