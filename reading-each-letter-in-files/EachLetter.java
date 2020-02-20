import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EachLetter {

	public static void main(String[] args) {

		System.out.print("Enter file name: ");
		File file = new File(new Scanner(System.in).next());

		if (file.exists()) {

			String line = "";
			int[] letterUpperCount = new int[26];
			int[] letterLowerCount = new int[26];
			try {
				Scanner input = new Scanner(file);

				while (input.hasNext()) {
					line = input.nextLine();
					for (char c : line.toCharArray()) {
						if (isUpperLetter(c)) {
							letterUpperCount[c - 'A']++;
						} else if (isLowerLetter(c)) {
							letterLowerCount[c - 'a']++;
						}
					}

				}
			} catch (FileNotFoundException e) {
				System.err.println("There was an error with your file.");
			}

			printResults(letterUpperCount, letterLowerCount);

		} else {

			System.out.println(file + " doesn't exist");
		}
	}

	public static boolean isUpperLetter(char c) {

		return (c >= 'A' && c <= 'Z');
	}

	public static boolean isLowerLetter(char c) {
		return (c >= 'a' && c <= 'z');
	}

	public static void printResults(int[] Upper, int[] Lower) {

		for (int i = 0; i < Upper.length; i++) {
			System.out.println((char) (i + 'A') + " occurrence = " + Upper[i]);
		}
		for (int x = 0; x < Lower.length; x++) {
			System.out.println((char) (x + 'a') + " occurrence = " + Lower[x]);
		}
	}

}