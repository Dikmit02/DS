package Array;

import java.util.ArrayList;
import java.util.HashMap;

class InsertionOfNumber {

  public static void main(String[] args) {
    int arr1[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 56 };
    int arr2[] = { 2, 3, 4, 4, 5, 11, 12, 67, 90 };
    int n = arr1.length, m = arr2.length;
    ArrayList<Integer> ans = TwoPointer(arr1, arr2, n, m);
    System.out.println("Union of arr1 and arr2 is ");
    for (int val : ans) System.out.print(val + " ");
  }

  static ArrayList<Integer> FindIntersection1(
    int arr1[],
    int arr2[],
    int n,
    int m
  ) {
    ArrayList<Integer> Intersection = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr1[i] == arr2[j] && !Intersection.contains(arr2[j])) {
          Intersection.add(arr2[j]);
        }
      }
    }

    return Intersection;
  }

  static ArrayList<Integer> FindIntersection2(
    int arr1[],
    int arr2[],
    int n,
    int m
  ) {
    HashMap<Integer, Integer> freq = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) freq.put(arr1[i], 0);

    for (int j = 0; j < m; j++) {
      if (freq.containsKey(arr2[j])) {
        list.add(arr2[j]);
      }
    }

    return list;
  }

  static ArrayList<Integer> TwoPointer(int arr1[], int arr2[], int n, int m) {
    int i = 0;
    int j = 0;
    ArrayList<Integer> Union = new ArrayList<>();
    while (i < n && j < m) {
      if (arr1[i] == arr2[j]) {
        Union.add(arr1[i]);

        i++;
        j++;
      } else if (arr1[i] < arr2[j]) {
        i++;
      } else {
        j++;
      }
    }

    return Union;
  }
}
