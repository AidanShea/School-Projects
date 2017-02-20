import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class NumberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean solved = false;
		Scanner reader = new Scanner(System.in);
		String input;
		int[] guesses;
		guesses = new int[] {0,0,0};
		List<Guess> guessList = new ArrayList<Guess>();
		
		System.out.println("Welcome to the guessing number game! The goal of the game is to guess how the rule with which the numbers are being manipulated. \nFor example, if the rule was that each new number in the sequence was the previous number plus 1, \nthe rule would be \"x+1\" and a sequence that follows that rule would be \"1 2 3\" \nUnfortunately the rule will not be that easy. Best of luck!");
		
		while(solved == false){
			System.out.println("Please input three numbers seperated by spaces. If you would like to guess the rule type \"answer\"");
			input = reader.nextLine();
			
			if(input.toLowerCase().contains("answer")){
				System.out.println("Please input your answer as a formula. For example, if you wanted to say that the term is multiplied by 3 each time, write \"x*3\". \nUse math symbols such as \"^\" for exponents, \"+\" for addition, / for division and \"-\" for subtraction. \nAnything that you do not input in this format will not be counted as part of your answer");
				input = reader.nextLine();
				if(checkAnswer(input)){
					solved = true;
				} else {
					System.out.println("You did not discover the rule. Keep guessing.");
				}
			} else if(input.toLowerCase().contains("previous")){
				if(guessList.size() == 0){
					System.out.println("You have not input any previous guesses.");
				} else {
					for(Guess g: guessList){
						System.out.println(g.toText());
					}
				}
			} else {
				try{
					String[] numbers = input.split(" ");
					guesses[0] = Integer.parseInt(numbers[0]);
					guesses[1] = Integer.parseInt(numbers[1]);
					guesses[2] = Integer.parseInt(numbers[2]);
					
					if(guesses[0]*guesses[0] == guesses[1] && guesses[1]*guesses[1] == guesses[2]){
						System.out.println("These numbers follow the rule");
						guessList.add(new Guess(new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2])}, true));
					} else {
						System.out.println("These numbers do not follow the rule");
						guessList.add(new Guess(new int[]{Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2])}, false));
					}
				} catch (Exception e) {
					System.out.println("Please check your input to make sure that it was formatted correctly. Remember to seperate each number with a space and to include 3 numbers.");
				}
			}
		}
		System.out.println("Congrats you discovered the rule!");
	}
	
	public static boolean checkAnswer(String input) {
		if((input.contains("x^2")|| input.contains("x*x")) && (input.contains("+") == false && input.contains("-") == false && input.contains("/") == false && input.contains(">") == false && input.contains("<") == false)){
			return true;	
		} else {
			return false;
		}
	}
}
