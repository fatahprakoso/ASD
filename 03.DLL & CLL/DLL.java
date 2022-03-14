class Main {
  public static void main(String[] args) {
    DLL dll = new DLL();
    dll.insertFirst(5);
    dll.insertFirst(4);
    dll.insertFirst(3);
    dll.insertFirst(2);
    dll.insertFirst(1);
    dll.insertFirst(0);

    dll.print();
  }
}

class DLL {
  class Node {
    // pointernya ada 2, yaitu next dan prev
    Node next, prev;
    int data;

    Node(int data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
  }

  Node head = null;
  Node tail = null;
  int size;

  public void insertFirst(int data) {
    if (size == 0) {
      this.head = new Node(data, null, null);
      this.tail = this.head;
    } else {
      Node newNode = new Node(data, this.head, null);
      this.head.prev = newNode;
      this.head = newNode;
    }
    this.size++;
  }

  public void print() {
    Node buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.println(buffer.data);
      buffer = buffer.next;
    }

    Node buffer2 = this.tail;
    for (int i = this.size - 1; i >= 0; i--) {
      System.out.println(buffer2.data);
      buffer2 = buffer2.prev;
    }

    System.out.println("size: " + this.size);
  }
}