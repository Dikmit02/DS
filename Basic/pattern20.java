package Basic;

public class pattern20 {

  // Input Format: N = 3
  // Result:
  // *    *
  // **  **
  // ******
  // **  **
  // *    *

  // Input Format: N = 6
  // Result:
  // *          *
  // **        **
  // ***      ***
  // ****    ****
  // *****  *****
  // ************
  // *****  *****
  // ****    ****
  // ***      ***
  // **        **
  // *          *

  public static void main(String[] args) {
    int n = 6;
    int initialSpace = 2 * n - 2;
    for (int i = 1; i <= 2 * n - 1; i++) {
      int stars = i;
      if (i > n) {
        stars = 2 * n - i;
      }
      for (int j = 1; j <= stars; j++) {
        System.out.print("*");
      }
      for (int j = 1; j <= initialSpace; j++) {
        System.out.print(" ");
      }

      for (int j = 1; j <= stars; j++) {
        System.out.print("*");
      }

      if (i < n) initialSpace -= 2; else initialSpace += 2;
      System.out.println();
    }
  }
}
