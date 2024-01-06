 class MyStack {
    Node head;
    int size;

    public MyStack() {
        Node dummyNode = new Node(-1);
        this.head = dummyNode;
        this.size = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = this.head.next;
        this.head.next = newNode;
        this.size += 1;
    }

    public int pop() {
        int result = this.head.next.value;
        this.head.next = this.head.next.next;
        this.size -= 1;

        return result;
    }

    public int top() {
        return head.next.value;
    }

    public boolean empty() {
        return this.size == 0;
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
