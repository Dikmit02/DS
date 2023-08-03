package Array;

import sorting._4MergeSort;

class secondLargetElement {

  // 1 2 3 5 7 7 7
  // Here the second larget will be 5 not 7
  public static void main(String[] args) {
    int[] array = { 7, 2, 7, 5, 1, 3, 7 };
    int ans1 = Brute(array);
    int ans2 = Better_FirstPlace(array);
    int ans3 = Optimsed(array);
    System.out.println(ans3);
  }

  public static int Brute(int[] arr) {
    //Brute force
    //sort the array and start looping from the back-1
    //and store the last element
    // loop from the second larget element till last and check if its equal to the larget element
    // if its equal to the larget element continue looping else break
    // the breaked element will be my answer

    // soritng nLogn
    // worstCase => O(N)
    //total => nLogn + O(N) ~~
    _4MergeSort.mergeSort(arr, 0, arr.length - 1);
    int n = arr.length;
    int largest = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (largest != arr[i]) {
        return arr[i];
      }
    }
    return -1;
  }

  public static int Better_FirstPlace(int[] arr) {
    // tc=> 2O(N)
    // in the first iteration find the largest element
    // in the second iteration find the second largest element
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= largest) {
        largest = arr[i];
      }
    }

    int sLarget = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != largest && arr[i] > sLarget) {
        sLarget = arr[i];
      }
    }
    return sLarget;
  }

  public static int Optimsed(int[] arr) {
    //larget =arr[0];
    //sLarget = Integer.MIN_VALUE;

    // if larget changes , then previous Larget will be my sLarget
    int larget = arr[0];
    int sLarget = Integer.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > larget) {
        sLarget = larget;
        larget = arr[i];
      } else if (arr[i] > sLarget && arr[i] < larget) {
        // arr[i]=7
        // larget=10;
        // sLarget=4
        sLarget = arr[i];
      }
    }
    return sLarget;
  }
}
