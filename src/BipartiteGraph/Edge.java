package BipartiteGraph;

class Edge{
	int begin;
	int end;
	boolean isMatched;
	Edge next=null;
	
	public Edge(int begin, int end, Edge next){
		this.isMatched=false;
		this.begin=begin;
		this.end=end;
		this.next=next;
	}
	
	public String toString(){
		return begin+","+end;
	}

}