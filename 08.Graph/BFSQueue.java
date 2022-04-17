class BFSQueue {
  class Node {
    Node next;
    AdjacencyList data;

    Node(AdjacencyList data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node head;
  private int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(AdjacencyList data) {
    Node newNode = new Node(data, null);

    if (size == 0) {
      this.head = newNode;
    }

    Node buffer = this.head;
    for (int i = 0; i < this.size - 1; i++) {
      buffer = buffer.next;
    }

    buffer.next = newNode;

    size++;
  }

  public AdjacencyList dequeue() {
    if (isEmpty()) {
      return null;
    }

    AdjacencyList hasil = this.head.data;
    this.head = this.head.next;

    size--;
    return hasil;
  }

  public int peak() {
    if (isEmpty()) {
      return Integer.MIN_VALUE;
    }

    return this.head.data.getHead().data;
  }

  public void printqueue() {
    Node buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.print(buffer.data + ",");
      buffer = buffer.next;
    }
  }
}