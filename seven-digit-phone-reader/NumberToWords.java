import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class NumberToWords {

	static char[][] digits = { {}, {}, { 'A', 'B', 'C' }, { 'D', 'E', 'F' },
			{ 'G', 'H', 'I' }, { 'J', 'K', 'L' }, { 'M', 'N', 'O' },
			{ 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y', 'Z' } };

	static BufferedWriter  output;
	static PrintWriter print;
	
	public static void main(String[] args) {

		String phoneNumber = null;

		boolean flag = false;

		while (flag == false) {

			System.out.print("Please enter a seven digit number: ");

			Scanner input = new Scanner(System.in);
			phoneNumber = input.next();

			flag = vaildatePhone(phoneNumber);
		}
		openFile();
		printPhone(phoneNumber);
		closeFile();
	}

	public static void openFile() {

		try {
			 output = new BufferedWriter(
					new PrintWriter("phonenumber.txt"));
		} catch (Exception e) {
			System.err.println("There was an error in opening the file.");
		}
	}
	
	public static void closeFile() {
		try {
			if (output != null) {
				output.close();
			}
		}
		catch (Exception e) {
			System.err.println("Error in closing the file.");
		}
	}

	public static boolean vaildatePhone(String phoneNumber) {

		for (int i = 0; i < phoneNumber.length(); i++) {
			if (phoneNumber.charAt(i) == '1' || phoneNumber.charAt(i) == '0') {
				System.out.println("Invalid. There cannot be 1's or 0's.");
				return false;
			}
		}

		for (char c : phoneNumber.toCharArray()) {
			if (Character.isLetter(c)) {
				System.out.println("Invalid. Only enter digits.");
				return false;
			}
		}

		if (phoneNumber.length() != 7) {
			System.out.println("Invalid. It must be seven digits.");
			return false;
		}

		return true;
	}

	public static void printPhone(String phoneNumber) {

		try {

			char[] arr = phoneNumber.toCharArray();
			int[] nums = new int[arr.length];

			for (int i = 0; i < arr.length; i++) {
				nums[i] = Integer.parseInt(String.valueOf(arr[i]));
			}
			char[] word = new char[7];
			
			print = new PrintWriter(output);
			print.println("\n");
			
			for (int step1 = 0; step1 < digits[nums[0]].length; step1++) {
				word[0] = digits[nums[0]][step1];

				for (int step2 = 0; step2 < digits[nums[1]].length; step2++) {
					word[1] = digits[nums[1]][step2];

					for (int step3 = 0; step3 < digits[nums[2]].length; step3++) {
						word[2] = digits[nums[2]][step3];

						for (int step4 = 0; step4 < digits[nums[3]].length; step4++) {
							word[3] = digits[nums[3]][step4];

							for (int step5 = 0; step5 < digits[nums[4]].length; step5++) {
								word[4] = digits[nums[4]][step5];

								for (int step6 = 0; step6 < digits[nums[5]].length; step6++) {
									word[5] = digits[nums[5]][step6];

									for (int step7 = 0; step7 < digits[nums[6]].length; step7++) {
										word[6] = digits[nums[6]][step7];
										print.println(word);
										System.out.println(word);
									}
								}
							}
						}
					}
				}
			}

			System.out.println("File has been written");
			
		} catch (Exception e) {
			System.err.println("Thre was an error when writting to the file.");
			
		}

	}
}
