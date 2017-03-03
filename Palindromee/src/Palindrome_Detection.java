import java.util.Scanner;

public class Palindrome_Detection {
	public static void main(String args[]){
		boolean asking = true;
		Scanner scanner = new Scanner(System.in);
		String palindrome;
		Stack palinStack = new Stack();
		
		while(asking){
				System.out.println("Please enter a word");
				palindrome = scanner.nextLine();
				
				if(palindrome.contains("quit")){
					asking = false;
				} else if(checkPalindrome(palindrome)){
					System.out.println("This is a palindrome!");
					palinStack.push(palindrome);
				} else {
					System.out.println("This is not a palindrome.");
				}
		}
		
		System.out.println("Thanks for playing, here are your successful palindromes!");
		while(palinStack.size()>0){
			System.out.println(palinStack.pop());
		}
	}
	
	public static boolean checkPalindrome(String palindrome) {
		palindrome = palindrome.toLowerCase();
		Stack s = new Stack();
		Queue q = new Queue();
		String emordnilap = "";
		int i = 0;
		
		while(i < palindrome.length()){
			if(Character.isLetter(palindrome.charAt(i))){
				s.push(palindrome.substring(i, i+1));
			}
			i++;
		}
		
		String letter;
		palindrome = "";
		while(s.size()!= 0){
			letter = (String) s.pop();
			palindrome = letter + palindrome;
			q.enqueue(letter);
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
