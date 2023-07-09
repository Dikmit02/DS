package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class DetectCycleInUndorectedGraphBFS {

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        if (bsf(visited, i, adj)) return true;
      }
    }
    return false;
  }

  public boolean bsf(
    boolean[] visited,
    int Node,
    ArrayList<ArrayList<Integer>> adj
  ) {
    visited[Node] = true;
    Pair p = new Pair(Node, -1);
    Queue<Pair> q = new LinkedList<Pair>();
    q.add(p);
    while (q.size() > 0) {
      int current = q.peek().current;
      int parent = q.peek().parent;
      q.remove();

      for (int ii : adj.get(current)) {
        if (visited[ii] == false) {
          visited[ii] = true;
          Pair new_ = new Pair(ii, current);
          q.add(new_);
        } else if (parent != ii) {
          return true;
        }
      }
    }

    return false;
  }

  class Pair {
    int current;
    int parent;

    Pair(int current, int parent) {
      this.current = current;
      this.parent = parent;
    }
  }
}
