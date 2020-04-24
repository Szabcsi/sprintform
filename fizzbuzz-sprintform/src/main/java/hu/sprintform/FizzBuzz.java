package hu.sprintform;

/**
 * The application prints numbers from 1 to 100 and numbers divisible by 3 print Fizz, 
 * numbers divisible by 5 print Buzz, number otherwise.
 * 
 *  @author Szabolcs Bekõ
 *  email:beko.szabolcs@gmail.com
 *  Date:04-24-2020
 */
import java.util.Arrays;
import java.util.stream.Collectors;

public class FizzBuzz implements IFizzBuzz {

	
	public String execute(int[] numbers) {
		return Arrays.stream(numbers).mapToObj(this::processNumber).collect(Collectors.joining(", "));
	}
	/**
	 * Procedure checking number parameter is 
	 * divisible by 3.
	 * Return boolean.
	 * Parameter number.
	 */
	@Override
	public boolean isMultipleOfThree(int number) {
		return number % 3 == 0;
	}
	
	/**
	 * Procedure checking number parameter is 
	 * divisible by 5.
	 * Return boolean.
	 * Parameter number.
	 */
	@Override
	public boolean isMultipleOfFive(int number) {
		return number % 5 == 0;
	}

	/**
	 * Main process of the application. 
	 * Return String format of the number.
	 * Parameter number.
	 */
	@Override
	public String processNumber(int number) {
		if (isMultipleOfThree(number) && isMultipleOfFive(number)) {
			return Constants.FIZZBUZZ;
		} else if (isMultipleOfThree(number)) {
			return Constants.FIZZ;
		} else if (isMultipleOfFive(number)) {
			return Constants.BUZZ;
		} else {
			return String.valueOf(number);
		}
	}

	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz();
		for (int i = 1; i < 101; i++) {
			if (i < 100) {
				System.out.print(fizzBuzz.processNumber(i) + " ");
			} else {
				System.out.print(fizzBuzz.processNumber(i));
			}
		}
	}
}
