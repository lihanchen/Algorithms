package Graph;
import java.util.ArrayList;

class Graph {
	ArrayList<Vertice> V;
	
	public Graph(int m){
		V= new ArrayList<Vertice>(m);
		for(int i=0;i<m;i++){
			V.add(new Vertice(i));
		}
	}
	
	public Edge find(int begin, int end){
		for(Edge edge:V.get(begin))
			if (edge.end==end) return edge;
		for(Edge edge:V.get(end))
			if (edge.end==begin) return edge;
		return null;
	}
	
	public void deleteEdge(Edge edge){
		V.get(edge.begin).deleteEdge(edge.end);
		V.get(edge.end).deleteEdge(edge.begin);
	}
	
	public void addEdge(int begin, int end){
			Edge f;
			f=find(begin,end);
			if (f!=null)
				System.out.println("Error! Edge "+f+" exists.");
			else{
				V.get(begin).edges=new Edge(begin,end,V.get(begin).edges);
				V.get(end).edges=new Edge(end,begin,V.get(end).edges);
			}
	}
	
	public void addWeightedEdge(int begin, int end, double weight){
		Edge f;
		f=this.find(begin,end);
		if (f!=null)
			System.out.println("Error! Edge "+f+" exists.");
		else{
			V.get(begin).edges=new WeightedEdge(begin,end,(WeightedEdge)V.get(begin).edges,weight);
			V.get(end).edges=new WeightedEdge(end,begin,(WeightedEdge)V.get(end).edges,weight);
		}
	}
	
	public void addWeightedEdge(WeightedEdge e){
		addWeightedEdge(e.begin, e.end, e.weight);
	}
	
	public void print(){
		System.out.println();
		for(int i=0;i<V.size();i++){
			System.out.println(V.get(i));
		}
		System.out.println();
	}
}
