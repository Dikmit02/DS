class sorting {

  public static void main(String[] args) {
    int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
    int target = 3;
    searchMatrix(matrix, target);
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    int rowCount = matrix.length;
    int colCount = matrix[0].length;

    int low = 0;
    int high = rowCount * colCount - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int row = mid / colCount;
      int col = mid % colCount;

      if (matrix[row][col] == target) {
        return true;
      }
      if (matrix[row][col] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return false;
  }
}
