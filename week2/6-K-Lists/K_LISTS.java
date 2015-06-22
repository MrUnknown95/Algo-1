import java.util.ArrayList;
import java.util.List;

public class K_LISTS {
	
	public static void merge(List<Node> p){
		Heapsort h = new Heapsort(p);
		
		Node list = h.pop();
		Node counter = list;
		
		while(h.getSize()!=0){
			counter.next=h.pop();
			counter=counter.next;
		}
		
		counter=list;
		while(counter!=null){
			System.out.print(counter.value+" ");
			counter=counter.next;
		}
	}
	
	static class Node{
		
		public int value;
		public Node next;
		
		Node(){
			value = 0;
			next = null;
		}
		
		Node(int value){
			this.value = value;
			next = null;
		}
		
		Node(int value, Node next){
			this.value = value;
			this.next = next;
		}
		
	}
	
	static class Heapsort {
		
		private int size;
		private Node[] a;
		
		Heapsort(List<Node> a){
			size=a.size();
			this.a = new Node[size];
			
			for(int i=0; i<size; i++){
				this.a[i]=a.get(i);
			}
			
			heapify(this.a);
		}
		
		public int getSize(){
			return size;
		}
		
		public void heapify(Node a[]){
			int counter=1;
			while(counter*2<size){
				counter*=2;
			}
			counter--;
			for(int i=counter; i>=0; i--)
				heapify(a, i);	
		}
		
		private void heapify(Node a[], int index){
			if(size>(index+1)*2){
				if(a[(index+1)*2].value<a[index].value && a[(index+1)*2-1].value<a[index].value){
					if(a[(index+1)*2].value>=a[(index+1)*2-1].value){
						
						Node swap = a[index];
						a[index]=a[(index+1)*2-1];
						a[(index+1)*2-1]=swap;
						 
						heapify(a, (index+1)*2-1);
					} else {
						Node swap = a[index];
						a[index]=a[(index+1)*2];
						a[(index+1)*2]=swap;
						
						heapify(a, (index+1)*2);	
					}
				}else{
					if(a[(index+1)*2].value<a[index].value){
						
						Node swap = a[index];
						a[index]=a[(index+1)*2];
						a[(index+1)*2]=swap;
						
						heapify(a, (index+1)*2);
					}
					if(a[(index+1)*2-1].value<a[index].value){
						Node swap = a[index];
						a[index]=a[(index+1)*2-1];
						a[(index+1)*2-1]=swap;
						
						heapify(a, (index+1)*2-1);
					}
				}
			}else if(size==(index+1)*2){
				if(a[(index+1)*2-1].value<a[index].value){
					Node swap = a[index];
					a[index] = a[(index+1)*2-1];
					a[(index+1)*2-1] = swap;
					heapify(a, (index+1)*2-1);
				}
			}
		}
		
		public Node pop(){
			
			Node t = a[0].next;
			
			int value=a[0].value;
			int swap = a[0].value;
			a[0].value=a[size-1].value;
			a[size-1].value=swap;
			
			Node k = a[0].next;
			a[0].next = a[size-1].next;
			a[size-1].next = k;
			
			size--;
			heapify(a, 0);
			
			if(t!=null){
				push(t);
			}
			
			return new Node(value);
		}
		
		public void push(Node p){
			this.a[size]=new Node(p.value, p.next);
			size++;
			
			int counter=size-1;
			while(a[(counter-1)/2].value > a[counter].value && counter>=0){
				
				Node swap = a[(counter-1)/2];
				a[(counter-1)/2] = a[counter];
				a[counter] = swap;
				
				counter = (counter-1)/2;
			}
		}
	}
	
	/*

	public static void main(String[] args) {
		List<Node> p = new ArrayList<Node>();
		
		p.add(new Node(3, new Node(5, new Node(7, new Node(9)))));
		// 3 5 7 9
		p.add(new Node(2, new Node(4, new Node(6))));
		//2 4 6
		p.add(new Node(0, new Node(1, new Node(8, new Node(10)))));
		//0 1 8 10
		merge(p);
		
	}
	
	*/
}