package Array;

class LeftRotateanarraybyoneplace {

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6 };

    int[] ans2 = Better(array);
    for (int i = 0; i < ans2.length; i++) {
      System.out.print(ans2[i] + " ");
    }
  }

  public static int[] Better(int[] arr) {
    int n = arr.length;
    int temp = arr[0];

    for (int j = 1; j < n; j++) {
      arr[j - 1] = arr[j];
    }
    arr[n - 1] = temp;

    return arr;
  }
}
