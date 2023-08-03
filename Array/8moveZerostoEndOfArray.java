package Array;

import java.util.ArrayList;

class moveZerostoEndOfArray {

  public static void main(String[] args) {
    int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
    // 1 2 3 2 4 5 1 0 0 0
    int n = arr.length;
    int[] ans = moveZeros(n, arr);
    int[] ans1 = moveZerosOptimise(n, arr);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }
  }

  public static int[] moveZeros(int n, int[] a) {
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (a[i] != 0) {
        temp.add(a[i]);
      }
    }

    int size = temp.size();
    int index = 0;
    for (int i : temp) {
      a[index++] = i;
    }
    for (int i = n - 1; i >= size; i--) {
      a[i] = 0;
    }
    return a;
  }

  public static int[] moveZerosOptimise(int n, int[] a) {
    int j = -1;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        j = i;
        break;
      }
    }
    if (j == -1) return a;
    for (int i = j + 1; i < n; i++) {
      if (a[i] != 0) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        j++;
      }
    }
    return a;
  }
}
