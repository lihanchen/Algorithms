package DirectedGraph;

public class ToplogicalSort {
	public static Vertice[] toplogicalSortEasy(DirectedGraph g){
		Vertice [] toplog=new Vertice[g.V.size()];
		int[] in=new int[g.V.size()];
		for(Vertice v:g.V)
			in[v.begin]=v.degreeIn;
		for(int j=0;j<in.length;j++)
			for(int n=0;n<in.length;n++)
				if(in[n]==0){
					toplog[j]=g.V.get(n);
					in[n]--;
					for(Edge e:g.V.get(n))
						in[e.end]--;
					break;
				}
		return toplog;
	}
}

