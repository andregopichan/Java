import java.util.Scanner;

public class Main extends Account{

	static int id = 0;
	static double balance = 0.0;
	static double rate = 0.0;
	static boolean exit = false;
	static double loan = 0.0;
	static int counter = 0;
	static int tmp = 0;
	 Account[] accounts = new Account[2];

	public  void main(String[] args) {

		System.out.println("Please fill in the infomation for the Accounts.");


		for (int x = 0; x < accounts.length; x++) {
			accounts[x].enterNewAccount();
			accounts[x].enterNewBalance();
			accounts[x].enterNewLoanAmount();
			accounts[x].enterNewRate();

			Account a = new Account(id, balance, rate, loan);

			accounts[x] = a;

		}
		boolean flag = false;
		
		while (!flag) {
		
		exit = false;
		
		System.out.println("\nWould you like to enter an account number?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		System.out.print("\nEnter selection here: ");
		
		Scanner value = new Scanner(System.in);
		
		
		int answer = value.nextInt();
		
		if (answer == 1) {
			
		System.out.print("Enter account number: ");
		Scanner input = new Scanner(System.in);
		
		int tmpid = input.nextInt();
		
	
		for (int i = 0; i < accounts.length; i++) {
				
			if (tmpid == accounts[i].getId()) {
				
				
				System.out.println("\n\nAccount ID: " + accounts[i].getId());
				System.out.println("Account created on: " + accounts[i].getDateCreated());
				System.out.printf("Total balance: $%.2f\n", accounts[i].getBalance());
				System.out.printf("You have a loan of $%.2f\n", accounts[i].getLoan());
				System.out.println("You made " + counter + " payments on your loan");
				System.out.printf("You have %.2f payments left on your loan\n", accounts[i].loanLength(rate));
				
				performAction(accounts[i]);
				
			}
		}
		}
		else if (answer == 2){
			System.out.println("\nGoodbye.");
			flag = true;
		}
		else {
			System.out.println("Invalid, try again.");
		}
	}
}		
		
	public static void performAction(Account accounts) {
		
		while(!exit) {
			
			printMenu();

			int select = -1;

			Scanner input1 = new Scanner(System.in);

			while (select < 0 || select > 5) {
				try {
					System.out.print("Enter your selection here: ");
					select = Integer.parseInt(input1.nextLine());
					System.out.println();
				} catch (Exception e) {
					System.out.println("Invalid selection, please try again!");

				}
			
				switch(select){
				case 0:
					exit = true;
					System.out.println("You logged out.\n");
					break;
				case 1:
					Scanner withdraw = new Scanner(System.in);
					System.out.print("Enter the amount you wish to withdraw: $");
					double amount = withdraw.nextDouble();
					accounts.withdraw(amount);
					break;
				case 2:
					Scanner d = new Scanner(System.in);
					System.out.print("Enter the amount you wish to depoist: $");
					double money = d.nextDouble();
					accounts.deposit(money);
					break;
				case 3:
					System.out.printf("Your account balance is: $%.2f/n", accounts.getBalance());
					System.out.printf("This month's intrest is: $%.2f\n", accounts.getMothlyIntrest());
					System.out.println("Your account was created on: " + accounts.getDateCreated());
					break;
				case 4:
					System.out.printf("Your current loan is $%.2f\n", accounts.getLoan());
					System.out.printf("You require %.2f months to pay off your loans.\n", accounts.loanLength(accounts.getAnnualInterestRate()));
					System.out.println("You made " + counter + " payments on your loan");
					System.out.println("Your payments are due the 21st of every month");
					break;
				case 5:
					double payment;
					payment = accounts.getMothlyIntrest();
					accounts.madeLoanPayment(payment);
					System.out.println("A payment for your loan has been made.");
					counter++;					
					
				}
			}

		} 
	}
		
	public static void printMenu() {

		System.out.println("\nPlease make a selection!");
		System.out.println("1) Withdraw from your account");
		System.out.println("2) Depoist from your account");
		System.out.println("3) Account balance details");
		System.out.println("4) Account loan details");
		System.out.println("5) Make a loan payment");
		System.out.println("0) Exit");

	}

	public static void printHeader() {
		System.out
				.println("+------------------------------------------------------+");
		System.out
				.println("|          Welcome to The Generic Bank                 |");
		System.out
				.println("|                  For Jav444                          |");
		System.out
				.println("+------------------------------------------------------+");

	}




}