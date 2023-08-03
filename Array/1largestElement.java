package Array;

class largestElement {

  public static void main(String[] args) {}

  // Brute force
  // sorting  the element and the last will be my answer
  // TC=> O(NLogN)
  // SC=> O(1)

  // Optimal
  public largestElement(int arr[]) {
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= largest) {
        largest = arr[i];
      }
    }
    System.out.println(largest);
    // TC=> O(N)
  }
}
