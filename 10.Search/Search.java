public class Search {
  public static void main(String[] args) {
    int[] array = { 3, 5, 4, 2, 1, 9 };

    // System.out.println(search(9, array));
    System.out.println(binarySearch(1, array));
    System.out.println(binarySearch(2, array));
    System.out.println(binarySearch(3, array));
    System.out.println(binarySearch(4, array));
    System.out.println(binarySearch(5, array));
    System.out.println(binarySearch(9, array));
  }

  public static int search(int key, int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (key == array[i])
        return i;
    }
    return -1;
  }

  public static boolean binarySearch(int key, int[] array) {

    // bubble sort
    boolean sorted = false;

    do {
      sorted = true;
      for (int i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]) {
          int buffer = array[i];
          array[i] = array[i - 1];
          array[i - 1] = buffer;
          sorted = false;
        }
      }
    } while (!sorted);
    // ------------------------------------------------------------------------

    // binary search
    int ukuranArray = array.length;
    int indeks;

    indeks = ukuranArray / 2;
    if (array[indeks] == key)
      return true;
    else if (array[indeks] > key) {
      return binarySearch(key, array, 0, indeks - 1);
    } else if (array[indeks] < key) {
      return binarySearch(key, array, indeks + 1, ukuranArray - 1);
    }

    return false;
  }

  public static boolean binarySearch(int key, int[] array, int startIndex, int endIndex) {
    int indeks = startIndex + ((endIndex - startIndex) / 2);

    if (startIndex > endIndex)
      return false;

    if (array[indeks] == key)
      return true;
    else if (array[indeks] > key) {
      return binarySearch(key, array, startIndex, indeks - 1);
    } else if (array[indeks] < key) {
      return binarySearch(key, array, indeks + 1, endIndex);
    }

    return false;
  }
}