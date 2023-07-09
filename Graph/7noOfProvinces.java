package Graph;

import java.util.ArrayList;

class noOfProvinces {

  //https://leetcode.com/problems/number-of-provinces/

  // There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
  // A province is a group of directly or indirectly connected cities and no other cities outside of the group.
  // You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
  // Return the total number of provinces.

  // Solution:given is the 2d matrix convert into adjacency matrix
  // number of nodes starting nodes will be my answer

  public static void main(String[] args) {
    int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < isConnected.length; i++) adj.add(
      new ArrayList<Integer>()
    );

    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[i].length; j++) {
        if (isConnected[i][j] == 1 && i != j) {
          adj.get(i).add(j);
          adj.get(j).add(i);
        }
      }
    }

    boolean[] visited = new boolean[isConnected.length];
    int count = 0;

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        count = count + 1;
        dfs(i, adj, visited);
      }
    }
    System.out.println("count" + count);
  }

  public static void dfs(
    int V,
    ArrayList<ArrayList<Integer>> adj,
    boolean[] visited
  ) {
    visited[V] = true;

    for (Integer ii : adj.get(V)) {
      if (!visited[ii]) {
        dfs(ii, adj, visited);
      }
    }
  }
}
// space complexity N=>stack + N=> boolean array
// Time complexity dfs O(N)+O(2*Edges + V)
