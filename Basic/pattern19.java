package Basic;

public class pattern19 {

  // Input Format: N = 3
  // Result:
  // ******
  // **  **
  // *    *
  // *    *
  // **  **
  // ******

  // Input Format: N = 6
  // Result:
  // ************
  // *****  *****
  // ****    ****
  // ***      ***
  // **        **
  // *          *
  // *          *
  // **        **
  // ***      ***
  // ****    ****
  // *****  *****
  // ************
  public static void main(String[] args) {
    int n = 6;
    int initialSpace = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i; j++) {
        System.out.print("*");
      }
      for (int j = 1; j < initialSpace; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j <= n - i; j++) {
        System.out.print("*");
      }
      initialSpace += 2;
      System.out.println();
    }
    initialSpace = 2 * n - 2;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int j = 0; j < initialSpace; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
      initialSpace -= 2;
    }
  }
}
