package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFStraversal {

  // Breadth
  // Level Wise traversal

  //             1                                level 0
  //         /       `
  //     2               6                        2 and 6 are at disatnce 1, level 1
  // /     `         /     `
  // 3       4       7       8
  //          `     /
  //             5

  // starting Node is 1 at level 0,
  // if starting node is 1=> then BSF 1 2 3 3 4 7 8 5
  // if starting node is 6=> then BSF 6 1 7 8 2 5 3 4

  //Initial configuration
  // Queue Ds and will store the first node
  // Create a visited array of size+1 ie if 10 nodes then array(0->10)
  // starting node mark has 1

  // taking out till the queue becomes empty
  //  add the elementd's neighbour list into the queue (if not visited)
  // and mark the visited array on these element as visited

  public ArrayList<Integer> bfs(
    int V,
    ArrayList<ArrayList<Integer>> adjacencyList,
    int startingIndex
  ) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> ans = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    visited[startingIndex] = true;
    queue.add(startingIndex);

    while (!queue.isEmpty()) {
      int currentVertex = queue.poll();
      ans.add(currentVertex);

      for (Integer ii : adjacencyList.get(currentVertex)) {
        if (!visited[ii]) {
          visited[ii] = true;
          queue.add(ii);
        }
      }
    }

    return ans;
  }
  // space 0(3N)
  // Time O(N) + O(2E)

}
