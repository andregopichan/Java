// Andre Gopichan - 01954733


import java.util.Scanner;


public class Index {
	
	public static void main (String[] args){
		
		// creates the scanner object in order to save the desired input
		Scanner input = new Scanner(System.in);
		
		//Prompts the user for number of rows and columns in the array and saves it into an array of type double
		System.out.print("Enter the number of rows and columns in the array: ");
		double [][] arr1  = new double[input.nextInt()][input.nextInt()];
		
		//Prompts the user to enter the elements in the 2d array. Uses a nested for loop to save the values in the 2d array
		System.out.print("Enter the elements in the array: ");
		for(int i = 0; i < arr1.length; i++)
		{
			for (int x = 0; x < arr1[0].length; x++)
			{
				arr1[i][x] = input.nextDouble();
			}
		}
		
		// can no longer receive input from the user
		input.close();	
		
		//creates in instance of the class 'index' and calls the function defined to set the values of maxValue, row and column
		Location location = Location.largestNum(arr1);
		
		System.out.println("The largest number in the 2D array is: " + location.maxValue + " at (row " + (location.row + 1) + " , column " + (location.column + 1) + ")");
	}
	public static class Location {
		
		// values set to zero, awaiting to be set to the correct amount 
		int row = 0;
		int column = 0;
		double maxValue = 0.0;
		
		// creating the function as a public so everyone can access it. We create it as a static so that it will be compatible with our main function as well as pass a double 2d array as a parameter
		public static Location largestNum(double[][] x)
		{
			//creates an instance on the class Index, also setting the default constructor 
			Location location = new Location();
			
			//setting maxValue to the first element in the array that was passed through
			location.maxValue = x[0][0];
					
			for (int y = 0; y < x.length; y++)
			{
				for (int z = 0; z < x[0].length; z++)
				{
					
					//if the element in position [y][z] is greater than the element saved onto maxVale, it will save over the previous max values
					if (x[y][z] > location.maxValue)
					{
						location.maxValue = x[y][z];
						location.column = z;
						location.row = y;
					}
				}
			}
			// returns an instance of the class
			return location;	
		}
	}

}
