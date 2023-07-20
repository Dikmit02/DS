package Basic;

public class pattern15 {

  // Input Format: N = 3
  // Result:
  // A B C
  // A B
  // A

  // Input Format: N = 6
  // Result:
  // A B C D E F
  // A B C D E
  // A B C D
  // A B C
  // A B
  // A

  public static void main(String[] args) {
    int n = 6;
    // same as pattern5
    for (int i = 1; i <= n; i++) {
      char start = 'A';
      for (int j = 1; j <= 1 + n - i; j++) {
        System.out.print(start);
        start += 1;
      }
      System.out.println();
    }
  }
}
