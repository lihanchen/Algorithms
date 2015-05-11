package UnionFind;

public class UnionFind {

	private int[] array;
	private int size;
	private int[] treeSize;
	
	public UnionFind(int n){
		size=n;
		array = new int[n];
		treeSize = new int[n];
		for(int i=0;i<n;i++){
			array[i]=i;
			treeSize[i]=1;
		}
	}
	
	public void union(int a, int b){
		int m=find(a);
		int n=find(b);
		if (treeSize[m]<=treeSize[n]){
			array[m]=n;
			treeSize[n]+=treeSize[m];
			array[a]=n;
		}else{
			array[n]=m;
			treeSize[m]+=treeSize[n];
			array[b]=m;
		}
	}
	
	public int find(int a){
		int b=a,t=0;
		while(array[a]!=a)
			a=array[a];
		while(b!=a){
			t=array[b];
			array[b]=a;
			b=t;
		}
		return a;
	}
	
	public boolean isConnected(int a, int b){
		return find(a)==find(b);
	}
	
	public void printArray(){
		for(int i=0;i<size;i++)
			System.out.print(i+" "+array[i]+"\n");
		System.out.print("\n\n\n");
	}
}
