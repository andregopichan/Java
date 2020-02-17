// Andre Gopichan - 01954733

import java.util.Random;

public class Craps {

	public static void main(String[] args) {
	
	// rolls the dice and returns the sum and saves the points
	int points = twoDiceRoll();
	
	//checks the results of the points to see if it's a win/lose/roll again
	int results = getResults(points);
	
	// if results == 0, will print lose
	if (results == 0)
	{
		printResults(results);
	}
	// if results == 1, will print win
	else if (results == 1)
	{
		printResults(results);
	}
	// otherwise, it will call the function to roll until the value of sum or 7
	else
	{
		rollingLoop(results);
	}
}
	public static int diceRoll(){
		
		//enables usability from the Random library 
		Random rand = new Random();
		
		//sets the value of roll to a maximum of 6 and a minimum of 1
		int roll = rand.nextInt((6 - 1) + 1) + 1;
		
		return roll;
		
	}
	
	public static int twoDiceRoll() {
		
		//how to return the total of the rolls and display the sum 
		int dice1 = diceRoll();
		int dice2 = diceRoll();
		int total = dice1 + dice2;
		
		System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + total);
		
		return total;
		
	}
	
	public static int getResults(int points){
		
		// if the points passed through are 2,3,12 - the return result will be 0
		if (points == 2 || points == 3 || points == 12)
		{
			points = 0;			
		}
		// the if points passed through are 7 or 11 - the return result will be 1
		else if (points == 7 || points == 11)
		{
			points = 1;
		}
		// if none of the above applies, the points will be display on the screen and returned
		else 
		{
			System.out.println("Point is set to " + points);
		}
		return points;
	}
	
	public static void printResults(int result){
		// prints you lose if the result == 0
		if (result == 0)
		{
			System.out.println("Better luck next time, you lose");
		}
		//prints you win if the result == 1
		else if (result == 1)
		{
			System.out.println("Congratulations, you win");
		}
	}
	
	public static void rollingLoop(int point) {
		// creates an empty variable for the loop of rolls to be saved and compared to
		int total;
		
		do {
			total = twoDiceRoll();
		} while (total != point && total!= 7);
		
		if (total == 7)
		{
			printResults(0);
		}
		else
		{
			printResults(1);
		}
	}

}
