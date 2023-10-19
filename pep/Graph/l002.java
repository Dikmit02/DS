public class l002{
	public static void main(String[] args){
        solve();
    }

	public static void solve(){
        constructGraph();

	}

	public class Edge{
		int v = 0;
        int w = 0;

        Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
	}

	public static void addEdge(int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }


	public static void constructGraph(){
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		for(int i = 0 ; i < 7 ; i++ ){
			graph.add(new ArrayList<edge>());
        }
		addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(5,6,3);
        addEdge(4,6,8);

        addEdge(0,6,1);
        addEdge(2,5,1);

	}
}