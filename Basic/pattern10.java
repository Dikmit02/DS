package Basic;

public class pattern10 {

  //   Input Format: N = 3
  // Result:
  //   *
  //   **
  //   ***
  //   **
  //   *
  // Input Format: N = 6
  // Result:
  //      *
  //      **
  //      ***
  //      ****
  //      *****
  //      ******
  //      *****
  //      ****
  //      ***
  //      **
  //      *

  // Symmetry is not exactly same
  public static void main(String[] args) {
    int n = 5;
    //pattern 7
    for (int i = 1; i <= (2 * n) - 1; i++) {
      int stars = i; // till the half way the stars are equal to the number of row
      if (i > n) stars = 2 * n - i; // after the half way the stars are equal 2n-i
      for (int j = 1; j <= stars; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
