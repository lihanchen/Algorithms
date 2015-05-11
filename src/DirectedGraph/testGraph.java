package DirectedGraph;
import java.util.Scanner;


public class testGraph {
	public static void main(String args[]){
		DirectedGraph g=new DirectedGraph(6);
		g.addWeightedEdge(0,1,16);
		g.addWeightedEdge(0,2,15);
		g.addWeightedEdge(1,3,12);
		g.addWeightedEdge(2,1,4);
		//g.addWeightedEdge(1,2,10);
		//g.addWeightedEdge(3,2,9);
		g.addWeightedEdge(2,4,14);
		g.addWeightedEdge(4,3,7);
		g.addWeightedEdge(3,5,20);
		g.addWeightedEdge(4,5,4);
		g.print();
		
		/*Vertice[] t=ToplogicalSort.toplogicalSortEasy(g);
		for(Vertice v:t)
			System.out.print(v.begin+" ");*/
		
		/*System.out.println("\nDFS");
		Search.depthFirstSearch(g);
		System.out.println("\nBFS");
		Search.breadthFirstSearch(g);*/
		
		ShortestPath s=new ShortestPath(g, 0);
		s.dijkstra();
	
	}
	

}
