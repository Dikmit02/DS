package sorting;

class bubbleSort {

  // O(N*N)=> worst average
  // O(n)=> best
  public static void main(String[] args) {
    int[] arr = { 13, 46, 24, 52, 46, 20, 9, 12, 8, 22 };
    int n = arr.length;

    for (int i = n - 1; i >= 1; i--) {
      boolean swapped = false;
      for (int j = 0; j <= i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        System.out.print("Array is already sorted");
        return;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
