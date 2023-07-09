package Graph;

// An image is represented by an m x n integer grid image where
// image[i][j] represents the pixel value of the image.

// You are also given three integers sr, sc, and color.
// You should perform a flood fill on the image starting from the pixel image[sr][sc].

// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally
//  to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to
//  those pixels (also with the same color), and so on.
//  Replace the color of all of the aforementioned pixels with color.

// Return the modified image after performing the flood fill.

class FloodFill {

  public static void main(String[] args) {
    int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    int sr = 1, sc = 1, color = 2;

    int[][] count = floodFill(image, sr, sc, color);
    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i].length; j++) {
        System.out.print(count[i][j]);
      }
      System.out.println();
    }
  }

  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int iniColor = image[sr][sc];
    int[][] ans = image;
    int delRow[] = { -1, 0, +1, 0 };
    int delCol[] = { 0, +1, 0, -1 };
    dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
    return ans;
  }

  public static void dfs(
    int row,
    int col,
    int[][] ans,
    int[][] image,
    int newColor,
    int delRow[],
    int delCol[],
    int iniColor
  ) {
    ans[row][col] = newColor;
    int n = image.length;
    int m = image[0].length;
    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];
      if (
        nrow >= 0 &&
        nrow < n &&
        ncol >= 0 &&
        ncol < m &&
        image[nrow][ncol] == iniColor &&
        ans[nrow][ncol] != newColor
      ) {
        dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
      }
    }
  }
}
