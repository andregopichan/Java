import java.util.Random;

public class cardPicker {

	public static void main(String[] args) {
		
		int[] myDeck = new int[52];
		
		for(int a = 0; a < myDeck.length; a++) {
		myDeck[a] = a;
		//System.out.println(a);
		}
		
		String[] suits = {"Clubs", "Hearts", "Spades", "Dimonads"};
		String[] rank = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		Random rand = new Random();
		
		for (int a = 0; a < 8; a++)
		{
		int randNum = rand.nextInt((12 - 0) + 1) + 0;
		int randNum2 = rand.nextInt((3 - 0) + 1) + 0;
		
		String randSuit = suits[randNum2];
		String randRank = rank[randNum];
		
		System.out.println("The card you have drawn is: " + randRank + " of " + randSuit);
		}
			
	}
}
