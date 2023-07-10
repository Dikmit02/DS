package Graph;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-eventual-safe-states/
class FindEventfulSafeStates {

  List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
    boolean[] visited = new boolean[V];
    boolean[] isPath = new boolean[V];
    boolean[] safeStates = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, isPath, adj, safeStates);
      }
    }

    List<Integer> ans = new ArrayList<Integer>() {};
    for (int i = 0; i < V; i++) {
      if (safeStates[i]) {
        ans.add(i);
      }
    }
    return ans;
  }

  public boolean dfs(
    int V,
    boolean[] visited,
    boolean[] isPath,
    List<List<Integer>> adj,
    boolean[] safeStates
  ) {
    visited[V] = true;
    isPath[V] = true;
    safeStates[V] = false;

    for (Integer ii : adj.get(V)) {
      if (!visited[ii]) {
        if (dfs(ii, visited, isPath, adj, safeStates) == true) return true;
      } else if (isPath[ii] == true) {
        return true;
      }
    }
    isPath[V] = false;
    safeStates[V] = true;
    return false;
  }
}
