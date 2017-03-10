import java.util.Scanner;

public class TowersOfHanoi {

	
	public static boolean solve(int discs, int num, Stack source, Stack auxiliary, Stack target){
		if(num == 1){
			System.out.println("Move disc with value " + source.peek() + " from " + source.name + "->" + target.name);
			target.push(source.pop());
			
		} else {
			solve(discs, num -1, source, target, auxiliary);
			System.out.println("Move disc with value " + source.peek() + " from " + source.name + "->" + target.name);
			target.push(source.pop());
			solve(discs, num-1, auxiliary, source, target);
		}
		return true;
	}
	
	
	public static void main(String args[]){
		Stack A = new Stack("A");
		Stack B = new Stack("B");
		Stack C = new Stack("C");
		
		System.out.print("Enter number of discs: ");
	    Scanner scanner = new Scanner(System.in);
	    int discs = scanner.nextInt();
	    
	    for(int i = discs; i> 0; i--){
	    	A.push(i);
	    }
	    
	    solve(discs, discs, A, B, C);
	    
	    System.out.println("Complete.");
	}
}
