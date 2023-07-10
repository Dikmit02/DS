package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class CycleDetectionInDirectedGraphUsingKhansAlgo {

  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[] = new int[V];
    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }
    int count = 0;
    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();
      count++;
      // node is in your topo sort
      // so please remove it from the indegree

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }
    if (count == V) return false;
    return true;
  }
}
