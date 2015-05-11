package KMP;


public class Test {
	public static void main(String args[]){
		KMP k=new KMP("PerfectFelina");
		String t="qwewqrfsaojsdPerfectFvPerfectFlPerfectFsdjjwsnujvbreubvkdjnclskPerfectFelina";
		System.out.println(k.search(t));
	}
}
