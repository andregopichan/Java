// Andre Gopichan - 01954733


import java.util.Scanner;

public class Main {

	// flag variable for while loop
	static boolean exit = false;
	
	public static void main(String[] args) {
		//function to run the menu
		runMenu();
	}

	//header function to print
	public static void header() {
		System.out.println("+------------------------------------------+");
		System.out.println("|            Welcome to JAV444             |");
		System.out.println("|             Tax Application              |");
		System.out.println("+------------------------------------------+");
	}
	//menu options
	public static void printMenu() {
		System.out.println("\nPlease make a selection!");
		System.out.println("1) Compute personal income tax");
		System.out.println("2) Print the tax tables for taxable incomes (with range)");
		System.out.println("0) Exit");
	}
	
	public static void runMenu() {
		header();
		//while loop for the menu
		while(!exit)
		{
			//call the print function for the menu
			printMenu();
			
			//calls the input function to validate an integer being passed in
			int select = getInput();
			//uses this function to make the selection
			performAction(select);
			
		}
	}
		public static int getInput() {
			//insures that the selection isn't an option the user can input
			int select = -1;
			
			Scanner input = new Scanner(System.in);
			// if the selection is in range, it will save the input
			while(select < 0 || select > 2)
			{
				try {
				System.out.print("\nEnter your selection here: ");
				select = Integer.parseInt(input.nextLine());
				System.out.println();
				}
				//if anything other than an integer in printed, than it'll ask to try again
				catch(Exception e){
					System.out.println("Invalid selection, please try again!");
					
				}
			}
			return select;
		}
		
		public static void performAction(int select) {
			//switch statement in order for the user to select the option desired
			switch(select){
			case 0:
				exit = true;
				System.out.println("Thank you for using the JAV444 Tax application!");
				break;
			case 1:
				//calls the function from the personal class
				Personal.personalTax();
				break;
			case 2:
				//calls the function from the range class
				Range.compareTax();
			default:
			}
		}
		
	}
	
