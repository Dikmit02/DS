package sorting;

// select minimum from the array and replace with ith index element and swap the ith index and the minimum index element
class selectionSort {

  // Time complexity= n+(n-1)+(n-2)+(n-3)+(n-4)+.....+3+2+1 => n(n-1)/2 => N^2
  // O(N*N)=> best average worst
  //https://takeuforward.org/sorting/selection-sort-algorithm/
  public static void main(String[] args) {
    int[] arr = { 13, 46, 24, 52, 20, 9 };
    for (int i = 0; i < arr.length - 1; i++) {
      int min = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
