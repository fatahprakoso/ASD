public class HashTable {
  private Node[] data;
  private int size;
  private int hSize;

  public HashTable(int size) {
    data = new Node[size];
    hSize = size;
  }

  private class Node {
    String key;
    Mahasiswa data;

    Node(String key, Mahasiswa data) {
      this.key = key;
      this.data = data;
    }
  }

  private int hashFunc(String key) {
    int count = 0;
    for (int i = 0; i < key.length(); i++) {
      count += (int) key.charAt(i);
    }
    return count % hSize;
  }

  public boolean insert(String key, Mahasiswa data) {

    if (this.size == this.hSize)
      return false;

    int index = hashFunc(key);
    Node newNode = new Node(key, data);
    for (int i = 0; i < this.data.length; i++) {
      if (this.data[index] == null || this.data[index].key == null) {
        this.data[index] = newNode;
        this.size++;
        return true;
      }

      if (index == this.data.length - 1)
        index = 0;
      index++;
    }

    return false;
  }

  public boolean delete(String key) {

    if (this.size == 0)
      return false;

    int index = hashFunc(key);
    for (int i = 0; i < this.data.length; i++) {
      if (this.data[index] == null)
        return false;

      if (this.data[index].key != null && this.data[index].key.equals(key)) {
        this.data[index].key = null;
        this.size--;
        return true;
      }

      if (index == this.data.length - 1)
        index = 0;
      index++;
    }
    return false;
  }

  public Mahasiswa get(String key) {

    if (this.size == 0)
      return null;

    int index = hashFunc(key);
    for (int i = 0; i < this.data.length; i++) {
      if (this.data[index] == null)
        return null;

      if (this.data[index].key != null && this.data[index].key.equals(key)) {
        this.data[index].key = null;
        return this.data[index].data;
      }

      if (index == this.data.length - 1)
        index = 0;
      index++;
    }
    return null;
  }

  public void print() {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == null || data[i].key == null) {
        System.out.println("null");
        continue;
      }
      System.out.printf("%s : %s (%f) -> %s\n", data[i].key, data[i].data.nama, data[i].data.ipk, data[i].data.nim);
    }
  }

  public static void main(String[] args) {
    Mahasiswa m1 = new Mahasiswa("2053451234", "Yayan", 3.5);
    Mahasiswa m2 = new Mahasiswa("2053453454", "Denny", 2.5);
    Mahasiswa m3 = new Mahasiswa("2053455671", "Dian", 3.9);
    Mahasiswa m4 = new Mahasiswa("9832746863", "Desta", 3.0);
    HashTable hTable = new HashTable(5);
    hTable.insert("mahasiswa kupu-kupu", m1);
    hTable.insert("mahasiswa kura-kura", m2);
    hTable.insert("mahasiswa kunang-kunang", m3);
    hTable.insert("mahasiswa biasaaa", m4);
    hTable.print();
    hTable.delete("mahasiswa kura-kura");
    hTable.delete("mahasiswa biasaaa");
    hTable.delete("mahasiswa biasaaa");
    System.out.println();
    hTable.print();
    hTable.insert("mahasiswa kura-kura", m2);
    hTable.insert("mahasiswa biasaaa", m4);
    System.out.println();
    hTable.print();
    System.out.println(hTable.get("mahasiswa kupu-kupu").nama);
    System.out.println(hTable.get("mahasiswa kura-kura").nama);
    System.out.println(hTable.get("mahasiswa kunang-kunang").nama);
    System.out.println(hTable.get("mahasiswa biasaaa").nama);
  }
}

class Mahasiswa {
  String nim;
  String nama;
  double ipk;

  public Mahasiswa(String nim, String nama, double ipk) {
    this.nim = nim;
    this.nama = nama;
    this.ipk = ipk;
  }
}
