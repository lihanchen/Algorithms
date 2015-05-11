package Sort;

public class HeapSort {
	private static Comparable temp;
	public static void sink(Comparable a[],int n, int total){
		while(2*n<total){
			if((2*n+1>total) || (a[2*n].compareTo(a[2*n+1])>0)){
				if(a[2*n].compareTo(a[n])>0){
					temp=a[2*n];
					a[2*n]=a[n];
					a[n]=temp;
					n*=2;
				}else
					return;
			}else{
				if(a[2*n+1].compareTo(a[n])>0){
					temp=a[2*n+1];
					a[2*n+1]=a[n];
					a[n]=temp;
					n=2*n+1;
				}else
					return;
			}
		}
	}
	
	public static void heapSort(Comparable a[]){
		int n;
		for(n=(a.length-1)/2;n>=1;n--){
			sink(a,n,a.length-1);
		}
		n=a.length-1;
		while(n>1){
			temp=a[1];
			a[1]=a[n];
			a[n]=temp;
			sink(a,1,n-1);
			n--;
		}
	}

}
