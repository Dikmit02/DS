package sorting;

//1 place the pivot in the correct position
//  the arr[i] should be always smaller than pivot
//  the arr[j] should be always greater  than pivot
//  when i<j swap
//  swap(arr[low], arr[i])
//2 call recusively form left and right part
class quickSort {

  public static void main(String[] args) {
    int[] arr = { 4, 6, 2, 5, 7, 9, 1, 3 };
    int n = arr.length - 1;
    quickSort_(arr, 0, n - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void quickSort_(int[] arr, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(arr, low, high);
      quickSort_(arr, low, partitionIndex - 1);
      quickSort_(arr, partitionIndex + 1, high);
    }
  }

  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low;
    int j = high;

    while (i < j) {
      while (arr[i] <= pivot && i <= high - 1) {
        i++;
      }
      while (arr[j] > pivot && j >= low + 1) {
        j--;
      }
      if (i < j) swap(arr, i, j);
    }
    swap(arr, low, j);
    return j;
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
