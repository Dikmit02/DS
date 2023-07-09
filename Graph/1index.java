package Graph;

import java.util.ArrayList;

class index {

  // N => the number nodes
  // M => the number of edges

  // Undirected graph

  // Store
  // 1) adjacency matrix
  //   adj[n+1][adj+1]  adj[i][j]=1 and adj[j][i]=1 else other will be 0
  //   space= N*N
  //   not appreciable

  // 2) adjacency list
  // ArrayList<ArrayList<Integer> adjList = new ArrayList<Integer>();
  //  run a loop and add n+1 ArrayList<Integer> to adjList

  public static void main(String[] args) {
    //Space O(2M)
    int n = 3; //the number nodes
    // int m=3;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i < n + 1; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    //edge 1-----2 (undirected graph)
    adjList.get(1).add(2);
    adjList.get(2).add(1);

    //edge 1----->2 (directed graph)
    adjList.get(1).add(2);
    // if the graph is weighted then rather than storing the integer we will store the pairs
    //{directedBide, weight}=> pair
  }
  // We have to store a visited Array of nodes that will be of type boolean
  // if the nodes are true, that means the node has been already visited
  // if the nodes are not visited, than run the traversal on that node

  // The travesal  pattern

  // for( i=0->i<10){
  //     if(!vis[i]){
  //         traversal(i)
  //     }
  // }

}
// for BFS=>queue se nikalne pr add in answer and us node k childs par traverse
