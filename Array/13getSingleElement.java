package Array;

import java.util.HashMap;
import java.util.Map;

class findMaxConsecutiveOnes {

  // https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/

  public static void main(String[] args) {
    int nums[] = { 1, 1, 0, 1, 1, 1 };
    int ans = getSingleElement(nums);
    System.out.println("The maximum  consecutive 1's are " + ans);
  }

  public static int getSingleElement(int[] arr) {
    // har i k lie j loop
    // Size of the array:
    int n = arr.length;

    //Run a loop for selecting elements:
    for (int i = 0; i < n; i++) {
      int num = arr[i]; // selected element
      int cnt = 0;

      //find the occurrence using linear search:
      for (int j = 0; j < n; j++) {
        if (arr[j] == num) cnt++;
      }

      // if the occurrence is 1 return ans:
      if (cnt == 1) return num;
    }

    //This line will never execute
    //if the array contains a single element.
    return -1;
  }

  public static int getSingleElement2(int[] arr) {
    //size of the array:
    int n = arr.length;

    // Find the maximum element:
    int maxi = arr[0];
    for (int i = 0; i < n; i++) {
      maxi = Math.max(maxi, arr[i]);
    }

    // Declare hash array of size maxi+1
    // And hash the given array:
    int[] hash = new int[maxi + 1];
    for (int i = 0; i < n; i++) {
      hash[arr[i]]++;
    }

    //Find the single element and return the answer:
    for (int i = 0; i < n; i++) {
      if (hash[arr[i]] == 1) return arr[i];
    }

    //This line will never execute
    //if the array contains a single element.
    return -1;
  }

  public static int getSingleElement3(int[] arr) {
    //size of the array:
    int n = arr.length;

    // Declare the hashmap.
    // And hash the given array:
    HashMap<Integer, Integer> mpp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int value = mpp.getOrDefault(arr[i], 0);
      mpp.put(arr[i], value + 1);
    }

    //Find the single element and return the answer:
    for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
      if (it.getValue() == 1) {
        return it.getKey();
      }
    }

    //This line will never execute
    //if the array contains a single element.
    return -1;
  }

  public static int getSingleElement4(int[] arr) {
    //size of the array:
    int n = arr.length;

    // XOR all the elements:
    int xorr = 0;
    for (int i = 0; i < n; i++) {
      xorr = xorr ^ arr[i];
    }
    return xorr;
  }
}
