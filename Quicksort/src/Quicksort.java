
public class Quicksort<E extends Comparable<E>> {
	
	public static void quicksort(Comparable[] array){
		Comparable first = array[0];
		Comparable last = array[array.length-1];
		Comparable middle = array[array.length/2];
		Comparable temp;
		
		if(first.compareTo(middle) == 1){
			temp = middle;
			middle = first;
			array[array.length/2] = middle;
			first = temp;
			array[0] = first;
		}
		
		if(middle.compareTo(last) == 1){
			temp = last;
			last = middle;
			array[array.length-1] = last;
			middle = temp;
			array[array.length/2] = middle;
			
			if(first.compareTo(middle) == 1){
				temp = middle;
				middle = first;
				array[array.length/2] = middle;
				first = temp;
				array[0] = first;
			}
		}
		partition(array, middle);
	}
	
	public static void partition(Comparable[] array, Comparable pivot){
		Comparable temp = array[0];
		array[0]= pivot;
		array[array.length/2] = temp;
		
		boolean resolved = false;
		int i = 1;
		int j = array.length-1;
		
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
		array[0] = temp;
	}
	
	public static void main(String args[]){
		Comparable[] list = new Comparable[10];
		
		list[0] = 7;
		list[1] = 2;
		list[2] = 3;
		list[3] = 8;
		list[4] = 4;
		list[5] = 1;
		list[6] = 5;
		list[7] = 9;
		list[8] = 6;
		list[9] = 10;
		
		for(Comparable i: list){
			System.out.print(i + ", ");	
		}
		
		quicksort(list);
		System.out.println("");
		for(Comparable i: list){
			System.out.print(i + ", ");	
		}
	}
}
