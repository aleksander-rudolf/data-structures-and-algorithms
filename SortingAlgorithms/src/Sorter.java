/*
 * Implementation of selectionSort(), insertionSort(), mergeSort(), and quickSort()
 * has been taken from W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook.
 */

public class Sorter {
	
	public void swap(int[] array, int i, int j) {
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void selectionSort(int[] array) {
		
		for(int i = 0; i < array.length-1; i++) {
			//Find the least element in right sub-array
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			//Swap items
			swap(array, min, i);
		}
	}
	
	public void insertionSort(int[] array) {
		
		//Iterate over the array from array[1] to array[n]
		for(int i = 1, j; i < array.length; i++) {
			int temp = array[i];
			
			//Compare the current element to the previous element
			//and shift all elements greater than the current element
			//to the right by one to make room for insertion of the current element
			for(j = i; j > 0 && temp < array[j-1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = temp;
		}
	}
	
	public void mergeSort(int[] array, int[] tmpArray, int first, int last) {
		
		//An array of size 1 is already sorted
		if(first < last) {
			
			//Find the mid point of the array
			int mid = (first + last) / 2;
			
			//Split the array into a left half from array[first] to array[mid]
			mergeSort(array, tmpArray, first, mid);
			
			//Split the array into a right half from array[mid+1] to array[end]
			mergeSort(array, tmpArray, mid+1, last);
			
			//Merge left and right arrays into sorted order
			merge(array, tmpArray, first, mid+1, last);
		}
	}
	
	public void merge(int[] array, int[] tmpArray, int leftFirst, int rightFirst , int rightEnd) {
		
		int leftEnd = rightFirst-1;
		int tmpPos = leftFirst;
		int numElements = rightEnd - leftFirst + 1;
		
		while( leftFirst <= leftEnd && rightFirst <= rightEnd ) {
			if( Integer.compare(array[leftFirst],(array[rightFirst])) <= 0 ) {
				tmpArray[ tmpPos++ ] = array[ leftFirst++ ];
			}

			else {
				tmpArray[ tmpPos++ ] = array[ rightFirst++ ];
			}
		}
		
		//Copy rest of first half
		while( leftFirst <= leftEnd ) {
			tmpArray[ tmpPos++ ] = array[ leftFirst++ ];
		} 

		//Copy rest of right half
		while( rightFirst <= rightEnd ) {
			tmpArray[ tmpPos++ ] = array[ rightFirst++ ];
		}

		//Copy tmpArray back
		for( int i = 0; i < numElements; i++, rightEnd-- ) {
			array[ rightEnd ] = tmpArray[ rightEnd ];
		}
	}
	
	public void quickSort(int[] array) {
		
		//An array of size 1 is already sorted                                                                             
		if (array.length < 2)
			return;
		
		//Find the largest element and put it at the end of the array                                                      
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[max]) {
				max = i;
			}
		}
		swap(array, array.length-1, max);
		
		//Call the main quicksort method                                                                                   
		quicksort(array, 0, array.length-1);
	}

	public void quicksort(int[] array, int first, int last) {
		
		int lower = first + 1, upper = last;
		
		//Use the middle array element as the bound (pivot) and                                                            
		//move it out of the way into the first array element                                                              
		swap(array, first, (first + last)/2);
		int bound = array[first];
		
		//Partition the array                                                                                              
		while (lower <= upper) {
			while (array[lower] < bound) {
				lower++;
			}
			while (array[upper] > bound) {
				upper--;
			}
			if (lower < upper) {
				swap(array, lower++, upper--);
			}
			else {
				lower++;
			}
		}
		
		//Move the pivot into its proper position in the array                                                             
		swap(array, upper, first);
		
		//Recursively sort the lower and upper subarrays                                                                   
		if (first < upper-1) {
			quicksort(array, first, upper-1);
		}

		if ((upper+1) < last) {
			quicksort(array, upper+1, last);
		}
	}
}