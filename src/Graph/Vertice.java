package Graph;
import java.util.Iterator;

class Vertice implements Iterable<Edge>{
	int begin;
	Edge edges=null;
	
	public Vertice(int a){
		begin=a;
	}
	
	@Override
	public Iterator<Edge> iterator() {
		return new EdgeIterator(edges);
	}
	
	public void deleteEdge(int end){
		if (edges==null){
			System.out.println("Delete edge from empty vertice");
			return;
		}
		if (edges.end==end){
			edges=edges.next;
		}else{
			Edge nowEdge=edges;
			while(nowEdge.next!=null){
				if (nowEdge.next.end==end){
					nowEdge.next=nowEdge.next.next;
					return;
				}else{
					nowEdge=nowEdge.next;
				}
			}
		}
	}
	
	@Override
	public String toString(){
		StringBuffer out=new StringBuffer();
		out.append(begin);
		out.append('\t');
		for(Edge edge:this){
			out.append(edge.toString());
		}
		return out.toString();
	}
}