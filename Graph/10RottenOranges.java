package Graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/

class RottenOranges_ {

  public static void main(String[] args) {}

  public static class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public int orangesRotting(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    int n = grid.length;
    int m = grid[0].length;

    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    Queue<Pair> que = new LinkedList<>();
    int freshOranges = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 2) que.add(new Pair(i, j));
        if (grid[i][j] == 1) freshOranges++;
      }
    }

    if (freshOranges == 0) return 0;
    int time = 0;
    while (que.size() != 0) {
      int size = que.size();
      while (size-- > 0) {
        Pair first = que.poll();
        int r = first.row;
        int c = first.col;

        for (int d = 0; d < 4; d++) {
          int x = r + dir[d][0];
          int y = c + dir[d][1];

          if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
            grid[x][y] = 2;
            freshOranges--;
            que.add(new Pair(x, y));
            if (freshOranges == 0) return time + 1;
          }
        }
      }
      time++;
    }
    return -1;
  }
}
