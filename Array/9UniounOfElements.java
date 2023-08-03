package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class UniounOfElements {

  public static void main(String[] args) {
    int arr1[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 56 };
    int arr2[] = { 2, 3, 4, 4, 5, 11, 12, 67, 90 };
    int n = arr1.length, m = arr2.length;
    ArrayList<Integer> Union = TwoPointer(arr1, arr2, n, m);
    System.out.println("Union of arr1 and arr2 is ");
    for (int val : Union) System.out.print(val + " ");
  }

  static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    ArrayList<Integer> Union = new ArrayList<>();
    for (int i = 0; i < n; i++) freq.put(
      arr1[i],
      freq.getOrDefault(arr1[i], 0) + 1
    );

    for (int i = 0; i < m; i++) freq.put(
      arr2[i],
      freq.getOrDefault(arr2[i], 0) + 1
    );
    for (int it : freq.keySet()) Union.add(it);
    return Union;
  }

  static ArrayList<Integer> FindUnion2(int arr1[], int arr2[], int n, int m) {
    HashSet<Integer> s = new HashSet<>();
    ArrayList<Integer> Union = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      s.add(arr1[i]);
    }
    for (int i = 0; i < m; i++) {
      s.add(arr2[i]);
    }
    for (int it : s) {
      Union.add(it);
    }
    return Union;
  }

  static ArrayList<Integer> TwoPointer(int arr1[], int arr2[], int n, int m) {
    int i = 0;
    int j = 0;
    ArrayList<Integer> Union = new ArrayList<>();
    while (i < n && j < m) {
      if (arr1[i] <= arr2[j]) {
        if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i]) {
          Union.add(arr1[i]);
        }
        i++;
      } else {
        if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j]) {
          Union.add(arr2[j]);
        }
        j++;
      }
    }
    while (
      i < n
    ) { // IF any element left in arr1
      if (Union.get(Union.size() - 1) != arr1[i]) Union.add(arr1[i]);
      i++;
    }
    while (
      j < m
    ) { // If any elements left in arr2
      if (Union.get(Union.size() - 1) != arr2[j]) Union.add(arr2[j]);
      j++;
    }
    System.out.println();
    return Union;
  }
}
