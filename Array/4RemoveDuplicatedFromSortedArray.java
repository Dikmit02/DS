package Array;

import java.util.HashSet;
import java.util.Set;

class RemoveDuplicatedFromSortedArray {

  public static void main(String[] args) {
    int[] array = { 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6 };
    int ans1 = Brute(array);
    int ans2 = Better();
    System.out.println(ans2);
  }

  public static int Brute(int[] arr) {
    // 	Time complexity: O(n*log(n))+O(n)

    // Space Complexity: O(n)
    Set<Integer> keys = new HashSet<>();
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      keys.add(arr[i]);
    }

    int size = keys.size();
    int index = 0;
    for (int i : keys) {
      arr[index++] = i;
    }
    return size;
  }

  public static int Better() {
    int[] arr = { 1, 1, 2 };
    int start = arr[0];
    int index = 0;
    for (int i = 1; i < arr.length; i++) {
      if (start != arr[i]) {
        ++index;
        arr[index] = arr[i];
        start = arr[i];
      }
    }
    return index + 1;
  }
}
