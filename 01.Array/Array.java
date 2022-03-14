import java.util.Arrays;

public class Array {
  public static void main(String[] args) {
    // membuat array 1 dimensi
    // #1
    String[] arrayString = new String[10];
    arrayString[0] = "ini index ke-0";
    System.out.println(Arrays.toString(arrayString));

    // #2
    int[] arrayInteger = { 1, 2, 3, 4, 5, 6, 7 };
    System.out.println(Arrays.toString(arrayInteger));

    // membuat array 2 dimensi
    // #1
    String[][] array2dString = new String[10][5];
    System.out.println(Arrays.deepToString(array2dString));

    // #2
    int[][] array2dInteger = { { 1, 2, 3, 4 }, { 3, 2, 1, 5 }, { 1, 2, 3 },
        {}, {} };
    System.out.println(Arrays.toString(array2dInteger));
    System.out.println(Arrays.deepToString(array2dInteger));

    // deepToString untuk array lebih dari 1 dimenis
    // toString cocok untuk array 1 dimensi

    // int[][][][][] array5d = new int[1][2][3][4][5];
    // System.out.println(Arrays.deepToString(array5d));

    // String[] arrayString = new String[10];
    // System.out.println(arrayString.length);

    // int[] arrayInteger = { 1, 2, 3, 4, 5, 6, 7 };

    // for (int i = 0; i < arrayInteger.length; i++) {
    // System.out.println(arrayInteger[i]);
    // }

    // int[] arrayAcak1 = { 4, 1, 7, 4, 9, 3 };
    // int[] arrayAcak2 = { 4, 1, 7, 4, 9, 3 };
    // int[] arrayAcak3 = { 7, 4, 9, 3 };
    // System.out.println(Arrays.equals(arrayAcak1, arrayAcak2));
    // System.out.println(Arrays.equals(arrayAcak1, arrayAcak3));

    // // int[][] array2dInteger = { { 1, 2, 3, 4 }, { 3, 2, 1, 5 }, { 1, 2, 3, 4 }
    // };
    // int[] arrayInteger = { 1, 2, 3, 4, 5, 6, 7 };
    // System.out.println(arrayInteger[0]); // 0 hingga index terakhir (panjang
    // array - 1)

    // System.out.println(array2dInteger.length); // jumlah baris array
    // System.out.println(array2dInteger[0].length);

    // String[][] array2dString = new String[10][5];
    // System.out.println(array2dString.length);
    // System.out.println(array2dString[array2dString.length-1]);
  }
}