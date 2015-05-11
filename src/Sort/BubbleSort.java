package Sort;


public class BubbleSort {
	public static void bubbleSort(Comparable a[]){
		int comparison=0, assign=0;
		Comparable t;
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				comparison++;
				if (a[j].compareTo(a[j+1])>0){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
					assign+=3;
				}
			}
		}
		System.out.println("compare:"+comparison+"\tassign:"+assign);
	}
}
