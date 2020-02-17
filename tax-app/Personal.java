// Andre Gopichan - 01954733

import java.util.Scanner;

public class Personal {

	public static void personalTax() {
		// an instance of the tax class
		Tax tax = new Tax();
		//calls function
		displayHeader();

		System.out.print("Enter the filing status (0-3): ");
		Scanner input = new Scanner(System.in);
		//sets the status from the tax instance 
		tax.setFilingStatus(input.nextInt());

		System.out.print("Enter the Taxable Income: $");
		Scanner input1 = new Scanner(System.in);
		//sets the taxable income from the tax instance
		tax.setTaxableIncome(input1.nextDouble());

		System.out.printf("Tax is $%.2f\n", tax.getTax());

	}

	// function for the header
	public static void displayHeader() {
		System.out.println("0 - single filer");
		System.out.println("1 - married jointly or qualifying widow(er");
		System.out.println("2 - married separately");
		System.out.println("3 - head of household");

	}
}
