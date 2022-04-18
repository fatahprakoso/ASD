
class AdjacencyList {
  class Vertex {
    Vertex next;
    int data;
    int index;

    Vertex(int data, Vertex next, int index) {
      this.data = data;
      this.next = next;
      this.index = index;
    }
  }

  private Vertex head = null;
  private Vertex tail = null;
  private int size;

  AdjacencyList(int head, int index) {
    this.head = new Vertex(head, null, index);
    this.tail = this.head;
    this.size++;
  }

  AdjacencyList() {
  }

  public Vertex getHead() {
    return this.head;
  }

  public Vertex getTail() {
    return this.tail;
  }

  public void insert(int data, int index) {
    Vertex v = new Vertex(data, null, index);
    if (size == 0) {
      this.head = v;
      this.tail = this.head;
    } else {
      this.tail.next = v;
      this.tail = v;
    }
    this.size++;
  }

  public Vertex search(int key) {
    Vertex buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      if (buffer.data == key)
        return buffer;
      else
        buffer = buffer.next;
    }
    return null;
  }

  public void print() {
    Vertex buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.print(buffer.data + ",");
      buffer = buffer.next;
    }
    System.out.println();
  }
}
