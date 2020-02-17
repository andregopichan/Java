//Andre Gopichan - 019547333

import java.util.Scanner;


public class Hangman {
	
	 static int coutner = 0;

	public static void main(String[] args) {
		
		String yn;
		Scanner input = new Scanner(System.in);
		do{
			char[] word = getWord();
			char[] hidden = new char[word.length];
			
			hideWord(hidden);
			
			int counter = 0;
			do {
				char guess = getGuess(hidden);
				
				if (!CorrectGuess(word, hidden, guess)) {
					counter++;
				}
				
			} while (!isWordFinished(hidden));
			
			print(word, counter);
			
			System.out.println("Do you want to guess another word? Enter y or n >");
			yn = input.next();
		} while (yn.charAt(0) == 'y');
		
	}
	
	
	public static char[] getWord() {
		String[] words = {"awkward", "zombie", "bagpipes", "fishhook", "oxygen", 
						"sentence", "letter", "common", "discussion", "program"};
		
		String choice = words[(int)(Math.random() * words.length)];
		
		char[] word = new char[choice.length()];
		
		for(int i = 0; i < word.length; i++){
			word[i] = choice.charAt(i);
		}
		return word;
	}
	
	public static void hideWord(char[] hidden){
		for (int i = 0; i < hidden.length; i++){
			hidden[i] = '*';
		}
	}
	
	public static char getGuess(char[] hidden) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("(Guess) Enter a letter in word ");
		System.out.print(hidden);
		System.out.print(" > ");
		String guess = input.next();
		
		return guess.charAt(0);
	}
	
	public static boolean CorrectGuess(char[] word, char[] hidden, char guess) {
		
		boolean result = false;
		int message = 3;
		
		
		for (int i = 0; i < word.length; i++) {
			
			if (word[i] == guess) {
				result = true;
			
				if(hidden[i] == guess) {
					message = 1;
				}
				else {
					hidden[i] = guess;
					message = 0;
				}
			}
			if (coutner == 1) {
				message = 2;
			}
		}
		if (message > 0)
		{
			print(message, guess);
		}
		return result;
	}
	
	public static boolean isWordFinished(char[] hidden) {
		for (char empty: hidden) {
			if (empty == '*') {
				return false;
			}
		}
		return true;
			
	}
	//overloaded function .... char[] and int 
	public static void print(char[] word, int missed) {
		System.out.print("The word is "); 
		System.out.print(word);
		System.out.println(" You missed " + missed + " time(s)");
	}
	// overloaded function ..., int and char NOT ARRAY
	public static void print(int message, char guess) {
		System.out.print("\t" + guess);
		if (message == 1) {
			System.out.print(" is already in the word\n");
			
		}
		else if (message == 3) {
			System.out.print(" is not in the word\n");
			coutner++;
		}
		else if (message == 2) {
			System.out.println(" - You’ve already tried this letter try another letter");
			coutner = 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
