package KMP;


public class KMP {
	public int dfa[][];
	public final int NUMOFLETTERS=256;
	public KMP(String pattern){
		int length=pattern.length();
		int i,j,X=0;
		dfa=new int[NUMOFLETTERS][length];
		for(i=0;i<NUMOFLETTERS;i++){
			dfa[i][0]=0;
		}
		dfa[pattern.charAt(0)][0]=1;
		for(i=1;i<length;i++){
			for(j=0;j<NUMOFLETTERS;j++)
				dfa[j][i]=dfa[j][X];
			dfa[pattern.charAt(i)][i]=i+1;
			X=dfa[pattern.charAt(i)][X];
		}
	}
	public int search(String text){
		int i,j=0;
		for(i=0;i<text.length();i++){
			j=dfa[text.charAt(i)][j];
			if (j==dfa[0].length) return i-j+1;
		}
		return -1;
	}
}
