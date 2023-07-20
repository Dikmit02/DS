package Basic;

public class pattern16 {

  // Input Format: N = 3
  // Result:
  // A
  // B B
  // C C C

  // Input Format: N = 6
  // Result:
  // A
  // B B
  // C C C
  // D D D D
  // E E E E E
  // F F F F F F

  public static void main(String[] args) {
    int n = 6;
    char start = 'A';
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(start);
      }
      start += 1;
      System.out.println();
    }
  }
}
