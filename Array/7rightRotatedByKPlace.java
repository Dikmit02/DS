package Array;

class rightRotatedByKPlace {

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6, 7 };
    int k = 3;
    // int[] ans1 = Brute(array, k);
    Optimsed(array, k);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static void Optimsed(int[] arr, int k) {
    int n = arr.length;
    reverse(arr, n - k, n - 1);
    reverse(arr, 0, n - k - 1);
    reverse(arr, 0, arr.length - 1);
  }

  public static void reverse(int arr[], int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
