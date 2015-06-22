
public class HEAP_SORT {
	
	private int size;
	private int[] a;
	
	HEAP_SORT(int a[]){
		size=a.length;
		this.a = a;
		heapify(this.a);
	}
	
	public void sort(){
		
		int b[] = new int[a.length];
		for(int i=0; i<a.length; i++){
			b[i] = pop();
		}
		
		for(int i=0; i<a.length; i++){
			System.out.print(b[i] + " ");
		}
		
	}
	
	public void heapify(int a[]){
		int counter=1;
		while(counter*2<size){
			counter*=2;
		}
		counter--;
		for(int i=counter; i>=0; i--)
			heapify(a, i);	
	}
	
	private void heapify(int a[], int index){
		if(size>(index+1)*2){
			if(a[(index+1)*2]<a[index] && a[(index+1)*2-1]<a[index]){
				if(a[(index+1)*2]>=a[(index+1)*2-1]){
					int swap = a[index];
					a[index] = a[(index+1)*2-1];
					a[(index+1)*2-1] = swap;
					heapify(a, (index+1)*2-1);
				} else {
					int swap = a[index];
					a[index] = a[(index+1)*2];
					a[(index+1)*2] = swap;
					heapify(a, (index+1)*2);	
				}
			}else{
				if(a[(index+1)*2]<a[index]){
					int swap = a[index];
					a[index] = a[(index+1)*2];
					a[(index+1)*2] = swap;
					heapify(a, (index+1)*2);
				}
				if(a[(index+1)*2-1]<a[index]){
					int swap = a[index];
					a[index] = a[(index+1)*2-1];
					a[(index+1)*2-1] = swap;
					heapify(a, (index+1)*2-1);
				}
			}
		}else if(size==(index+1)*2){
			if(a[(index+1)*2-1]<a[index]){
				int swap = a[index];
				a[index] = a[(index+1)*2-1];
				a[(index+1)*2-1] = swap;
				heapify(a, (index+1)*2-1);
			}
			
		}
	}
	
	public int pop(){
		int value=a[0];
		int swap = a[0];
		a[0]=a[size-1];
		a[size-1]=swap;
		size--;
		heapify(a, 0);
		return value;
	}
	
	/*
	public static void main(String[] args) {
		int a[]  = {0, 1, 5, 6, 4, 9, 7, 2, 3, 8};
		
		new Heapsort(a).sort();
		
	}
	*/
	
}
