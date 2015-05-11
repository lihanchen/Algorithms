package DirectedGraph;
class Edge{
	int begin;
	int end;
	Edge next=null;
	
	public Edge(int begin, int end, Edge next){
		this.begin=begin;
		this.end=end;
		this.next=next;
	}
	
	@Override
	public String toString(){
		return "<"+begin+","+end+">";
	}
}