public class CLL {
  public static void main(String[] args) {
    CLL cll = new CLL();
    cll.addLast("1");
    cll.addLast("2");
    cll.addLast("3");

    cll.printSLL();
  }

  class Node {
    Node next;
    String data;

    Node(String data, Node next) {
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

  public void addLast(String data) {
    Node newNode = new Node(data, null);

    if (size == 0) {
      this.head = newNode;
      this.head.next = this.head;
    } else {
      Node buffer = this.head;
      for (int i = 0; i < this.size - 1; i++) {
        buffer = buffer.next;
      }

      buffer.next = newNode;
      newNode.next = this.head;
    }
    size++;
  }

  public void printSLL() {
    Node buffer = this.head;
    for (int i = 0; i < this.size + 50; i++) {
      System.out.println(buffer.data);
      buffer = buffer.next;
    }
    System.out.println("size: " + this.size);
  }
}