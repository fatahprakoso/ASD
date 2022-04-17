class DFSStack {
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

  public void push(AdjacencyList data) {
    Node newNode = new Node(data, this.head);
    this.head = newNode;
    size++;
  }

  public AdjacencyList pop() {
    if (size == 0) {
      return null;
    }

    AdjacencyList keluaran = this.head.data;
    this.head = this.head.next;

    size--;
    return keluaran;
  }

  public int peek() {
    if (size == 0) {
      return Integer.MIN_VALUE;
    }

    return this.head.data.getHead().data;
  }

  public void printStack() {
    Node buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.println(buffer.data);
      buffer = buffer.next;
    }

    System.out.println("size: " + this.size);
  }
}