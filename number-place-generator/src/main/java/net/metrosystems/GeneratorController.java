package net.metrosystems;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

	/**
	 * Returns personal number plate with county code random numbers and three
	 * letters if random letters contain OO or II another generation of letters
	 * is made
	 * 
	 * @return "B 780 TST", "AG 80 DEC", "BZ 03 MNT" etc.
	 */
	@RequestMapping(path = "personal")
	public String personalNumberPlate() {

		String countyCode = GeneratorUtil.generateRandomCountyCode();

		String numbers = null;
		// If county is Bucharest there exists the possibility
		// to have numbers formed from 2 or 3 numbers
		if (countyCode.equals("B")) {
			double randomNumber = Math.random();
			if (randomNumber > 0.5) {
				numbers = GeneratorUtil.generateRandomNumber(3);
			} else {
				numbers = GeneratorUtil.generateRandomNumber(2);
			}
			// For other counties only 2 numbers can be available
		} else {
			numbers = GeneratorUtil.generateRandomNumber(2);
		}
		
		// Letters section cannot contain OO or II
		String letters = null;
		do {
			letters = GeneratorUtil.generateThreeRandomLetters();
		} while (letters.contains("OO") || letters.contains("II"));

		return countyCode + " " + numbers + " " + letters;
	}

	/**
	 * Returns leasing plate number formed by county code and 6 numbers
	 * 
	 * @return "B 780678", "AG 805678" etc
	 */
	@RequestMapping(path = "leasing")
	public String leasingNumberPlate() {
		return GeneratorUtil.generateRandomCountyCode() + " " + GeneratorUtil.generateRandomNumber(6);
	}

	/**
	 * Returns diplomatic plate number formed by CD or TC and 6 numbers
	 * 
	 * @return "CD 780678", "TC 805678" etc
	 */
	@RequestMapping(path = "diplomatic")
	public String diplomaticNumberPlate() {
		String prefix = null;
		double randomNumber = Math.random();
		if (randomNumber > 0.5) {
			prefix = "CD";
		} else {
			prefix = "TC";
		}

		return prefix + " " + GeneratorUtil.generateRandomNumber(6);
	}

	/**
	 * Returns diplomatic plate number formed by CD or TC and 6 numbers
	 * 
	 * @return "A 123", "A 8056787" etc
	 */
	@RequestMapping(path = "army")
	public String armyNumberPlate() {

		String numbers = null;
		double randomNumber = Math.random();
		if (randomNumber > 0.5) {
			numbers = GeneratorUtil.generateRandomNumber(3);
		} else {
			numbers = GeneratorUtil.generateRandomNumber(7);
		}

		return "A " + numbers;
	}

}
