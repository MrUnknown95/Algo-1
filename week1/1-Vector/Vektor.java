
public class Vektor {
	
	static class Vector{
		private int data[];
		private int size;
		private int capacity;
		
		public Vector(){
			data = new int[4];
			size = 0;
			capacity = 4;
		}
		
		public void insert(int index, int value){
			if(index<=size && index>=0){
				if(size==capacity){
					int newData[] = new int[capacity*2];
					capacity*=2;
					
					for(int i=0; i<index; i++){
						newData[i] = data[i]; 
					}
					
					newData[index] = value;
					
					for(int i=index; i<size; i++){
						newData[i+1]=data[i];
					}
					data = newData;
				} else {
					data[size]=value;
					for(int i=size; i>index; i--){
						int swap = data[i];
						data[i]=data[i-1];
						data[i-1]=swap;
					}
				}
				size++;
			}
			else{
				System.out.println("Invalid argument");
			}
		}
		
		
		public void add(int value){
			insert(size, value);
		}
		
		public int get(int index){
			if(index<size && index>=0) return data[index];
			else {System.out.println("Invalid argument");
			return 0;}
		}
		
		void remove(int index){
			if(index<size && index>=0){
				
				if((double)size==(double)capacity/4){
					int newData[] = new int[capacity/2];
					capacity/=2;
					for(int i=0; i<index; i++){
						newData[i]=data[i];
					}
					
					for(int i=index; i<size; i++){
						newData[i]=data[i+1];
					}

					data = newData;	
					size--;
				}
				else
				{
					for(int i=index; i<size-1; i++){
						int swap = data[i];
						data[i] = data[i+1];
						data[i+1]=swap;
					}
					size--;
				}
				
			}else{
				System.out.println("Invalid argument!");
			}
			
		}
		
		public void pop(){
			remove(size-1);
		}
		
		public void print(){
			System.out.println();
			for(int i=0; i<size; i++){
				System.out.print(data[i] + " ");
			}
			if(size==0) System.out.print("EMPTY");
		}
		
		public int getCapacity(){
			return capacity;
		}
		
		public int getSize(){
			return size;
		}
		
		
	}

	public static void main(String[] args) {
		
		Vector v = new Vector();
		v.add(1);
		v.print();
		v.pop();
		v.print();

	}

}
