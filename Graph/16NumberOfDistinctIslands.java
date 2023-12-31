package Graph;

//https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
import java.util.ArrayList;
import java.util.HashSet;

// in this question, take the src row and src column index index and considering these coordinates as the origin find the index
// eg            0  1  2  3  4
// grid[][] = 0{{1, 1, 0, 0, 0},
//            1 {1, 1, 0, 0, 0},
//            2 {0, 0, 0, 1, 1}, // coordinates 2,3 will
//            3 {0, 0, 0, 1, 1}}
// Output:
// 1
// Explanation:
// grid[][] = {{1, 1, 0, 0, 0}, 
//             {1, 1, 0, 0, 0}, 
//             {0, 0, 0, 1, 1}, 
//             {0, 0, 0, 1, 1}}
// Same colored islands are equal.
// We have 2 equal islands, so we 
// have only 1 distinct island.


class NumberOfDistinctIslands {

  public static String toString(int number1, int number2) {
    return number1 + "," + number2;
  }

  public static void dfs(
    int[][] grid,
    boolean[][] visited,
    int r,
    int c,
    int[][] dir,
    ArrayList<String> vec,
    int row0,
    int col0
  ) {
    visited[r][c] = true;
    vec.add(toString(r - row0, c - col0));
    int n = grid.length;
    int m = grid[0].length;

    for (int i = 0; i < dir.length; i++) {
      int nrow = r + dir[i][0];
      int ncol = c + dir[i][1];

      if (
        nrow >= 0 &&
        nrow < n &&
        ncol >= 0 &&
        ncol < m &&
        !visited[nrow][ncol] &&
        grid[nrow][ncol] == 1
      ) {
        dfs(grid, visited, nrow, ncol, dir, vec, row0, col0);
      }
    }
  }

  public static int countDistinctIslands(int[][] grid) {
    // Your Code here
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];

    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    HashSet<ArrayList<String>> sh = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          ArrayList<String> vec = new ArrayList<>();
          dfs(grid, visited, i, j, dir, vec, i, j);
          sh.add(vec);
        }
      }
    }
    return sh.size();
  }
}
