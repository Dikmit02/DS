package Basic;

public class pattern11 {

  // Input Format: N = 3
  // Result:
  // 1
  // 01
  // 101

  // Input Format: N = 6
  // Result:
  // 1
  // 01
  // 101
  // 0101
  // 10101
  // 010101

  public static void main(String[] args) {
    int n = 6;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print("1");
        } else {
          System.out.print("0");
        }
      }
      System.out.println();
    }
    // 2 way
    System.out.println("====>>>>>>>>>>>>>>>>>>>>>>>>====");

    int start = 1;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) start = 1; else start = 0;
      for (int j = 0; j <= i; j++) {
        System.out.print(start);
        start = 1 - start;
      }
      System.out.println();
    }
  }
}
