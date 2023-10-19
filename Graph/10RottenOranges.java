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


  //Solution 2
  private static class BAWPair {
    int r;
    int c;
    int time;

    public BAWPair(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
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


  public static int rottenOranges(int[][] orange) {

    LinkedList<BAWPair> que = new LinkedList<>();
    for (int i = 0; i < orange.length; i++) {
        for (int j = 0; j < orange[0].length; j++) {
            if (orange[i][j] == 2) {
                que.addLast(new BAWPair(i, j, 0));
            }
        }
    }

    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int Time = 0;

    while (!que.isEmpty()) {
        BAWPair rpair = que.removeFirst();
        for (int d = 0; d < dir.length; d++) {
            int r = dir[d][0] + rpair.r;
            int c = dir[d][1] + rpair.c;

            if (r < orange.length && c < orange[0].length && r >= 0 && c >= 0 && orange[r][c] == 1) {
                orange[r][c] = 2;
                int prevtime = rpair.time;
                int currTime = prevtime + 1;
                que.addLast(new BAWPair(r, c, currTime));
                Time = currTime;
            }

        }
    }

    for (int i = 0; i < orange.length; i++) {
        for (int j = 0; j < orange[0].length; j++) {
            if (orange[i][j] == 1) {
                return -1;
            }
        }
    }

    return Time;
}

//Solution 3
int orangesRotting(vector<vector<int>> &grid)
{
    if (grid.size() == 0 || grid[0].size() == 0)
        return;

    int n = grid.size();
    int m = grid[0].size();

    int dirA[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    queue<int> que;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (grid[i][j] == 2)
                que.push((i * m + j));

    int level = 0;
    while (que.size() != 0)
    {
        int size = que.size();
        while (size-- > 0)
        {
            int rvtx = que.front();
            que.pop();

            int r = rvtx / m;
            int c = rvtx % m;

            for (int d = 0; d < 4; d++)
            {
                int x = r + dirA[d][0];
                int y = c + dirA[d][1];

                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1)
                {
                    que.push((x * m + y));
                    grid[x][y] = 2;
                }
            }
        }
        level++;
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (grid[i][j] == 1)
                return -1;

    return level;
}

// Solution 4
int orangesRotting(vector<vector<int>> &grid)
{
    int n = grid.size();
    int m = grid[0].size();

    queue<pii> que;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 2)
                que.push({i, j});
        }
    }

    int level = 0;
    while (que.size() != 0)
    {
        int size = que.size();
        while (size-- > 0)
        {
            pii p = que.front();
            que.pop();

            int i = p.first;
            int j = p.second;

            if (i + 1 < n && grid[i + 1][j] == 1)
            {
                que.push({i + 1, j});
                grid[i + 1][j] = 2;
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1)
            {
                que.push({i - 1, j});
                grid[i - 1][j] = 2;
            }
            if (j + 1 < m && grid[i][j + 1] == 1)
            {
                que.push({i, j + 1});
                grid[i][j + 1] = 2;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1)
            {
                que.push({i, j - 1});
                grid[i][j - 1] = 2;
            }
        }
        level++;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 1)
                return -1;
        }
    }

    return level > 0 ? level - 1 : 0;
}
}
