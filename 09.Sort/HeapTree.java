public class HeapTree {
  // Digunakan untuk menyimpan data
  private int[] heap;

  private int dataSize;

  // Digunakan untuk meresize array heap
  private int nodeIncrementPower;

  public HeapTree() {
    this.heap = new int[(int) Math.pow(2, nodeIncrementPower)];
    this.heap[0] = Integer.MIN_VALUE;
  }

  public HeapTree(int... data) {
    this.heap = new int[(int) Math.pow(2, nodeIncrementPower)];
    this.heap[0] = Integer.MIN_VALUE;
    insert(data);
  }

  private int getParentIndex(int index) {
    return (int) Math.ceil((index - 1) / 2);
  }

  private int getLeftChildIndex(int index) {
    return 2 * index + 1;
  }

  private int getRightChildIndex(int index) {
    return 2 * index + 2;
  }

  private void resizeHeapArray() {
    int[] resize = new int[this.heap.length + (int) Math.pow(2, ++nodeIncrementPower)];
    for (int i = 0; i < resize.length; i++) {
      if (i < this.heap.length) {
        resize[i] = this.heap[i];
      } else {
        resize[i] = Integer.MIN_VALUE;
      }
    }
    this.heap = resize;
  }

  private void swap(int index1, int index2) {
    int temp = this.heap[index1];
    this.heap[index1] = this.heap[index2];
    this.heap[index2] = temp;
  }

  public void insert(int data) {
    if (this.dataSize == this.heap.length)
      resizeHeapArray();

    this.heap[this.dataSize] = data;

    int pointer = this.dataSize;

    while (this.heap[pointer] < this.heap[getParentIndex(pointer)]) {
      swap(pointer, getParentIndex(pointer));
      pointer = getParentIndex(pointer);
    }

    this.dataSize++;
  }

  public void insert(int... data) {
    for (int i : data) {
      insert(i);
    }
  }

  public void heapify(int index) {
    int target = index;

    int leftTarget = getLeftChildIndex(index);
    leftTarget = leftTarget >= this.dataSize ? -1 : leftTarget;

    int rightTarget = getRightChildIndex(index);
    rightTarget = rightTarget >= this.dataSize ? -1 : rightTarget;

    int minimum;

    if (leftTarget != -1 && rightTarget != -1) {
      if (this.heap[leftTarget] > this.heap[rightTarget])
        minimum = rightTarget;
      else
        minimum = leftTarget;
    } else if (leftTarget != -1) {
      minimum = leftTarget;
    } else if (rightTarget != -1) {
      minimum = rightTarget;
    } else
      return;

    if (this.heap[minimum] < this.heap[target]) {
      swap(target, minimum);
      heapify(minimum);
    }
  }

  private int extractMin() {
    int result;
    if (dataSize != 0) {
      result = this.heap[0];
      this.heap[0] = this.heap[--this.dataSize];
      this.heap[this.dataSize] = Integer.MIN_VALUE;
      heapify(0);
    } else
      result = Integer.MIN_VALUE;
    return result;
  }

  public void sort() {
    int result = extractMin();
    while (result != Integer.MIN_VALUE) {
      System.out.print(result + ",");
      result = extractMin();
    }
    System.out.println();
  }

  public void printArray() {
    for (int i : this.heap) {
      System.out.print(i + ",");
    }
    System.out.println();
  }
}
