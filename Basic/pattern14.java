package Basic;

public class pattern14 {

  // Input Format: N = 3
  // Result:
  // A
  // A B
  // A B C

  // Input Format: N = 6
  // Result:
  // A
  // A B
  // A B C
  // A B C D
  // A B C D E
  // A B C D E F
  public static void main(String[] args) {
    int n = 6;
    for (int i = 1; i <= n; i++) {
      char start = 'A';
      for (int j = 1; j <= i; j++) {
        System.out.print(start);
        start += 1;
      }
      System.out.println();
    }
  }
}
