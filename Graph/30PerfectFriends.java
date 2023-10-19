https://www.pepcoding.com/resources/online-java-foundation/graphs/perfect-friends-official/ojquestion

// 1. You are given a number n (representing the number of students). Each student will have an id 
//      from 0 to n - 1.
// 2. You are given a number k (representing the number of clubs)
// 3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
//      students belonging to same club.
// 4. You have to find in how many ways can we select a pair of students such that both students are 
//      from different clubs.


// First find all the connected component list and then add all the different pairs


public static void gcc(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
	comp.add(src);
	visited[src] = true;
	for (Edge e : graph[src]) {
	   if (!visited[e.nbr]) {
		  gcc(graph, e.nbr, visited, comp);
	   }
	}
 }

 psvm(){
	boolean[] visited = new boolean[vtces];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      for(int v = 0; v < vtces; v++){
         if(visited[v] == false){
            ArrayList<Integer> comp = new ArrayList<>();
            gcc(graph, v, visited, comp);
            comps.add(comp);
         }
      }

      int count = 0;
      for(int i = 0; i < comps.size(); i++){
         for(int j = i + 1; j < comps.size(); j++){
            count += comps.get(i).size() * comps.get(j).size();
         }
      }
      System.out.println(count);
 }