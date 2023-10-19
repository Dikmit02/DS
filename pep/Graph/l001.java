public class l001{
	private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	public static void main(String[] args){
		solve();
	}

	static class edge{
		int u=0;
		int v=0;
		int wt=0;

		edge(int v1, int v2, int wt) {
			this.u = v1;
			this.v = v2;
			this.wt = wt;
		}
	}

	public static addEdge(ArrayList< ArrayList< edge > > graph, int v1, int v2 , int weight){
		if (v1 < graph.size() && v2 < graph.size()) {
		graph.get(v1).add(new edge(v1,v2,weight));
		graph.get(v2).add(new edge(v2,v1,weight));
		}
	}

	public static void solve() {
		ArrayList< ArrayList< edge > > graph = new ArrayList<>();
		for(int i = 0 ; i < 7 ; i++ ){
			graph.add(new ArrayList<edge>());
        }
        
        addEdge(graph,0,1,2);
        addEdge(graph,0,3,10);
        addEdge(graph,1,2,3);
        addEdge(graph,3,2,7);
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,2);
        addEdge(graph,4,6,3);
        addEdge(graph,5,6,8)

	}

	static void display(ArrayList<ArrayList<edge>> graph){
		for(int cv = 0 ; cv < graph.size() ; cv++){
			System.out.print(cv + " -> ");
			for(int ce = 0; ce< graph.get(cv).size(); ce++){
				edge e = graph.get(cv).get(ce);
				System.out.print( "(" + e.v + "," + e.wt +"), "  );
			}
			System.out.println();
		}

	}

}