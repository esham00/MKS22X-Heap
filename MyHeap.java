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
	if (!(child2>size)) {
		if (data[child1] > data[index]) {
		    swap(data, index, child1);
		    pushDown(data, size, child1);
		} else {
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
	}

    }
    public static void heapsort(int[] data) {
	heapify(data);
    }
    public static void main(String[] args) {
	int[] ary = new int[]{1, 2, 3, 4, 5, 6, 9, 7, 6};
	heapify(ary);
	System.out.print(Arrays.toString(ary));
    }
}
