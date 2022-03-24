public class LinkedQueue {
  // public static void main(String[] args) {
  // LinkedQueue queue = new LinkedQueue();
  // queue.enqueue("1");
  // queue.enqueue("2");
  // queue.enqueue("3");
  // queue.printSLL();
  // System.out.println(queue.dequeue());
  // System.out.println(queue.dequeue());
  // queue.printSLL();
  // System.out.println(queue.dequeue());
  // queue.printSLL();
  // }

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

  public void enqueue(String data) {
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

  public String dequeue() {
    if (isEmpty()) {
      System.out.println("Queue Kosong!");
      return null;
    }

    String hasil = this.head.data;
    this.head = this.head.next;

    size--;
    return hasil;
  }

  public void printSLL() {
    Node buffer = this.head;
    for (int i = 0; i < this.size; i++) {
      System.out.print(buffer.data + ",");
      buffer = buffer.next;
    }

    System.out.println("\nsize: " + this.size);
    System.out.println();
  }
}