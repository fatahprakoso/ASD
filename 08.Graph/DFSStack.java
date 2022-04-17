class DFSStack {
  class Node {
    Node next;
    AdjacencyList.Vertex data;

    Node(AdjacencyList.Vertex data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node head;
  private int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(AdjacencyList.Vertex data) {
    Node newNode = new Node(data, this.head);
    this.head = newNode;
    size++;
  }

  public AdjacencyList.Vertex pop() {
    if (size == 0) {
      return null;
    }

    AdjacencyList.Vertex keluaran = this.head.data;
    this.head = this.head.next;

    size--;
    return keluaran;
  }

  public int peek() {
    if (size == 0) {
      return Integer.MIN_VALUE;
    }

    return this.head.data.data;
  }

  public void printStack() {
    Node buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.print(buffer.data.data + ",");
      buffer = buffer.next;
    }
  }
}