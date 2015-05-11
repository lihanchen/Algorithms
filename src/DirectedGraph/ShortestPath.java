package DirectedGraph;
import java.util.PriorityQueue;


public class ShortestPath{
	
	class WeightedVertice implements Comparable<WeightedVertice>{
		int weightTo;
		int vertice;
		
		public void changeWeight(Double w){
			
		}
		@Override
		public int compareTo(WeightedVertice o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	Edge path[];
	double weight=Double.POSITIVE_INFINITY;
	DirectedGraph g;
	int numOfV,startPoint,point;
	
	public ShortestPath(DirectedGraph g, int startPoint){
		this.g=g;
		numOfV=g.V.size();
		this.startPoint=startPoint;
	}
	
	public void dijkstra(){//undone
		double weightTo[]=new double[numOfV];
		int pathTo[]=new int[numOfV];
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		
		point=startPoint;
		//pq.
		
		
		for(int i=1;i<numOfV;){
			for(Edge e: g.V.get(point)){
				pq.add(e);
				if(weightTo[e.end]>((WeightedEdge)e).weight+weightTo[point]){
					weightTo[e.end]=((WeightedEdge)e).weight+weightTo[point];
					pathTo[e.end]=point;
				}
				
			}
			
				point=pq.remove().end;
		}

	}
}
