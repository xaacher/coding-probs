class MyQueue {
    Node head;
    Node tail;

    int size;

    public MyQueue() {
        Node dummyNode = new Node(-1);
        this.head = dummyNode;
        this.head.next = this.tail;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        if(this.tail == null) {
            this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }

        if(this.head.next == null) {
            this.head.next = newNode;
        }

        this.size += 1;
    }

    public int pop() {
        int result = this.head.next.value;
        this.head.next = this.head.next.next;
        if(this.head.next != null) {
            this.head.next.prev = this.head;
        }
        this.size -= 1;

        return result;
    }

    public int peek() {
        return this.head.next.value;
    }

    public boolean empty() {
        return this.size == 0;
    }
}

class Node {
    int value;

    Node prev;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
