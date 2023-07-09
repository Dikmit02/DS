package Graph;

import java.util.ArrayList;

class Solution {

  // Function to detect cycle in an undirected graph.
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        if (dfs(visited, i, adj, -1)) return true;
      }
    }
    return false;
  }

  public class Pair {
    int current;
    int parent;

    public Pair(int current, int parent) {
      this.current = current;
      this.parent = parent;
    }
  }

  public boolean dfs(
    boolean[] visited,
    int Node,
    ArrayList<ArrayList<Integer>> adj,
    int Parent
  ) {
    visited[Node] = true;
    for (int ii : adj.get(Node)) {
      if (visited[ii] == false) {
        if (dfs(visited, ii, adj, Node) == true) return true;
      }
      // if adjacent node is visited and is not its own parent node
      else if (ii != Parent) return true;
    }
    return false;
  }
}
