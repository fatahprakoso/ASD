import java.util.Arrays;

public class ArrayQueue {
  private String[] data;
  private int rear;
  private int size;

  ArrayQueue(int size) {
    this.size = size;
    this.data = new String[size];
  }

  public void enqueue(String data) {
    if (size == rear) {
      System.out.println("Queue sudah penuh");
      return;
    }

    this.data[this.rear] = data;
    this.rear++;
  }

  public String dequeue() {
    if (rear == 0) {
      System.out.println("Queue masih kosong");
      return null;
    }

    String hasil = this.data[0];
    leftshift();
    this.rear--;
    this.data[this.rear] = null;

    return hasil;
  }

  private void leftshift() {
    for (int i = 1; i < data.length; i++) {
      this.data[i - 1] = this.data[i];
    }
  }

  public void print() {
    System.out.println(Arrays.toString(this.data));
  }

  // public static void main(String[] args) {
  // ArrayQueue queue = new ArrayQueue(6);
  // queue.enqueue("data1");
  // queue.enqueue("data2");
  // queue.enqueue("data3");
  // queue.enqueue("data4");
  // queue.enqueue("data2");
  // queue.enqueue("data3");
  // queue.enqueue("data4");
  // queue.print();
  // System.out.println(queue.dequeue());
  // System.out.println(queue.dequeue());
  // queue.print();
  // }
}
