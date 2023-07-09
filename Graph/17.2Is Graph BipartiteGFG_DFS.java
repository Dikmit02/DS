package Graph;

// https://leetcode.com/problems/is-graph-bipartite/
import java.util.ArrayList;

class BipartiteGraph {

  public boolean isBipartite(int[][] graph) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) adj.add(new ArrayList<Integer>());

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        if (graph[i][j] == 1 && i != j) {
          adj.get(i).add(j);
          adj.get(j).add(i);
        }
      }
    }

    // Code here
    int V = graph.length;
    int[] color = new int[V];
    for (int i = 0; i < color.length; i++) {
      color[i] = -1;
    }
    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (dfs(color, i, 0, adj) == false) return false;
      }
    }
    return true;
  }

  public boolean dfs(
    int[] color,
    int start,
    int col,
    ArrayList<ArrayList<Integer>> adj
  ) {
    color[start] = col;

    for (int ii : adj.get(start)) {
      if (color[ii] == -1) {
        if (dfs(color, ii, 1 - col, adj) == false) return false;
      } else if (color[ii] == col) {
        return false;
      }
    }

    return true;
  }
}
