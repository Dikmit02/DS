package sorting;

import java.util.ArrayList;

// O(N logN)=> worst average best
// O(N)=> space
public class _4MergeSort {

  public static void main(String[] args) {
    //Divide and merge
    int[] arr = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
    int n = 7;
    mergeSort(arr, 0, n - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void mergeSort(int[] arr, int low, int high) {
    if (low >= high) return;
    int mid = low + (high - low) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    mergeArray(arr, low, mid, high);
  }

  public static void mergeArray(int[] arr, int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    ArrayList<Integer> temp = new ArrayList<Integer>();

    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
        right++;
      }
    }
    while (left <= mid) {
      temp.add(arr[left]);
      left++;
    }
    while (right <= high) {
      temp.add(arr[right]);
      right++;
    }

    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }
  }
}
