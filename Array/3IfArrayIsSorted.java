package Array;

class IfArrayIsSorted {

  public static void main(String[] args) {
    int[] array = { 7, 2, 7, 5, 1, 3, 7 };
    boolean ans1 = Brute(array);
    System.out.println(ans1);
  }

  public static boolean Brute(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[i]) return false;
      }
    }

    return true;
  }
}
