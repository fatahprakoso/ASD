public class HashTable {
  private PairValue[] hashArray;
  private int hSize; // ukuran hashArray
  private int dataSize; // jumlah data yang tersimpan di hashArray

  public HashTable(int hSize) {
    hashArray = new PairValue[hSize];
    this.hSize = hSize;
  }

  class PairValue {
    String key;
    Mahasiswa m;

    public PairValue(String key, Mahasiswa m) {
      this.key = key;
      this.m = m;
    }
  }

  private int hashFun(String key) {
    int count = 0;
    for (int i = 0; i < key.length(); i++) {
      // tif
      // 116 + 105 + 102 = 323
      count += (int) key.charAt(i);
    }

    // hSize = 100
    // count % hSize = 323 % 100 = 23
    return count % hSize;
  }

  public boolean insert(String key, Mahasiswa m) {
    if (hSize == dataSize) {
      return false;
    }

    int index = hashFun(key);
    PairValue newPair = new PairValue(key, m);

    for (int i = 0; i < this.hSize; i++) {
      if (this.hashArray[index] == null || this.hashArray[index].key == null) {
        this.hashArray[index] = newPair;
        this.dataSize++;
        return true;
      }

      if (index == this.hSize - 1)
        index = 0;
      index++;
    }

    return false;
  }

  public boolean delete(String key) {

    if (this.hSize == 0)
      return false;

    int index = hashFun(key);

    for (int i = 0; i < this.hashArray.length; i++) {
      if (this.hashArray[index] == null)
        return false;

      if (this.hashArray[index].key != null && this.hashArray[index].key.equals(key)) {
        this.hashArray[index].key = null;
        this.dataSize--;
        return true;
      }

      if (index == this.hashArray.length - 1)
        index = 0;
      index++;
    }
    return false;
  }

  public Mahasiswa get(String key) {
    if (this.dataSize == 0)
      return null;

    int index = hashFun(key);
    for (int i = 0; i < this.hSize; i++) {
      if (this.hashArray[index] == null)
        return null;

      if (this.hashArray[index].key != null && this.hashArray[index].key.equals(key)) {
        return this.hashArray[index].m;
      }

      if (index == this.hSize - 1)
        index = 0;
      index++;
    }
    return null;

  }

  public void print() {
    for (int i = 0; i < hashArray.length; i++) {
      if (hashArray[i] == null || hashArray[i].key == null) {
        System.out.println("null");
        continue;
      }
      System.out.printf("%s : %s -> %s\n", hashArray[i].key, hashArray[i].m.nama, hashArray[i].m.nim);
    }
  }

  public static void main(String[] args) {
    Mahasiswa m1 = new Mahasiswa("32483485", "Andi");
    Mahasiswa m2 = new Mahasiswa("90367903", "Budi");
    Mahasiswa m3 = new Mahasiswa("09740465", "Ali");
    HashTable hTable = new HashTable(4);

    // insert
    hTable.insert("Mahasiswa kupu-kupu", m1);
    hTable.insert("Mahasiswa organsisasi!!", m2);
    hTable.insert("Mahasiswa biasaa!", m3);
    hTable.print();

    // delete
    hTable.delete("Mahasiswa biasaa!");
    System.out.println();
    hTable.print();

    // get
    System.out.println();
    System.out.println(hTable.get("Mahasiswa kupu-kupu").nama);
    System.out.println(hTable.get("Mahasiswa kupu"));
    System.out.println(hTable.get("Mahasiswa organsisasi!!").nama);
  }
}

class Mahasiswa {
  String nim;
  String nama;

  Mahasiswa(String nim, String nama) {
    this.nim = nim;
    this.nama = nama;
  }
}