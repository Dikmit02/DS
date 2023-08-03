package Array;

class LeftRotateanarraybyDplace {

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6 };
    int k = 3;
    // int[] ans1 = Brute(array, k);
    Optimsed(array, k);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static int[] Brute(int[] arr, int k) {
    // TC=> O(k) + O(n-k)+O(k)
    // SC=> O(K)

    int n = arr.length;
    k = k % n;
    int[] temp = new int[k];

    for (int j = 0; j < k; j++) {
      temp[j] = arr[j];
    }

    for (int i = k; i < n; i++) {
      arr[i - k] = arr[i];
    }

    for (int i = n - k, j = 0; i < n; i++, j++) {
      arr[i] = temp[j];
      //   or
      //   arr[i] = temp[i-(n-k)];
    }

    return arr;
  }

  public static void Optimsed(int[] arr, int k) {
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
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
