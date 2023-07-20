package Basic;

public class pattern9 {

  // Input Format: N = 3
  // Result:
  //   *
  //  ***
  // *****
  // *****
  //  ***
  //   *

  // Input Format: N = 6
  // Result:
  //      *
  //     ***
  //    *****
  //   *******
  //  *********
  // ***********
  // ***********
  //  *********
  //   *******
  //    *****
  //     ***
  //      *

  public static void main(String[] args) {
    int N = 5;
    //pattern 7
    for (int i = 0; i < N; i++) {
      for (int sp = 0; sp < N - 1 - i; sp++) {
        System.out.print(" ");
      }

      for (int j = 0; j < (2 * i) + 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    //pattern 8
    for (int i = 0; i < N; i++) {
      for (int sp = 0; sp < i; sp++) {
        System.out.print(" ");
      }
      for (int j = (2 * N) - 1 - (2 * i); j > 0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
