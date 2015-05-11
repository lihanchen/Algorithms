package BipartiteGraph;


public class BipartiteGraph {
	Vertice U[],V[];
	int NU;
	
	public BipartiteGraph(int u, int v){
		NU=u;
		U=new Vertice[u+1];
		for (int i=1;i<=u;i++)
			U[i]=new Vertice(i);
		V=new Vertice[v+1];
		for (int i=1;i<=v;i++)
			V[i]=new Vertice(i);
	}
	
	public void addEdge(int a, int b){
		U[a].addEdge(b);
		V[b].addEdge(a);
	}
	
	public void SwapMatched(int a, int b){
		Edge e=U[a].edge;
		while(e!=null){
			if (e.end==b){
				e.isMatched=!e.isMatched;
				break;
			}else
				e=e.next;
		}
		e=V[b].edge;
		while(e!=null){
			if (e.end==a){
				e.isMatched=!e.isMatched;
				break;
			}else
				e=e.next;
		}
	}
}
