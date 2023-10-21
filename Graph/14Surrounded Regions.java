package Graph;

//https://leetcode.com/problems/number-of-enclaves/

// here if any O exitsts on the boundary then run dfs on them so that they can find all the related Os.
class SurroundedRegions {

  public static void main(String[] args) {}

  public static void solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    boolean[][] visited = new boolean[n][m];

    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    for (int j = 0; j < m; j++) {
      // loop on row1
      if (!visited[0][j] && board[0][j] == 'O') {
        dfs(board, visited, 0, j, dir);
      }
      // loop on Last Row
      if (!visited[n - 1][j] && board[n - 1][j] == 'O') {
        dfs(board, visited, n - 1, j, dir);
      }
    }

    for (int i = 0; i < n; i++) {
      // loop on 1 Col
      if (!visited[i][0] && board[i][0] == 'O') {
        dfs(board, visited, i, 0, dir);
      }

      // loop on last Col
      if (!visited[i][m - 1] && board[i][m - 1] == 'O') {
        dfs(board, visited, i, m - 1, dir);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'O' && !visited[i][j]) {
          board[i][j] = 'X';
        }
      }
    }
    // return board;
  }

  public static void dfs(
    char[][] board,
    boolean[][] visited,
    int r,
    int c,
    int[][] dir
  ) {
    visited[r][c] = true;
    int n = board.length;
    int m = board[0].length;

    for (int i = 0; i < dir.length; i++) {
      int nrow = r + dir[i][0];
      int ncol = c + dir[i][1];

      if (
        nrow >= 0 &&
        nrow < n &&
        ncol >= 0 &&
        ncol < m &&
        !visited[nrow][ncol] &&
        board[nrow][ncol] == 'O'
      ) {
        dfs(board, visited, nrow, ncol, dir);
      }
    }
  }
}


// Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M), For the worst case, every element will be marked as ‘O’ in the matrix, and the DFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time. Also, we are running loops for boundary elements so it will take O(N) + O(M).

// Space Complexity ~ O(N x M), O(N x M) for the visited array, and auxiliary stack space takes up N x M locations at max. 