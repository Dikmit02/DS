package Basic;

public class pattern22 {

  // Input Format: N = 3
  // Result:
  // 3 3 3 3 3
  // 3 2 2 2 3
  // 3 2 1 2 3
  // 3 2 2 2 3
  // 3 3 3 3 3

  // Input Format: N = 6
  // Result:
  // 6 6 6 6 6 6 6 6 6 6 6
  // 6 5 5 5 5 5 5 5 5 5 6
  // 6 5 4 4 4 4 4 4 4 5 6
  // 6 5 4 3 3 3 3 3 4 5 6
  // 6 5 4 3 2 2 2 3 4 5 6
  // 6 5 4 3 2 1 2 3 4 5 6
  // 6 5 4 3 2 2 2 3 4 5 6
  // 6 5 4 3 3 3 3 3 4 5 6
  // 6 5 4 4 4 4 4 4 4 5 6
  // 6 5 5 5 5 5 5 5 5 5 6
  // 6 6 6 6 6 6 6 6 6 6 6

  //   As per the above illustration, we take the minimum distance of the current cell from each of t
  //   he ends of the square ( min(1,3,3,5) ) and make the current cell value equal to that number.

  // The distance of the current cell from the top can be written as the row number i.e, i.
  // The distance of the current cell from the left can be written as the column number i.e, j.
  // The distance of the current cell from the right can be written as (2*n-2) – j.
  // The distance of the current cell from the bottom can be written as (2*n-2) – i.

  public static void main(String[] args) {
    int n = 4;
    for (int i = 0; i < 2 * n - 1; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        int top = i;
        int bottom = j;
        int right = (2 * n - 1) - 1 - j;
        int left = (2 * n - 1) - 1 - i;

        int min = Math.min(Math.min(top, bottom), Math.min(left, right));
        System.out.print(n - min);
      }
      System.out.println();
    }
  }
}
