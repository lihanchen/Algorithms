package UnionFind;

public class test {
	public static void main(String args[]){
		UnionFind uf=new UnionFind(11);
		uf.union(1,2);
		uf.union(1,3);
		uf.union(4,5);
		uf.union(7,3);
		uf.union(4,10);
		uf.union(10,6);
		uf.union(6,1);
		for(int i=0;i<11;i++)
			uf.find(i);
		uf.printArray();
	}
}
