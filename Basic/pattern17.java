package Basic;

public class pattern17 {

  // Input Format: N = 3
  // Result:
  //   A
  //  ABA
  // ABCBA

  // Input Format: N = 6
  // Result:
  //      A
  //     ABA
  //    ABCBA
  //   ABCDCBA
  //  ABCDEDCBA
  // ABCDEFEDCBA

  public static void main(String[] args) {
    int n = 8;
    //same as pattern7

    //space
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i; j++) {
        System.out.print(" ");
      }

      //alphabet
      char start = 'A';
      int breakPoint = i;

      for (int j = 0; j < (2 * i) + 1; j++) {
        System.out.print(start);
        if (j >= breakPoint) {
          start -= 1;
        } else {
          start += 1;
        }
      }

      //space
      for (int j = 0; j < n - i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
