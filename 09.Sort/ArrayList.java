import java.util.Arrays;

public class ArrayList {
  // digunakan untuk menyimpan data
  private int[] data;

  /**
   * digunakan untuk menghitung indeks terkecil dari indeks array kosong saat
   * ini atau dengan kata lain jumlah data
   */
  private int count;

  // digunakan untuk menyimpan ukuran array yang nantinya akan selalu diupdate
  private int size;

  int swapCount;
  int loopCount;

  // constructor
  public ArrayList(int size) {
    this.data = new int[size];
    this.size = size;
    this.count = 0;
  }

  public ArrayList() {
    this.data = new int[10];
    this.size = 10;
    this.count = 0;
  }
  // ===========================================================================

  // getter
  public int getSize() {
    return this.size;
  }

  public int getDataSize() {
    return this.count;
  }

  public boolean isFull() {
    return this.size == this.count;
  }
  // ===========================================================================

  // menambah kapasitas dari array data
  private void resize() {
    this.size *= 2;
    int[] resize = new int[this.size];
    for (int i = 0; i < this.data.length; i++) {
      resize[i] = data[i];
    }
    this.data = resize;
  }

  // menyisipkan data
  public void insert(int data) {
    if (isFull()) {
      resize();
    }
    this.data[this.count] = data;
    this.count++;
  }

  public void insert(int... data) {
    for (int i : data) {
      insert(i);
    }
  }
  // ===========================================================================

  // menduplikat array
  private int[] copyArray(int[] arr) {
    int[] result = new int[this.count];
    for (int i = 0; i < this.count; i++) {
      result[i] = this.data[i];
    }
    return result;
  }

  // melakukan pertukaran data pada 2 indeks array
  private void swap(int[] arr, int index1, int index2) {
    int buffer = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = buffer;
    swapCount++;
  }

  public int[] bubbleSort() {
    swapCount = 0;
    loopCount = 0;
    int[] result = copyArray(this.data);
    boolean sorted = false;
    int unsortedRange = this.count;

    do {
      sorted = true;
      for (int i = 1; i < unsortedRange; i++) {
        loopCount++;
        if (result[i - 1] > result[i]) {
          swap(result, i - 1, i);
          sorted = false;
        }
      }
      unsortedRange--;
    } while (!sorted);

    printSorted(result, "Bubble Sort");
    return result;
  }

  public int[] shellSort(int k, int decrement) {
    swapCount = 0;
    loopCount = 0;
    int[] result = copyArray(this.data);
    boolean sorted = false;

    do {
      sorted = true;
      for (int i = k; i < this.count; i++) {
        loopCount++;
        if (result[i - k] > result[i]) {
          swap(result, i - k, i);
          sorted = false;
        }
      }

      if (k - decrement > 1) {
        k -= decrement;
        sorted = false;
      } else {
        if (k > 1)
          sorted = false;
        k = 1;
      }
    } while (!sorted);

    printSorted(result, "Shell Sort");
    return result;
  }

  public int[] selectionSort() {
    swapCount = 0;
    loopCount = 0;
    int[] result = copyArray(this.data);
    int sortingRange = this.count;

    while (sortingRange != 1) {
      int max = Integer.MIN_VALUE;
      int index = -1;
      for (int i = 0; i < sortingRange; i++) {
        loopCount++;
        if (max < result[i]) {
          max = result[i];
          index = i;
        }
      }

      if (index != -1) {
        swap(result, index, sortingRange - 1);
      }

      sortingRange--;
    }

    printSorted(result, "Selection Sort");
    return result;
  }

  public int[] insertionSort() {
    swapCount = 0;
    loopCount = 0;
    int[] result = copyArray(this.data);
    int pivotIndex = 0;

    while (pivotIndex != this.count - 1) {
      loopCount++;
      if (result[pivotIndex] > result[pivotIndex + 1]) {
        loopCount--;
        for (int i = pivotIndex; i >= 0; i--) {
          loopCount++;
          if (result[i] < result[i + 1])
            break;
          swap(result, i, i + 1);
        }
      }
      pivotIndex++;
    }

    printSorted(result, "Insertion Sort");
    return result;
  }

  // print data pada array data
  public void print() {
    System.out.println("Array:");
    for (int i : data) {
      if (i == 0)
        break;
      System.out.print(i + ",");
    }
    System.out.println();
  }

  // print data pada array yang sudah disorting
  private void printSorted(int[] arr, String sortAlgorithm) {
    System.out.printf("Sorted Array (%s):\n", sortAlgorithm);
    for (int i : arr) {
      System.out.print(i + ",");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ArrayList list = new ArrayList(3);
    list.insert(3, 1, 6, 4, 9, 5, 8, 10, 53, 11, 76);
    list.print();
    System.out.println();
    list.bubbleSort();
    System.out.println("swap: " + list.swapCount);
    System.out.println("loop: " + list.loopCount);
    System.out.println();
    list.shellSort(10, 2);
    System.out.println("swap: " + list.swapCount);
    System.out.println("loop: " + list.loopCount);
    System.out.println();
    list.selectionSort();
    System.out.println("swap: " + list.swapCount);
    System.out.println("loop: " + list.loopCount);
    System.out.println();
    list.insertionSort();
    System.out.println("swap: " + list.swapCount);
    System.out.println("loop: " + list.loopCount);
  }
}
