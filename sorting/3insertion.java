package sorting;

class insertion {

  // O(N*N)=> worst average
  // O(n)=> best
  // Takes an element and place it at its correct position
  public static void main(String[] args) {
    int[] arr = { 13, 46, 24, 52, 20, 9 };
    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j >= 1; j--) {
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
