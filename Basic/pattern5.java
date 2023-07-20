package Basic;

public class pattern5 {

  // Input Format: N = 3
  // Result:
  // * * *
  // * *
  // *

  // Input Format: N = 6
  // Result:
  // * * * * * *
  // * * * * *
  // * * * *
  // * * *
  // * *
  // *

  public static void main(String[] args) {
    int N = 6;
    // same as pattern15
    for (int i = 1; i <= N; i++) {
      // i+j<=n+1;
      for (int j = 1; j <= N - i + 1; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
