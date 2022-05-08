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

  private boolean isFull() {
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

  private void swap(int[] arr, int indeks1, int indeks2) {
    int buffer = arr[indeks1];
    arr[indeks1] = arr[indeks2];
    arr[indeks2] = buffer;
  }

  public void bubbleSort() {
    int[] result = copyArray(this.data);
    boolean sorted = false;

    do {
      sorted = true;
      for (int i = 1; i < result.length; i++) {
        if (result[i - 1] > result[i]) {
          swap(result, i - 1, i);
          sorted = false;
        }
      }
    } while (!sorted);

    printSorted(result, "Bubble Sort");
  }

  public void shellSort(int k, int d) {
    int[] result = copyArray(this.data);
    boolean sorted = false;

    do {
      sorted = true;
      for (int i = k; i < result.length; i++) {
        if (result[i - k] > result[i]) {
          swap(result, i - k, i);
          sorted = false;
        }
      }

      if (k - d > 1) {
        sorted = false;
        k -= d;
      } else {
        if (k > 1)
          sorted = false;
        k = 1;
      }
    } while (!sorted);

    printSorted(result, "Shell Sort");
  }

  public int[] selectionSort() {
    int[] result = copyArray(this.data);
    int sortingRange = this.count;

    while (sortingRange != 1) {
      int max = Integer.MIN_VALUE;
      int index = -1;
      for (int i = 0; i < sortingRange; i++) {
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

  // insertion sort, heap sort
  public int[] insertionSort() {
    int[] result = copyArray(this.data);
    int pivotIndex = 0;

    while (pivotIndex != this.count - 1) {
      if (result[pivotIndex] > result[pivotIndex + 1]) {
        for (int i = pivotIndex; i >= 0; i--) {
          if (result[i] < result[i + 1]) {
            break;
          }

          swap(result, i, i + 1);
        }
      }

      pivotIndex++;
    }

    printSorted(result, "Insertion Sort");
    return result;
  }

  public static void main(String[] args) {
    ArrayList list = new ArrayList(2);
    list.insert(25, 27, 10, 8, 76, 21);
    list.print();
    list.bubbleSort();
    list.shellSort(4, 2);
    list.selectionSort();
    list.insertionSort();

    HeapTree heapList = new HeapTree(25, 27, 10, 8, 76, 21);
    System.out.println("Sorted Array (Heap Sort):");
    heapList.sort();
  }

}
