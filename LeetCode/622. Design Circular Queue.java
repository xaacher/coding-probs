class MyCircularQueue {
    Node head;
    Node tail;

    int size;
    int capacity;

    public MyCircularQueue(int k) {
        Node dummyNode = new Node(-1);
        this.head = dummyNode;
        this.head.next = this.tail;

        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if(this.size >= this.capacity) {
            return false;
        }

        Node newNode = new Node(value);
        if(this.head.next == null) {
            this.head.next = newNode;
            this.tail = head.next;
            this.tail.prev = head;
            this.head.prev = tail;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.size += 1;

        return true;
    }

    public boolean deQueue() {
        if(this.size <= 0) {
            return false;
        }

        this.head.next = this.head.next.next;
        if(this.head.next != null) {
            this.head.next.prev = this.head;
        }

        this.size -= 1;

        return true;
    }

    public int Front() {
        if(this.size <= 0) {
            return -1;
        }

        return this.head.next != null ? this.head.next.value : -1;
    }

    public int Rear() {
        if(this.size <= 0) {
            return -1;
        }

        return this.tail != null ? this.tail.value : -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
