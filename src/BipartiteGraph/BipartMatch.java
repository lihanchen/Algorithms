package BipartiteGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class BipartMatch {
	static int matches;
	
	public static void main(String args[]){
		int n1,n2,m,t1,t2,sign;
		Scanner in=new Scanner(System.in);
		Edge e;
		do{
			n1=in.nextInt();
			n2=in.nextInt();
			m=in.nextInt();
			BipartiteGraph g=new BipartiteGraph(n1, n2);
			while(m>0){
				t1=in.nextInt();
				t2=in.nextInt();
				g.addEdge(t1, t2-n1);
				m--;
			}
			sign=in.nextInt();

			bip_m(g);

			System.out.println(matches);
			for(int j=1;j<=g.NU;j++){
				e=g.U[j].edge;
				while(e!=null){
					if (e.isMatched==true)
						System.out.println(e.begin+" "+e.end);
					e=e.next;
				}
			}
			System.out.println(sign);
		}while(sign==0);
		in.close();
	}
	
	public static void bip_m(BipartiteGraph g){
		matches=0;
		for(;;){
			ArrayList<Integer> augmentingPath=findAugPath(g);
			if (augmentingPath==null) return;
			for(int i=0;i<augmentingPath.size()-1;i++){
				if (i%2==0)
					g.SwapMatched(augmentingPath.get(i), augmentingPath.get(i+1));
				else
					g.SwapMatched(augmentingPath.get(i+1), augmentingPath.get(i));
			}
			g.U[augmentingPath.get(0)].isMatched=true;
			g.V[augmentingPath.get(augmentingPath.size()-1)].isMatched=true;
			matches++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> findAugPath(BipartiteGraph g){
		LinkedList<ArrayList<Integer>> queue;
		ArrayList<Integer> t;
		int index,start;
		Edge e;
		queue=new LinkedList<ArrayList<Integer>>();
		for (int i=1;i<=g.NU;i++){
			if (g.U[i].isMatched==false){
				t=new ArrayList<Integer>();
				t.add(i);
				queue.add(t);
			}
		}
		do{
			t=queue.remove();
			index=t.size();
			start=t.get(index-1);
			if (index%2==1){
				e=g.U[start].edge;
				while (e!=null){
					if ((e.isMatched==false)&&(inPath(e.end, t, index)==false)){
						t.add(e.end);
						if (g.V[e.end].isMatched==false)
							return t;
						queue.add((ArrayList<Integer>)t.clone());
						t.remove(index);
					}
					e=e.next;
				}
			}else{
				e=g.V[start].edge;
				while (e!=null){
					if ((e.isMatched==true)&&(inPath(e.end, t, index)==false)){
						t.add(e.end);
						queue.add((ArrayList<Integer>)t.clone());
						t.remove(index);
					}
					e=e.next;
				}
			}
		}while(queue.isEmpty()==false);
		return null;
	}
	
	public static boolean inPath(int end, ArrayList<Integer> t,int index){
		if (index%2==1){
			for(int i=1;i<t.size();i+=2)
				if (t.get(i)==end) return true;
		}else{
			for(int i=0;i<t.size();i+=2)
				if (t.get(i)==end) return true;
		}
		return false;
	}
}
