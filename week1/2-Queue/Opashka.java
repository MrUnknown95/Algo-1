
public class Opashka {
	static class Queue{
		class Node{
			Node next;
			int value;
			
			Node(int value){
				this.value = value;
				next = null;
			}
			
		}
		
		private Node start, end;
		private int size;
		
		public Queue(){
			start = null;
			end = null;
			size=0;
		}
		
		public void push(int value){
			if(size==0){
				start = new Node(value);
				end = start;
			}else{
				end.next = new Node(value);
				end = end.next;
			}
			size++;
		}
		
		public int pop(){
			if(size==0){
				System.out.println("Can't pop on empty queue!");
				return 0;
			}else {
				int val = start.value;
				start=start.next;
				if(start==null) end=null;
				size--;
				return val;}
		}
		
		public int peek(){
			return start.value;
		}
		
		public int size(){
			return size;
		}
		
		
		
		public void print(){
			Node t=start;
			while(t!=null){
				System.out.print(t.value + " ");
				t=t.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		Queue q = new Queue();
		q.push(3);
		q.push(4);
		q.print();
		System.out.println(q.peek());
		q.print();

	}

}
