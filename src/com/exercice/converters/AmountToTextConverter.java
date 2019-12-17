package com.exercice.converters;

import com.exercice.converters.exceptions.NegativeValue;
import com.exercice.converters.exceptions.TooHighValue;
import com.exercice.converters.exceptions.TooManyDecimals;

public class AmountToTextConverter {

	protected static  String[] TEXT_NUMBERS_UNDER_20 = { "", "one", "two", "three", "four", "five", "six", "seven",
			"height", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen" };
	protected static String[] TEXT_NUMBERS_TENS = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			"eigthy", "ninety" };

	Integer _numberToConvertUnity;
	Integer _numberToConvertDecimal;

	public AmountToTextConverter(Double numberToConvert) throws TooManyDecimals, NegativeValue {

		if (numberToConvert < 0) {
			throw new NegativeValue("This value is not an amount : negative value");
		}

		// String split is the most efficient to avoid Double conversion issues.
		String[] arr = numberToConvert.toString().split("\\.");
		_numberToConvertUnity = Integer.parseInt(arr[0]);
		_numberToConvertDecimal = Integer.parseInt(arr[1]);

		// Hack to avoid Double simplification ( 5.50 => 5.5), and 5.05 => 5
		// after split.
		if (arr[1].length() == 1) {
			_numberToConvertDecimal *= 10;
		}

		if (_numberToConvertDecimal >= 100) {
			throw new TooManyDecimals("This value is not an amount : too many decimals");
		}
	}

	public String getTextualResult() throws TooHighValue {
		return this.getTextualNumber(_numberToConvertUnity)
				+ (_numberToConvertDecimal > 0 ? " dot " + this.getTextualNumber(_numberToConvertDecimal) : "");
	}

	public String getTextualNumber(Integer numberToWrite) throws TooHighValue {

		String textualRepresentation = "";
		
		if(numberToWrite==0){
			return "zero";
		}

		/**
		 * Under 99
		 */
		// If we are on the 20 first values of each thousand
		// It's not only val < 20 because 110 need to use this block.
		if (numberToWrite % 100 < 20) {
			textualRepresentation += "" + TEXT_NUMBERS_UNDER_20[numberToWrite % 100];
			numberToWrite /= 100;
		} else {
			//For All others values, we will get the <10 value, substract id, and add it's decade.
			textualRepresentation += "" + TEXT_NUMBERS_UNDER_20[numberToWrite % 10];
			numberToWrite /= 10;
			// Addition of the - separator only if a number under 10 exist.
			textualRepresentation = TEXT_NUMBERS_TENS[numberToWrite % 10]
					+ (!textualRepresentation.equals("") ? "-" + textualRepresentation : "");
			numberToWrite /= 10;
		}

		if (numberToWrite == 0) {
			return textualRepresentation;
		}

		/**
		 * hundredth block : From 100 to 999
		 */
		if (numberToWrite % 10 > 0) {
			textualRepresentation = TEXT_NUMBERS_UNDER_20[numberToWrite % 10] + " hundred"
					+ (!textualRepresentation.equals("") ? " and " + textualRepresentation : "");
		}
		numberToWrite /= 10;
		
		if (numberToWrite == 0) {
			return textualRepresentation;
		}

		/**
		 * thousandth block : From 1000 to 9999
		 */
		textualRepresentation = TEXT_NUMBERS_UNDER_20[numberToWrite %10] + " thousand"
				+ (!textualRepresentation.equals("") ? " " + textualRepresentation : "");
		numberToWrite /= 10;

		//Rest checkup and exception if necessary !
		if (numberToWrite != 0) {
			throw new TooHighValue("Too high value !");
		}

		/**
		 * TODO: To be continue with millions if business require that !
		 */
		return textualRepresentation;
	}

}
