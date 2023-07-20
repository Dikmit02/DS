package Basic;

public class pattern7 {

  // Input Format: N = 3
  // Result:
  //   *
  //  ***
  // *****

  // Input Format: N = 6
  // Result:
  //      *
  //     ***
  //    *****
  //   *******
  //  *********
  // ***********

  // it logic used in pattern 17
  // 3 loops space star space
  public static void main(String[] args) {
    int N = 6;
    for (int i = 0; i < N; i++) {
      for (int sp = 0; sp < N - 1 - i; sp++) {
        System.out.print(" ");
      }
      for (int j = 0; j < (2 * i) + 1; j++) {
        System.out.print("*");
      }
      //      for(int sp=0;sp<N-1-i;sp++){
      //       System.out.print(" ");
      //   }

      // As soon as numbers for each iteration are printed, we move to the
      // next row and give a line break otherwise all numbers
      // would get printed in 1 line.
      System.out.println();
    }
  }
}
