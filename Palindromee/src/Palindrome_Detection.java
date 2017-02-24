import java.util.Scanner;

public class Palindrome_Detection {
	public static void main(String args[]){
		boolean asking = true;
		Scanner scanner = new Scanner(System.in);
		String palindrome;
		
		while(asking){
				System.out.println("Please enter a word");
				palindrome = scanner.nextLine();
		
				if(palindrome.contains("quit")){
					asking = false;
				} else if(checkPalindrome(palindrome)){
					System.out.println("This is a palindrome!");
				} else {
					System.out.println("This is not a palindrome.");
				}
		}
		
		System.out.println("Thanks for playing");
	}
	
	public static boolean checkPalindrome(String palindrome) {
		palindrome.toLowerCase();
		Stack s = new Stack();
		Queue q = new Queue();
		String emordnilap = "";
		int i = 0;
		
		while(i < palindrome.length()){
			s.push(palindrome.substring(i, i+1));
			i++;
		}
		
		while(s.size()!= 0){
			q.enqueue(s.pop());
		}
		
		while(q.size()!=0){
			emordnilap = emordnilap + q.dequeue();
		}
		
		System.out.println(emordnilap);
		System.out.println(palindrome);
		if(emordnilap.equals(palindrome)){
			return true;
		}
		return false;
	}
}
