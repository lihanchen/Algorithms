package Graph;
import java.util.*;

public class Search {
	public static void doWork(Vertice v){
		System.out.print(v.begin+" ");
	}
	
	public static void depthFirstSearch(Graph g){
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]=new boolean[g.V.size()];
		for(int i=0;i<visited.length;i++){
			visited[i]=false;
		}
		for(int i=0;i<visited.length;i++){
			stack.push(i);
			do{
				int next=stack.pop();
				Vertice v= g.V.get(next);
				if (visited[next]==true) continue;
				visited[next]=true;
				doWork(v);
				for(Edge e:v)
					stack.push(e.end);
			}while(stack.isEmpty()==false);
		}
	}
	
	public static void breadthFirstSearch(Graph g){
		LinkedList<Integer> q=new LinkedList<Integer>();
		boolean visited[]=new boolean[g.V.size()];
		for(int i=0;i<visited.length;i++){
			visited[i]=false;
		}
		for(int i=0;i<visited.length;i++){
			q.add(i);
			do{
				int temp=q.remove();
				Vertice v=g.V.get(temp);
				if (visited[temp]==true) continue;
				visited[temp]=true;
				doWork(v);
				for(Edge e:v)
					q.add(e.end);
			}while(q.isEmpty()==false);
		}
	}
}
