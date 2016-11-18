import java.io.*;
import java.util.*;
public class MinHeap {
	
	ArrayList<Integer> min = new ArrayList<Integer>();
	int index; //Index will keep track of the last element in the heap at any given point of time
	int i;
	public MinHeap(){
		
		index = 0;
		i = 1;
	}
	
	public void buildHeap(ArrayList<Integer> arr){
		
		for(int x=0; x<arr.size(); x++){
			insert(arr.get(x));
		}
	}	
	
	public void insert(int num){
		
			
			//We want to start our heap from index 1 as opposed to index 0
			if(index == 0){
				min.add(-9999);
				//index++;
				min.add(index+1, num);
				index=2;
			}
			else{
				min.add(index++, num);
				heapifyUp();
				
			}
	
	}
			
	public void heapifyUp(){
		
		int ind = index-1;
		int parent = ind/2;
		int child = ind;
		
		while(min.get(parent) > min.get(child) && child > 0){
			
			//Swap the "child" with its "parent"
			int temp = min.get(child);
			min.set(child, min.get(parent));
			min.set(parent, temp);
			
			ind = ind/2;
			parent = ind/2;
			child = ind;
		}
	}
	
	public int extract_min(){
		
		int top = min.get(1);
		min.set(1, min.get(index-1));
		min.remove(index-1);
		index--;
		
		if(index > 0)
			heapifyDown(1);
		
		return(top);
	}
	
	public void heapifyDown(int x){
		
		int temp;
		i = x;
		//2i is the left child and 2i+1 is the right child
		
		if((2*x) < index && (min.get(i) > min.get(2*x)))
			i=2*x;
		if((2*x+1) < index && (min.get(i) > min.get(2*x+1)))
			i=2*x+1;

		if(i!=x){
			//Swap values at i and x
			temp = min.get(x);
			min.set(x, min.get(i));
			min.set(i, temp);	
			
			heapifyDown(i);
		}
		
	}

	
	public void display(){
		
		for(int i=1; i<min.size(); i++){
			System.out.print(min.get(i) + " ");
		}
	}
	public void swap(int x1, int x2){
		
		int temp;
		
		temp = x1;
		x1 = x2;
		x2 = temp;
	}

	public static void main(String[] args)throws IOException {
		
		MinHeap mh = new MinHeap();
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(4); a.add(8); a.add(12); a.add(2); a.add(10); a.add(65);a.add(5);a.add(27); a.add(13); a.add(87); a.add(3); a.add(1);
		mh.buildHeap(a);
		
		System.out.println("The Min Heap is: ");
		mh.display();
		
		System.out.println();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		System.out.println("The extracted min is " + mh.extract_min());
		mh.display();
		
		
		
	}

}
