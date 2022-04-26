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

  // print data pada array data
  public void printArray() {
    System.out.println("Array:");
    for (int i : data) {
      System.out.print(i + ",");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ArrayList list = new ArrayList(3);
    list.printArray();
    list.insert(3);
    list.insert(2);
    list.insert(5);
    list.printArray();
    list.insert(1);
    list.insert(8);
    list.insert(7);
    list.printArray();
    list.insert(3);
    list.insert(2);
    list.insert(5);
    list.printArray();
  }
}
