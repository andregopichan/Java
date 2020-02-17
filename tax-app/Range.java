// Andre Gopichan - 01954733

import java.util.Scanner;


public class Range {

	public static void compareTax() {
		// creates two instances of the tax class
		Tax oldTax = new Tax();
		Tax newTax = new Tax();
		// using one of the instances, it sets the values by passing in the rates
		double[] oldRates = {15,27.5, 30.5, 35.5, 39.1};
		oldTax.setRates(oldRates);
		// sets the brackets in the tax instance
		int[][] oldBrackets = {
								{27050, 65550, 136750, 297350},  
								{45200, 109250, 166500, 297350}, 
								{22600, 54625, 83250, 148675},  	
								{36250, 93650, 151650, 297350} 
							};
		oldTax.setBrackets(oldBrackets);
		
		// insures that it will always increase by 1000
		
		final double INCREASE = 1000;
		
		System.out.print("Enter the amount from: $");
		Scanner input = new Scanner(System.in);
		double from = input.nextDouble();
		
		System.out.print("Enter the amount to: $");
		Scanner input2 = new Scanner(System.in);
		double to = input2.nextDouble();
		
	
		//calls the display function and passes one of the tax instances (new values set above)
		System.out.println("2001 tax table for taxable income from $" + from + " to $" + to + "\n");
		display(oldTax, from, to, INCREASE);
		

		// newTax has the default values set in the tax class
		System.out.println("2009 tax table for taxable income from $" + from + " to $" + to + "\n");
		display(newTax, from, to, INCREASE);
	
	}
	
	public static void display (Tax obj, double from, double to, double increase)
	{
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Taxable       Single        Married Joint       Married        Head of");
		System.out.println("Income                      or Qualifying       Separate       a House");
		System.out.println("                            Winder(er)");
		System.out.println("--------------------------------------------------------------------------------------------------");
		

		for (double taxableIncome = from; taxableIncome <= to; taxableIncome += increase) {
			
			// sets the taxable income and displays it
			obj.setTaxableIncome(taxableIncome);
			
			System.out.printf("%-13.0f", taxableIncome);
			// sets the fill status and calls the gettax function to display the tax
			obj.setFilingStatus(Tax.SINGLE_FILER);
			System.out.printf("%8.2f", obj.getTax());
		
			
			obj.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW);
			System.out.printf("%15.2f", obj.getTax());
			
			obj.setFilingStatus(Tax.MARRIED_SEPARATELY);
			System.out.printf("%18.2f", obj.getTax());
			
			obj.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
			System.out.printf("%15.2f\n", obj.getTax());
			
		}
		
		System.out.println();
	}
}
