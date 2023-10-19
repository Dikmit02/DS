package Graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all
// surrounded by water.

// Solution: Nu,ber of starting points will b emy ans
// id the character is  1, go in the 4 directins and if the neightburs are 1 and not visited at them in the queue
// Store ans in seperate array

class NumberOfIslands {

  public static void main(String[] args) {
    char[][] grid = {
      { '1', '1', '1', '1', '0' },
      { '1', '1', '0', '1', '0' },
      { '1', '1', '0', '0', '0' },
      { '0', '0', '0', '0', '0' },
    };

    int count = numIslands(grid);
    System.out.println(count);
  }

  ///BFS with visited
  public static int numIslands(char[][] grid) {
    // create a visited array
    int n = grid.length;
    int m = grid[0].length;
    int count = 0;
    int[][] visited = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1' && visited[i][j] == 0) {
          count += 1;
          bfs(grid, visited, i, j);
        }
      }
    }
    return count;
  }

  public static void bfs(char[][] grid, int[][] visited, int ro, int co) {
    Queue<Pair> q = new LinkedList<Pair>();
    Pair p = new Pair(ro, co);
    q.add(p);
    visited[ro][co] = 1;
    while (q.size() > 0) {
      int row = q.peek().first;
      int col = q.peek().second;
      q.remove();
      int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
      for (int d = 0; d < directions.length; d++) {
        int nrow = row + directions[d][0];
        int ncol = col + directions[d][1];
        if (
          nrow >= 0 &&
          nrow < grid.length &&
          ncol >= 0 &&
          ncol < grid[0].length &&
          grid[nrow][ncol] == '1' &&
          visited[nrow][ncol] == 0
        ) {
          Pair temp = new Pair(nrow, ncol);
          q.add(temp);
          visited[nrow][ncol] = 1;
        }
      }
    }
  }

  public static class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }


  
}


//BFS without visited
class Solution {
public static int numIslands(char[][] grid) {
  // create a visited array
  int n = grid.length;
  int m = grid[0].length;
  int count = 0;
  int[][] visited = new int[n][m];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (grid[i][j] == '1') {
        count += 1;
        bfs(grid, i, j);
      }
    }
  }
  return count;
}

public  void bfs(char[][] grid ,int ro, int co) {
  Queue<Pair> q = new LinkedList<Pair>();
  Pair p = new Pair(ro, co);
  q.add(p);
  grid[ro][co] = '0';
  while (q.size() > 0) {
    int row = q.peek().first;
    int col = q.peek().second;
    q.remove();
    
    int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    for (int d = 0; d < directions.length; d++) {
      int nrow = row + directions[d][0];
      int ncol = col + directions[d][1];
      if (
        nrow >= 0 &&
        nrow < grid.length &&
        ncol >= 0 &&
        ncol < grid[0].length &&
        grid[nrow][ncol] == '1'
      ) {
        Pair temp = new Pair(nrow, ncol);
        q.add(temp);
        grid[nrow][ncol] = '0';
  
      }
    }
  }
}
}

//DFS without visited
class Solution {
  public int numIslands(char[][] grid) {
      // create a visited array
  int n = grid.length;
  int m = grid[0].length;
  int count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (grid[i][j] == '1') {
        count += 1;
        DFS(grid, i, j);
      }
    }
  }
  return count;
  }
  
  
  public  void DFS(char[][] grid, int x, int y) {

      // base case 1:
      // out of bound
      if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
          return;
      }
      
      // base case 2:
      // this is water, so finish this searching and return to parent
      if (grid[x][y] == '0') {
          return;
      }
      
      // This is island, so continue
      // Search in all directions for extending this island
      // We need to prevent children from searching back to parent,
      // so make the current one invalid (water, so that it returns as base case 2).
      grid[x][y] = '0';
      DFS(grid, x-1, y);
      DFS(grid, x, y-1);
      DFS(grid, x+1, y);
      DFS(grid, x, y+1);
      
      // Don't have to make the current grid from 0 back to 1
      // Because we want to deminish this whole island so that 
      // further iterations in numIslands will see this whole area as water and skip
      
 

}
}

//DFS using visited array
class Solution {
  public int numIslands(char[][] grid) {
      // create a visited array
  int n = grid.length;
  int m = grid[0].length;
  boolean[][]visited=new boolean[n][m]
  int count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (grid[i][j] == '1' && !visited[i][j]) {
        count += 1;
        DFS(grid, i, j,visited);
      }
    }
  }
  return count;
  }
  
  
  public  void DFS(char[][] grid, int x, int y, boolean[][]visited) {
      if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
          return;
      }
       
      visited[x][y]=true;
      DFS(grid, x-1, y,visited);
      DFS(grid, x, y-1,visited);
      DFS(grid, x+1, y,visited);
      DFS(grid, x, y+1,visited);
      
 

}
}
