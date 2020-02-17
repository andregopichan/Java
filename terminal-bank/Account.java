
public class Account {

	private int id;
	private double balance;
	private double annualInterestRate;
	private double loan;
	private java.util.Date dateCreated;

	Account() {
		id = 0;
		balance = 0.0;
		annualInterestRate = 0.0;
		dateCreated = new java.util.Date();
		
	}

	Account(int id, double balance, double annualInterestRate, double loan) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.loan = loan;
		dateCreated = new java.util.Date();
	}
	
	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyIntrestRate() {

		return (getAnnualInterestRate() / 100) / 12;
	}

	public double getMothlyIntrest() {
		return loan * getMonthlyIntrestRate();
	}

	public void withdraw(double amount) {
		
		if (amount > balance)
		{
			System.out.printf("You only have $%.2f inside your account.\n", balance);
		}
		else {
			
			balance -= amount;
			System.out.printf("You have $%.2f remaining in your account.\n", balance);
		}
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.printf("You have $%.2f remaining in your account.\n", balance);
	}
	
	public void madeLoanPayment(double amount){
		if (amount > balance)
		{
			System.out.println("You do not have enough funds to pay your monthly loan.");
		}
		else
		{
		System.out.printf("You are going to make a payment of $%.2f\n", amount);
			withdraw(amount);
			loan -= amount;
			System.out.printf("You have $%.2f left on your loan\n", loan);
		}
	}
	
	public double loanLength(double rate) {
			double total = 0;
		if (rate == 4.95){
			total = getLoan() / 60;
		}
		else if (rate == 3.95) {
			total = getLoan() / 48;
		}
		else if (rate == 3.95) {
			total = getLoan() / 36;
		}
		else if (rate == 2.95) {
			total = getLoan() / 24;
		}
		else if (rate == 1.95){
			total = getLoan() / 12;
		}
		else if (rate == 0.99){
			total = getLoan() / 6;
		}
		else {
			total = 0;
			System.out.println("You have no loan.");
		}
		return total;
	}

}


