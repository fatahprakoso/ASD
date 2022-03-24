// array, ll, tree (heap)

/**
 * prioritasnya (prioritas untuk didequeue) adalah data dengan angka terkecil
 * non-preemptive
 * []
 * [3]
 * [3, 4]
 * [3, 1, 4]
 * [3, 0, 1, 4]
 * [0, 1, 4]
 * [0, -1, 1, 4]
 * [-1, 1, 4]
 * [-1, -5, 1, 4]
 * [-1, -5, 1, 2, 4] -> enqueue 2
 *
 * preemptive
 * []
 * [3]
 * [3, 4]
 * [1, 3, 4]
 * [0, 1, 3, 4]
 * [1, 3, 4]
 */

public class PriorityQueue {
  public static void main(String[] args) {
    PriorityQueue queue = new PriorityQueue();

    // * []
    // * [3]
    // * [3, 4]
    // * [3, 1, 4]
    // * [3, 0, 1, 4]
    // * [0, 1, 4]
    // * [0, -1, 1, 4]
    // * [-1, 1, 4]
    // * [-1, -5, 1, 4]
    // * [-1, -5, 1, 2, 4] -> enqueue 2

    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(1);
    queue.enqueue(0);
    System.out.println(queue.dequeue());
    queue.enqueue(-1);
    System.out.println(queue.dequeue());
    queue.enqueue(-5);
    queue.enqueue(2);
    queue.printSLL();
  }

  class Node {
    Node next;
    int data;

    Node(int data, Node next) {
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

  public void enqueue(int data) {
    Node newNode = new Node(data, null);

    if (size == 0) {
      this.head = newNode;
    }

    if (this.head.data > data) {
      // kita insert di belakang head
      newNode.next = this.head.next;
      this.head.next = newNode;
    } else {
      // urutin
      Node sementara = this.head;
      for (int i = 0; i < this.size - 1; i++) {
        if (sementara.next.data > newNode.data) {
          break;
        }
        sementara = sementara.next;
      }

      newNode.next = sementara.next;
      sementara.next = newNode;
    }

    size++;
  }

  public int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue Kosong!");
      return 0;
    }

    int hasil = this.head.data;
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