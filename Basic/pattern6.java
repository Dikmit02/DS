package Basic;

public class pattern6 {

  // Input Format: N = 3
  // Result:
  // 1 2 3
  // 1 2
  // 1

  // Input Format: N = 6
  // Result:
  // 1 2 3 4 5 6
  // 1 2 3 4 5
  // 1 2 3 4
  // 1 2 3
  // 1 2
  // 1

  public static void main(String[] args) {
    int N = 6;
    for (int i = 1; i <= N; i++) {
      // i+j<=n+1;
      for (int j = 1; j <= N - i + 1; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
