package Graph;
import java.util.Iterator;

class EdgeIterator implements Iterator<Edge>{
	Edge edge=null;
	public EdgeIterator(Edge startEdge){
		edge=startEdge;
	}

	@Override
	public boolean hasNext() {
		return edge!=null;
	}

	@Override
	public Edge next() {
		Edge t=edge;
		edge=edge.next;
		return t;
	}

	@Override
	public void remove() {}
}