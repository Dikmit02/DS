package Basic;

public class pattern2 {

  // Input Format: N = 3
  // Result:
  // *
  // * *
  // * * *

  // Input Format: N = 6
  // Result:
  // *
  // * *
  // * * *
  // * * * *
  // * * * * *
  // * * * * * *
  public static void main(String[] args) {
    int N = 8;
    for (int i = 1; i <= N; i++) {
      // This is the inner loop which loops for the columns
      // no. of columns = row number for each line here.
      // Here, we print numbers equal to the row number
      // instead of stars in each row.
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }

      // As soon as numbers for each iteration are printed, we move to the
      // next row and give a line break otherwise all numbers
      // would get printed in 1 line.
      System.out.println();
    }
  }
}
