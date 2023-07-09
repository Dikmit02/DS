package Graph;

// https://leetcode.com/problems/is-graph-bipartite/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        if (bsf(color, i, adj) == false) return false;
      }
    }
    return true;
  }

  public boolean bsf(
    int[] color,
    int start,
    ArrayList<ArrayList<Integer>> adj
  ) {
    color[start] = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    while (q.size() > 0) {
      int current = q.poll();

      for (int ii : adj.get(current)) {
        if (color[ii] == -1) {
          color[ii] = 1 - color[current];
          q.add(ii);
        } else if (color[ii] == color[current]) {
          return false;
        }
      }
    }

    return true;
  }
}
