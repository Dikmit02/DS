package Graph;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
//https://leetcode.com/problems/course-schedule-ii/discuss/293048/detecting-cycle-in-directed-graph-problem
class DirectedGraphDFS {

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    boolean[] isPath = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(i, visited, isPath, adj) == true) return true;
      }
    }

    return false;
  }

  public boolean dfs(
    int V,
    boolean[] visited,
    boolean[] isPath,
    ArrayList<ArrayList<Integer>> adj
  ) {
    visited[V] = true;
    isPath[V] = true;

    for (Integer ii : adj.get(V)) {
      if (!visited[ii]) {
        if (dfs(ii, visited, isPath, adj) == true) return true;
      } else if (isPath[ii] == true) {
        return true;
      }
    }
    isPath[V] = false;
    return false;
  }
}
