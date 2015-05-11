package Graph;
import java.util.Scanner;


public class testGraph {
	public static void main(String args[]){
		Graph g=new Graph(8);
		g.addWeightedEdge(4,5,0.35);
		g.addWeightedEdge(4,7,0.37);
		g.addWeightedEdge(7,5,0.28);
		g.addWeightedEdge(0,7,0.16);
		g.addWeightedEdge(1,5,0.32);
		g.addWeightedEdge(4,0,0.38);
		g.addWeightedEdge(2,3,0.17);
		g.addWeightedEdge(1,7,0.19);
		g.addWeightedEdge(0,2,0.26);
		g.addWeightedEdge(1,2,0.36);
		g.addWeightedEdge(1,3,0.29);
		g.addWeightedEdge(2,7,0.34);
		g.addWeightedEdge(6,2,0.4);
		g.addWeightedEdge(3,6,0.52);
		g.addWeightedEdge(6,0,0.58);
		g.addWeightedEdge(6,4,0.93);
		g.print();
		Search.breadthFirstSearch(g);
		//testMST(g);
		
	}
	
	public static void testMST(Graph g){
		MinimalSpanningTree mst=new MinimalSpanningTree(g);
		mst.kruskal();
		mst.print();
		mst.prim();
		mst.print();
	}
}
