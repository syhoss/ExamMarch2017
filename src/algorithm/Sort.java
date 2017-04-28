package algorithm;

import java.util.Arrays;

public class Sort {

    long executionTime = 0;
	/*
	 * Please implement all the sorting algorithm. Feel free to add helper methods.
	 * Store all the sorted data into one of the databases.
	 */


    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int i=0; i<list.length; i++){
            for(int j=i+1; j<list.length; j++){
                if(list[j]<list[i]){
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }

        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    /********        Insertion Sort starts here			********/

    public int[] insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        int i,j,temp;
        	for(i=1;i<list.length;i++) {
        		j = i-1;
        		while(i>0 && list[j] > list[i]){
        			temp = list[i];
        			list[i] = list[j];
        			list[j] = temp;
        		}
        	}
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    /********        Insertion Sort ends here			********/
    
    /********        Bubble Sort starts here			********/
    
    public int[] bubbleSort(int [] array){
    	final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        for(int i=1; i<list.length; i++){
        	int temp = 0;
        	if(list[i-1] > list[i]){
        		temp = list[i-1];
        		list[i-1] = list[i];
        		list[i] = temp;
        	}
        	
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    /********        Bubble Sort ends here			********/
    
    /********        Merge Sort starts here			********/
    
    public int [] mergeSort(int [] array){
    	final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        int size = array.length;
        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] leftList = new int[leftSize];
        int[] rightList = new int[rightSize];
        for (int i = 0; i < mid; i++) {
        	leftList[i] = array[i];
        }
        for (int i = mid; i < size; i++) {
        	rightList[i - mid] = array[i];
        }
        mergeSort(leftList);
        mergeSort(rightList);
        merge(leftList, rightList, list);
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    public static void merge(int [] left, int[] right, int[] aRRay) {
    	int leftSize = left.length;
    	int rightSize = right.length;
    	int leftArrayCounter = 0, rightArrayCounter = 0, arrayCounter = 0;
    	while (leftArrayCounter < leftSize && rightArrayCounter < rightSize) {
    		if (left[leftArrayCounter] <= right[rightArrayCounter]) {
    			aRRay[arrayCounter] = left[leftArrayCounter];
    			leftArrayCounter++;
    			arrayCounter++;
    		}
    		else {
    			aRRay[arrayCounter] = right[rightArrayCounter];
    			rightArrayCounter++;
    			arrayCounter++;
    		}  	
    	}
    }
    /********        Merge Sort ends here			********/
   
    /********        Quick Sort starts here			********/
    
    public static void swap(int locArray[], int x, int y) {
    	int temp = locArray[x];
    	locArray[x] = locArray[y];
    	locArray[y] = temp;
    //	return locArray[x];
    }
    
    public int quick(int[] list, int low, int high) {
    	if (list == null || list.length == 0) {
    		return list[0];
    	}
    	if (low >= high) {
    		return list[0];
    	}
        int middle = low + (high - low) / 2;
        int pivot = list[middle];
        int i = low, j = high;
        while (i <= j) {
        	while (list[i] < pivot) {
        		i++;
        	}
        	while (list[j] > pivot) {
        		j--;
        	}
        	if (i <= j) {
        		swap(list, i, j);
        		i++;
        		j--;
        	}
        }
        if(low < j) {
        	quick(list, low, j);
        }
        if(high > i) {
        	quick(list, i, high);
        }
        return list[i];
    }
    
    public int[] quickSort(int array[]){
    	final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        quick(list, 0, (list.length - 1));
        System.out.println(Arrays.toString(list));
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    /********        Quick Sort ends here			********/   
    
    /********        Heap Sort starts here			********/
    
    public static void maxheap(int mhArr[], int mhi)
    {
    	int n = mhArr.length;
    	int left = 2 * mhi;
    	int right = 2 * mhi + 1;
    	int max = mhi;
    	if (left <= n && mhArr[left] > mhArr[mhi])
    		max = left;
    	if (right <= n && mhArr[right] > mhArr[max])
    		max = right;
    	
    	if (max != mhi) {
    		swap(mhArr, mhi, max);
    		maxheap(mhArr, max);
    	}
    }
    
    public static void heapify(int hArr[]) {
    	int n;
    	n = hArr.length-1;
    	for (int i = n/2; i >=0; i--)
    		maxheap(hArr, i);
    	
    }
    
    public int [] heapSort(int [] array){
    	final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        int n = array.length - 1;
        heapify(list);
        for (int x = n; x > 0; x--) {
        	swap(array, 0, x);
        	n = n - 1;
        	maxheap(array, 0);
        	
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    /********        Heap Sort ends here			********/   
    
    /********        Bucket Sort starts here		********/
    
    public static void bSort(int[] aRR, int bucketSize) {
    	int [] bucket = new int[bucketSize + 1];
    	for (int i=0; i<bucket.length; i++) {
    		bucket[i] = 0;
    	}
    	for (int i=0; i < aRR.length; i++) {
    		bucket[aRR[i]]++;
    	}
    	int outPos = 0;
    	for (int i=0; i < bucket.length; i++) {
    		for (int j=0; j < bucket[i]; j++) {
    			aRR[outPos++] = i;
    		}
    	}
    }
    
    public int [] bucketSort(int [] array){
    	final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        int BUCKETsize = array.length;
        bSort(list, BUCKETsize);  
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    /********        Bucket Sort ends here			********/
    
    /********        Shell Sort starts here			********/
    
    public static void sSort(int[] sArray) {
    	int inner, outer;
    	int temp;
    	
    	int h = 1;
    	while (h <= sArray.length / 3) {
    		h = h * 3 + 1;
    	}
    	while (h > 0) {
    		for (outer = h; outer < sArray.length; outer++) {
    			temp = sArray[outer];
    			inner = outer;
    			
    			while (inner > h - 1 && sArray[inner - h] >= temp) {
    				sArray[inner] = sArray[inner - h];
    				inner -= h;
    			}
    			sArray[inner] = temp;
    		}
    		h = (h - 1) / 3;
    		
    			}
    }
    
    public int [] shellSort(int [] array){
    	final long startTime = System.currentTimeMillis();
        int [] list = array;
        //implement here
        sSort(list);
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    
    /********        Shell Sort ends here			********/

    public static void printSortedArray(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
