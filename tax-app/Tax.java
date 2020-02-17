// Andre Gopichan - 01954733


public class Tax {
// variables to use
	int filingStatus;
	final public static int SINGLE_FILER = 0;
	final public static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	final public static int MARRIED_SEPARATELY = 2;
	final public static int HEAD_OF_HOUSEHOLD = 3;
	int[][] brackets;
	double[] rates;
	double taxableIncome;

	Tax() {
		// in the constructor, we set the default values
		filingStatus = 0;
		
		double[] rates2009 = {10, 15, 25, 28, 33, 35};
		setRates(rates2009);
		
		int[][] brackets2009 =  {
									{8350, 33950, 82250, 171550, 372950},
									{16700, 67900, 137050, 20885, 372950},
									{8350, 33950, 68525, 104425, 186475},
									{11950, 45500, 117450, 190200, 372950}
								};
		
		setBrackets(brackets2009);
		
		taxableIncome = 0;
	}
	// we call this to set everything
	Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome)
	{
		setFilingStatus(filingStatus);
		setBrackets(brackets);
		setRates(rates);
		setTaxableIncome(taxableIncome);
	}
	
	public int getFilingStatus() {
		return filingStatus;
	}
		
	public void setFilingStatus(int s) {
		this.filingStatus = s;
	}

	public int[][] getBrackets() {
		return brackets;
	}
//looping through the array to set all the elements 
	public void setBrackets(int[][] b) {
		this.brackets = new int[b.length][b[0].length];
		for (int i = 0; i < b.length; i++)
		{
			for (int x = 0; x < b[i].length; x++)
			{
				this.brackets[i][x] = b[i][x];
			}
		}
	}

	public double[] getRates() {
		return rates;
	}
//looping in the array to set all the elements
	public void setRates(double[] r) {
		this.rates = new double[r.length];
		for (int i = 0; i < r.length; i++)
		{
			this.rates[i] = r[i] / 100;
		}
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}
	
	public void setTaxableIncome(double ti) {
		this.taxableIncome = ti;
	}
	// Calculates the tax based on all the set values
	public double getTax() {
		double tax = 0;
		double taxedIncome = 0;
		
		double income = taxableIncome;
	
			if (rates.length >= 2) 
			{
			for (int i = rates.length - 2; i >= 0; i--) 
			{
				if (income > brackets[filingStatus][i]) 
				{
 					tax += (taxedIncome = income - brackets[filingStatus][i]) * rates[i + 1];
					income -= taxedIncome;
 				}
			} 
		}
		return tax += brackets[filingStatus][0] * rates[0];

	}
}
