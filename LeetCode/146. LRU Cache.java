class LRUCache {
  Node head;
  Node tail;

  int size;
  int capacity;
  Map < Integer, Node > data;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    Node dummyHead = new Node(-1, -1);
    this.head = dummyHead;

    this.data = new HashMap<>(capacity);
  }

  public int get(int key) {
    Node tempNode = data.get(key);
    if (tempNode == null) {
      return -1;
    }

    int result = tempNode.val;
    if (tempNode.key != head.next.key) {
      swapLastUsedToHeadNode(tempNode);
    }

    data.put(tempNode.key, tempNode);
    return result;
  }

  public void put(int key, int value) {
    Node newNode = new Node(key, value);
    insert(newNode);

    if (this.size > this.capacity) {
      removeLeastRecentlyUsed();
    }
  }

  private void insert(Node newNode) {
    if (data.containsKey(newNode.key)) {
      Node tempNode = data.get(newNode.key);
      if (newNode.key == tempNode.key) {
        tempNode.val = newNode.val;
        swapLastUsedToHeadNode(tempNode);

        data.put(newNode.key, tempNode);
        return;
      }
    }

    newNode.next = this.head.next;

    if (this.head.next != null) {
      this.head.next.prev = newNode;
    }
    this.head.next = newNode;

    newNode.prev = this.head;
    this.size += 1;
    data.put(newNode.key, newNode);

    if (tail == null) {
      this.tail = newNode;
    }
  }

  private void swapLastUsedToHeadNode(Node tempNode) {
    if (tempNode.key != head.next.key) {
          if (tempNode.key == tail.key) {
            this.tail = tempNode.prev;
            tail.next = null;

            tempNode.next = head.next;
            if (this.head.next != null) {
              this.head.next.prev = tempNode;
            }
            this.head.next = tempNode;
            tempNode.prev = this.head;
          } else {
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;

            tempNode.next = head.next;
            if (this.head.next != null) {
              this.head.next.prev = tempNode;
            }
            head.next = tempNode;
            tempNode.prev = head;
          }
        }
  }

  private void removeLeastRecentlyUsed() {
    data.remove(tail.key);

    this.tail = this.tail.prev;
    this.tail.next = null;
    this.size -= 1;
    data.put(tail.key, tail);
  }
}

class Node {
  int key;
  int val;

  Node prev;
  Node next;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
