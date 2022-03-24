class Main {
  public static void main(String[] args) {
    LinkedStack stack = new LinkedStack();

    // keluar (pop) dan masuknya (push) sama

    // []
    stack.push("1");
    // [1]

    // [1]
    stack.push("2");
    // [2, 1]

    // [2, 1]
    stack.push("3");
    // [3, 2, 1]

    // [3, 2, 1]
    System.out.println(stack.pop());
    // [2, 1]

    // [2, 1]
    System.out.println(stack.pop());
    // [1]

    stack.printSLL();
  }
}

public class LinkedStack {
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

  public void push(String data) {
    Node newNode = new Node(data, this.head);
    this.head = newNode;
    size++;
  }

  public String pop() {
    if (size == 0) {
      System.out.println("stack kosong");
      return null;
    }

    // 1. mengambil data dari head node
    String keluaran = this.head.data;

    // 2. mengupdate head node baru
    this.head = this.head.next;
    // node2 -> node3 -> node4
    // ^

    size--;

    // 3. keluarkan data yang telah diambil dari head node
    return keluaran;
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
