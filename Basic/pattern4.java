package Basic;

public class pattern4 {

  // Input Format: N = 3
  // Result:
  // 1
  // 2 2
  // 3 3 3

  // Input Format: N = 6
  // Result:
  // 1
  // 2 2
  // 3 3 3
  // 4 4 4 4
  // 5 5 5 5 5
  // 6 6 6 6 6 6

  public static void main(String[] args) {
    int N = 9;
    // code here
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(i + " ");
      }

      System.out.println();
    }
  }
}
