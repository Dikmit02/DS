package Graph;

import java.util.LinkedList;
import java.util.Queue;

class DistanceOfNearestCellHaving {

  public static void main(String[] args) {}

  public static int[][] nearest(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    // visited and distance matrix
    boolean vis[][] = new boolean[n][m];
    int dist[][] = new int[n][m];

    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    // <coordinates, steps>
    Queue<Node> q = new LinkedList<Node>();
    // traverse the matrix
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // start BFS if cell contains 1
        if (grid[i][j] == 1) {
          q.add(new Node(i, j, 0));
          vis[i][j] = true;
        }
      }
    }

    while (q.size() > 0) {
      int row = q.peek().row_;
      int col = q.peek().col_;
      int steps = q.peek().distance;
      q.remove();
      dist[row][col] = steps;

      for (int i = 0; i < 4; i++) {
        int nrow = row + dir[i][0];
        int ncol = col + dir[i][1];
        // check for valid unvisited cell
        if (
          nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]
        ) {
          vis[nrow][ncol] = true;
          q.add(new Node(nrow, ncol, steps + 1));
        }
      }
    }
    return dist;
  }

  static class Node {
    int row_;
    int col_;
    int distance;

    Node(int row_, int col_, int distance) {
      this.row_ = row_;
      this.col_ = col_;
      this.distance = distance;
    }
  }
}


// Time Complexity: O(NxM + NxMx4) ~ O(N x M)

// For the worst case, the BFS function will be called for (N x M) nodes, and for every node, we are traversing for 4 neighbors, so it will take O(N x M x 4) time.

// Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)

// O(N x M) for the visited array, distance matrix, and queue space takes up N x M locations at max. 
