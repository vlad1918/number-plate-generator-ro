package net.metrosystems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Helper class for generating random number, characters or county codes
 */
public class GeneratorUtil {

	/**
	 * Returns a random county code from Romania including B for Bucharest
	 * 
	 * @return "CL", "B", "BZ" etc.
	 */
	public static String generateRandomCountyCode() {
		// Add all counties to a list including B for Bucharest
		List<String> countiesFromRomania = Arrays.asList("B", "AB", "AR", "AG", "BC", "BH", "BN", "BT", "BV", "BR",
				"BZ", "CS", "CL", "CJ", "CT", "CV", "DB", "DJ", "GL", "GR", "GJ", "HR", "HD", "IL", "IS", "IF", "MM",
				"MH", "MS", "NT", "OT", "PH", "SM", "SJ", "SB", "SV", "TR", "TM", "TL", "VS", "VL", "VN");

		// Shuffle the list
		Collections.shuffle(countiesFromRomania);

		// Return random entry from the list
		return countiesFromRomania.get(0);
	}

	/**
	 * Generates a random number with the given length and pads it with zero
	 * 
	 * @return "01", "001", "123", "50", "1" etc.
	 */
	public static String generateRandomNumber(int length) {
		StringBuilder sb = new StringBuilder();

		// Append to the stringBuilder random numbers from 0 to 9
		// until length is reached
		for (int i = 0; i < length; i++) {
			int randomNumber = ThreadLocalRandom.current().nextInt(0, 9);
			sb.append(String.valueOf(randomNumber));
		}

		return sb.toString();
	}

	/**
	 * Generates a random sequence of three letters
	 * 
	 * @return "ABC", "XYZ", "TTT" etc.
	 */
	public static String generateThreeRandomLetters() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		//Get three random numbers
		int randomNumber1 = ThreadLocalRandom.current().nextInt(0, 24);
		int randomNumber2 = ThreadLocalRandom.current().nextInt(0, 24);
		int randomNumber3 = ThreadLocalRandom.current().nextInt(0, 24);

		//Extract from the original string with the alphabet 
		//three random letters from the random numbers
		return alphabet.substring(randomNumber1, randomNumber1 + 1)
				+ alphabet.substring(randomNumber2, randomNumber2 + 1)
				+ alphabet.substring(randomNumber3, randomNumber3 + 1);
	}

//	//For local testing
//	public static void main(String[] args) {
//		System.out.println(GeneratorUtil.generateRandomCountyCode());
//
//		System.out.println(GeneratorUtil.generateRandomNumber(6));
//		System.out.println(GeneratorUtil.generateRandomNumber(7));
//		System.out.println(GeneratorUtil.generateRandomNumber(2));
//		System.out.println(GeneratorUtil.generateRandomNumber(3));
//
//		System.out.println(GeneratorUtil.generateThreeRandomLetters());
//	}

}
