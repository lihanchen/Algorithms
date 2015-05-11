package Graph;
import java.util.*;

public class MinimalSpanningTree {
	Graph g;
	int N;
	ArrayList<WeightedEdge> MST;
	double MSTvalue=-1;
	
	public MinimalSpanningTree(Graph g) {
		this.g=g;
		N=g.V.size();
	}
	
	public void kruskal(){
		MSTvalue=0;
		ArrayList<WeightedEdge> tempE=new ArrayList<WeightedEdge>();
		MST=new ArrayList<WeightedEdge>(N-1);
		for(Vertice a:g.V)
			for(Edge e:a)
				if (e.begin<=e.end) tempE.add((WeightedEdge)e);
		WeightedEdge E[]=new WeightedEdge[tempE.size()];
		tempE.toArray(E);
		Arrays.sort(E);
		int Epointer=0;
		
		UnionFind u=new UnionFind(N);
		
		for(int i=0;i<N-1;){
			if(u.isConnected(E[Epointer].begin,E[Epointer].end)){
				Epointer++;
			}else{
				u.union(E[Epointer].begin,E[Epointer].end);
				MST.add(E[Epointer]);
				MSTvalue+=E[Epointer].weight;
				Epointer++;
				i++;
			}
		}
	}
	
	public void prim(){

		boolean visited[]=new boolean[g.V.size()];
		PriorityQueue<WeightedEdge> pq=new PriorityQueue<WeightedEdge>();
		MST=new ArrayList<WeightedEdge>(N-1);
		MSTvalue=0;
		for(int i=1;i<visited.length;i++){
			visited[i]=false;
		}
		
		int next=0;
		visited[next]=true;
		WeightedEdge e;
		for(Edge edge:g.V.get(next)){
			pq.add((WeightedEdge)edge);
		}
		
		for(int i=0;i<N-1;i++){
			do{
				e=pq.remove();
			}while( (visited[e.begin]==true) && (visited[e.end]==true) );
			next=e.end;
			visited[next]=true;
			for(Edge edge:g.V.get(next)){
				pq.add((WeightedEdge)edge);
			}
			MST.add(i,e);
			MSTvalue+=e.weight;
		}
	}
	
	public void print(){
		//g.print();
		System.out.println("\nMST:\nTotal value: "+MSTvalue);
		for (WeightedEdge e:MST){
			System.out.println(e);
		}
	}
}
