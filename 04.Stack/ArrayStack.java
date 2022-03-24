class Main {
  public static void main(String[] args) {
    ArrayStack stack = new ArrayStack();
    // count = 0

    stack.push("data1");
    // count = 1

    stack.push("data2");
    // count = 2

    stack.push("data3");
    // count = 3

    // count = 3
    // [data1, data2, data3, null]
    System.out.println(stack.pop());
    // count = 2
    // keluaran = data[2]
    // keluaran = data3
    // data[2] = null
    // return keluaran

    // count = 2
    // [data1, data2]
    System.out.println(stack.pop());
    // count = 1
    // keluaran = data[1]
    // keluaran = data2
    // data[1] = null
    // return keluaran

    // [data1]
    stack.print();
  }
}

public class ArrayStack {
  final int STACKSIZE = 100;
  String[] data = new String[STACKSIZE];
  int count;

  public String pop() {
    if (count == 0) {
      System.out.println("stacknya kosong");
      return null;
    }

    this.count--;
    String keluaran = this.data[count];
    this.data[count] = null;
    return keluaran;
  }

  public void push(String data) {
    if (count == STACKSIZE - 1) {
      System.out.println("Stack full");
      return;
    }

    this.data[count] = data;
    this.count++;
  }

  public void print() {
    System.out.println(count);
    for (int i = 0; i < count; i++) {
      System.out.print(data[i] + ", ");
    }
  }
}
