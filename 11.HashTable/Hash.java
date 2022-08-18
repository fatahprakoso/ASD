import java.util.ArrayList;
import java.util.Scanner;

public class Hash {

  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    int inputCount = in.nextInt();
    String[] input = new String[inputCount];

    for (int i = 0; i < inputCount; i++)
      input[i] = in.next();

    ArrayList<String>[] hashTable = insertToHashTable(input);
    printHashTable(hashTable);
  }

  private static ArrayList<String>[] insertToHashTable(String... data) {
    ArrayList<String>[] hashTable = new ArrayList[11];

    for (String aData : data) {
      int indeks = hashFunction(aData, 11);

      if (hashTable[indeks] == null)
        hashTable[indeks] = new ArrayList<String>();

      hashTable[indeks].add(aData);
    }

    return hashTable;
  }

  private static void printHashTable(ArrayList<String>[] hashTable) {
    for (int i = 0; i < hashTable.length; i++) {
      System.out.printf("[%d]", i);
      if (hashTable[i] != null)
        for (int j = 0; j < hashTable[i].size(); j++) {
          System.out.printf(" -> [%s]", hashTable[i].get(j));
        }
      System.out.println();
    }
  }

  private static int hashFunction(String data, int arraySize) {
    int indeks = 0;
    for (int i = 0; i < data.length(); i++) {
      indeks += (int) data.charAt(i);
    }

    return indeks % arraySize;
  }
}