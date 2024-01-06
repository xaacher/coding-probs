class MyLinkedList {
    class Node {
         Node nextNode;
         int val;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }
    }

    Node dummyNode;
    int size;

    public MyLinkedList() {
        dummyNode = new Node();
        dummyNode.val = -1;
        dummyNode.nextNode = null;
        this.size = 0;
    }

    public int get(int index) {
        if(index < 0 || index > this.size - 1) {
            return -1;
        }

        Node currentNode = dummyNode.nextNode;
        while(index -- > 0) {
            currentNode = currentNode.nextNode;
        }

        return currentNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(this.size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size) {
            return;
        }

        Node currentNode = dummyNode;
        while(index -- > 0) {
            currentNode = currentNode.nextNode;
        }

        Node newNode = new Node(val);
        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        this.size = this.size + 1;
    }

    public void deleteAtIndex(int index) {;
        if(index < 0 || index > this.size - 1) {
            return;
        }

        Node currentNode = dummyNode;
        while(index -- > 0) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = currentNode.nextNode.nextNode;
        this.size = this.size - 1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
