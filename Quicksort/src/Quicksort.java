
public class Quicksort<E extends Comparable<E>> {
	public static void sort(Comparable[] array){
		sort(array, 0, array.length-1);
	}
	
	public static void sort(Comparable[] array, int first, int last){
		if((last - first) > 64){
			quicksort(array, first, last);
		} else {
			insertionSort(array, first, last);
		}
	}
	
	public static void insertionSort(Comparable[] array, int first, int last){
		int i = first+1;
		int j;
		Comparable temp;
		
		while(i<=last){
			j = i;
			temp = array[i];
			while(j >= 0){
				if(temp.compareTo(array[j]) < 0){
					array[j+1] = array[j];
					array[j] = temp;
				}
				j--;
			}
			i++;
		}
	}
	
	public static void quicksort(Comparable[] array, int first, int last){
		Comparable firstItem = array[first];
		Comparable lastItem = array[last];
		Comparable middleItem = array[(last-first)/2];
		Comparable temp;
		
		if(firstItem.compareTo(middleItem) == 1){
			temp = middleItem;
			middleItem = firstItem;
			array[(last-first)/2] = middleItem;
			firstItem = temp;
			array[first] = firstItem;
		}
		
		if(middleItem.compareTo(lastItem) == 1){
			temp = lastItem;
			lastItem = middleItem;
			array[last] = lastItem;
			middleItem = temp;
			array[(last-first)/2] = middleItem;
			
			if(firstItem.compareTo(middleItem) == 1){
				temp = middleItem;
				middleItem = firstItem;
				array[(last-first)/2] = middleItem;
				firstItem = temp;
				array[first] = firstItem;
			}
		}
		
		partition(array, middleItem, first, last);
	}
	
	public static void partition(Comparable[] array, Comparable pivot, int first, int last){
		Comparable temp = array[first];
		array[first]= pivot;
		array[(last-first)/2] = temp;
		
		boolean resolved = false;
		int i = first+1;
		int j = last;
		
		while(i<j){
			if(array[i].compareTo(pivot) == 1 && array[j].compareTo(pivot) == -1){
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;
				j--;
			} else if(array[i].compareTo(pivot) == 1 && array[j].compareTo(pivot) == 1){
				j--;
			} else if(array[i].compareTo(pivot) == -1 && array[j].compareTo(pivot) == -1){
				i++;
			} else {
				i++;
				j--;
			}
		}
		
		temp = array[j];
		array[j] = pivot;
		array[first] = temp;

		
		sort(array, first, j);
		sort(array, j, last);
	}
	
	public static void main(String args[]){
		Comparable[] array = new Comparable[128];
		
		for(int n = 0; n < 128; n++){
			array[n] = (int) (Math.random()*200);
		}
		
		for(Comparable i: array){
			System.out.print(i + ", ");	
		}
		System.out.println("");
		
		sort(array);
	
		for(Comparable i: array){
			System.out.print(i + ", ");	
		}
	}
}
