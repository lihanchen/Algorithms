package BipartiteGraph;


class Vertice{
	int start;
	Edge edge=null;
	boolean isMatched;

	public Vertice(int a){
		start=a;
		isMatched=false;
	}
	
	public void addEdge(int end){
		edge=new Edge(start, end, edge);
	}
}