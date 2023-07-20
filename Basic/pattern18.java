package Basic;

public class pattern18 {

  // Input Format: N = 3
  // Result:
  // C
  // B C
  // A B C

  // Input Format: N = 6
  // Result:
  // F
  // E F
  // D E F
  // C D E F
  // B C D E F
  // A B C D E F

  public static void main(String[] args) {
    int n = 6;
    for (int i = 1; i <= n; i++) {
      char start = (char) (n - 1 + 'A');
      for (int j = 1; j <= i; j++) {
        System.out.print(start + " ");
        start--;
      }
      System.out.println();
    }
  }
}
