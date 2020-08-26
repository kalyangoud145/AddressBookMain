package addressBook;

import java.util.Random;
import java.util.Scanner;

public class InputScanner {
	Scanner scanner;
	Random random;

	public InputScanner() {
		scanner = new Scanner(System.in);
		random = new Random();
	}

	/*Generation of Random Numbers with bound 
	 * and returns generated Random Number*/
	public int inputRandom(int bound) {
		try {
			return random.nextInt(bound);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	/* Generation ofRandom Numbers without using bound
	 *and returns the generated Random Number*/
	public int inputRandom() {
		try {
			return random.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	/*Takes input with the user via Scanner for String
	 *and returns the INPUT STRING*/
	public String inputString() {
		try {
			return scanner.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
	/* Takes input with the user via Scanner for StringLine
	 * and return the INPUT STRING LINE*/
	public String inputStringLine() {
		try {
			return scanner.nextLine();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}

	/* Takes input with the user via Scanner for Integer
	 * and return back the INPUT INTEGER*/
	public int inputInteger() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/*Takes input with the user via Scanner for Double
	 * and return the INPUT DOUBLE*/
	public double inputDouble() {
		try {
			return scanner.nextDouble();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	/* Takes input with the user via Scanner for Boolean
	 * and return the INPUT BOOLEAN*/
	public boolean inputBoolean() {
		try {
			return scanner.nextBoolean();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	

	
}
