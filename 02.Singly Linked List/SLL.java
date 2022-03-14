public class SLL {
  public static void main(String[] args) {
    SLL sll = new SLL();

    sll.addFirst("satu");
    sll.addFirst("dua");
    sll.addFirst("tiga");
    sll.addLast("nol");

    sll.printSLL();
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

  public void addFirst(String data) {
    Node newNode = new Node(data, this.head);
    this.head = newNode;
    size++;
  }

  public void addLast(String data) {
    Node newNode = new Node(data, null);

    Node buffer = this.head;
    for (int i = 0; i < this.size - 1; i++) {
      buffer = buffer.next;
    }

    buffer.next = newNode;

    size++;
  }

  public void printSLL() {
    Node buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.println(buffer.data);
      buffer = buffer.next;
    }
    System.out.println("size: " + this.size);
  }
}
