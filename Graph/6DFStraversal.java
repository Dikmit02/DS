package Graph;

import java.util.ArrayList;

class DFStraversal {

  // Depth
  // height Wise traversal

  //            1                                level 0
  //         /      `
  //       2        3  - 4                   1  2 5 6 3 7 8 4
  //     /  `       |    |
  //   5       6    7  - 8
  //
  //

  //Initial configuration

  // Create a visited array of size+1 ie if 10 nodes then array(0->10)
  // CALL RECURSION FUNCTION FROM First node
  // starting node mark has 1
  public ArrayList<Integer> dfsOfGraph(
    int V,
    ArrayList<ArrayList<Integer>> adj
  ) {
    // Code here
    boolean[] visited = new boolean[V + 1];
    ArrayList<Integer> dfs = new ArrayList<>();
    visited[0] = true;
    dfs(0, visited, dfs, adj);
    return dfs;
  }

  public void dfs(
    int node,
    boolean[] visited,
    ArrayList<Integer> dfs,
    ArrayList<ArrayList<Integer>> adj
  ) {
    visited[node] = true;
    dfs.add(node);

    // travel all neighbours
    for (Integer n : adj.get(node)) {
      if (!visited[n]) {
        dfs(n, visited, dfs, adj);
      }
    }
  }
}
//     space => O(N)(dfs)+O(N)visited+ O(N)(stack) ~ O(N)
//     time  => dfs o(N) + O(2*E) (undirected)
//              dfs o(N) + O(2*E) (directed)
