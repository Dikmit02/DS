package Basic;

public class pattern12 {

  // Input Format: N = 3
  // Result:
  // 1    1
  // 12  21
  // 123321

  // Input Format: N = 6
  // Result:
  // 1          1
  // 12        21
  // 12       321
  // 1234    4321
  // 12345  54321
  // 123456654321

  public static void main(String[] args) {
    int n = 6;
    int space = 2 * (n - 1);
    for (int i = 1; i <= n; i++) {
      //numbers
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      // space is reducing by 2
      for (int j = 1; j <= space; j++) {
        System.out.print("  ");
      }
      //numbers
      for (int j = i; j >= 1; j--) {
        System.out.print(j + " ");
      }
      System.out.println();
      space -= 2;
    }
  }
}
