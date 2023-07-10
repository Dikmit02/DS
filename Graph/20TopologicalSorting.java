package Graph;

// it only exists on DAG
// Directed acyclic graph
// A graph wiht no cycles

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {

  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    // add your code here
    Stack<Integer> st = new Stack<>();
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, adj, st);
      }
    }
    int[] ans = new int[V];
    int i = 0;
    while (st.size() > 0) {
      int front = st.pop();
      ans[i++] = front;
    }
    return ans;
  }

  public static void dfs(
    int V,
    boolean[] visited,
    ArrayList<ArrayList<Integer>> adj,
    Stack<Integer> st
  ) {
    visited[V] = true;

    for (Integer ii : adj.get(V)) {
      if (!visited[ii]) {
        dfs(ii, visited, adj, st);
      }
    }
    st.push(V);
  }
}
