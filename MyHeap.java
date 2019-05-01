import java.util.*;
public class MyHeap{
    private static void swap(int[] data, int index1, int index2) {
	int old = data[index1];
	data[index1] = data[index2];
	data[index2] = old;
    }
    private static void pushDown(int[]data,int size,int index) {
	int child1 = 2*index + 1;
	int child2 = 2*index + 2;
	if (!(child2>=size)) {
	    //System.out.println("children" + data[child1] + " " + data[child2]);
		if (data[child1] > data[index] && data[child1] > data[child2]) {
		    swap(data, index, child1);
		    pushDown(data, size, child1);
		} else if (data[child2] >= data[index]) {
		    swap(data, index, child2);
		    pushDown(data, size, child2);
		}
	}
    }
    private static void pushUp(int[] data, int index) {
	int parent = (index-1)/2;
	if (!(parent<0) && data[index] > data[parent]) {
	    swap(data, index, parent);
	    pushUp(data, parent);
	}
    }
    public static void heapify(int[] data) {
	int parent = data.length-1 / 2;
	for(int i = parent; i >= 0; i--) {
	    pushDown(data, data.length, i);
	    //HeapPrinter.print(data);
	}
    }
    public static void heapsort(int[] data) {
	heapify(data);
	//HeapPrinter.print(data);
	for(int i = data.length-1; i > 0; i--) {
	    // System.out.println("before: ");
	    // HeapPrinter.print(data);
	    swap(data, 0, i);
	    // System.out.println("SwapIndex: " + swapIndex);
	    // HeapPrinter.print(data);
	    pushDown(data, i, 0);
	}
	//swap(data, 0, 1);
    }
    public static void main(String[] args) {
	int[] ary = new int[]{1, 2, 3, 4, 5, 6, 9, 7, 6};
	//heapify(ary);
	heapsort(ary);
	HeapPrinter.print(ary);
	System.out.println(Arrays.toString(ary));
	int[]MAX_LIST = {1000000000,500,10};
    	for(int MAX : MAX_LIST){
    	    for(int size = 31250; size < 2000001; size*=2){
    		long qtime=0;
    		long btime=0;
    		//average of 5 sorts.
    		for(int trial = 0 ; trial <=5; trial++){
    		    int []data1 = new int[size];
    		    int []data2 = new int[size];
    		    for(int i = 0; i < data1.length; i++){
    			data1[i] = (int)(Math.random()*MAX);
    			data2[i] = data1[i];
    		    }
    		    long t1,t2;
    		    t1 = System.currentTimeMillis();
    		    heapsort(data2);
    		    t2 = System.currentTimeMillis();
    		    qtime += t2 - t1;
    		    t1 = System.currentTimeMillis();
    		    Arrays.sort(data1);
    		    t2 = System.currentTimeMillis();
    		    btime+= t2 - t1;
    		    if(!Arrays.equals(data1,data2)){
			for(int i = 0; i < data1.length; i++) {
			    if(data1[i] != data2[i]) {
				System.out.println(i);
				System.out.println(data1[i]);
				System.out.println(data2[i]);
			    }
			}
    			System.out.println("FAIL TO SORT!");
    			System.exit(0);
    		    }
    		}
    		System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    	    }
    	    System.out.println();
    	}
    }
}
