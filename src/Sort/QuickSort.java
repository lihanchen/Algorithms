package Sort;

public class QuickSort {
	public static void quickSort(Comparable a[]){
		
		//int comparison=0, assign=0;
		int stack[][]=new int[(int)(1.5*Math.log(a.length)/Math.log(2)+5)][2];
		int pointer=1;
		stack[0][0]=0;
		stack[0][1]=a.length;
		
		int i,j,l,h;
		Comparable midValue;
		while(pointer>0){
			l=stack[pointer-1][0];
			h=stack[pointer-1][1];
			midValue=a[l];
			i=l;
			j=h-1;
			//assign+=5;
			while(i<j){
				while ((i<j)&&(a[j].compareTo(midValue)>=0)) {
					j--;
					//comparison+=2;
				}
				//comparison+=1;
				if (i<j) {
					//assign+=2;
					a[i]=a[j];
					i++;
				}
				while ((i<j)&&(a[i].compareTo(midValue)<=0)) {
					i++;
					//comparison+=2;
				}
				//comparison+=1;
				if (i<j){
					//assign+=2;
					a[j]=a[i];
					j--;
				}
			}
			//assign+=2;
			a[i]=midValue;
			pointer--;
			if (i-l>1){
				//assign+=3;
				stack[pointer][0]=l;
				stack[pointer][1]=i;
				pointer++;
			}
			if (h-i>2){
				//assign+=3;
				stack[pointer][0]=i+1;
				stack[pointer][1]=h;
				pointer++;
			}
		}
			
		//System.out.println("compare:"+comparison+"\tassign:"+assign);
	}
	
	public static void quickSortXZM(Comparable a[]){
		quickSortXZM(a,0,a.length);
	}
	
	private static void quickSortXZM(Comparable a[], int front, int end){
		int i=front;
		int j=end-1;
		Comparable temp=a[i];
		while(true){
			while((a[j].compareTo(temp)!=-1)&&(j!=i)){
				j--;
			}
			if(j==i)
				break;
			a[i]=a[j];
			i++;
			
			while((a[i].compareTo(temp)!=1)&&(j!=i)){
				i++;
			}
			if(j==i)
				break;
			a[j]=a[i];
			j--;
		}
		a[i]=temp;
		if(i-front>1)
			quickSortXZM(a,front,i);
		if(end-j>2)
			quickSortXZM(a,j+1,end);
	}
}
