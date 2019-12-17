package com.exercice;

import com.exercice.converters.AmountToTextConverter;

public class AmountConverter {

	private static final int PROCESS_OK = 0;
	private static final int NON_VALID_PARAMS = 1;
	private static final int NUMBER_FORMAT_ERROR = 2;
	private static final int EMPTY_VALUE = 3;
	

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Usage : numberConverter <number>\n");
			System.out.println("This application convert a number to his textual representation.");
			System.exit(NON_VALID_PARAMS);
		}
		
		Double numberToConvert = 0.0;
		try {
			numberToConvert = Double.parseDouble(args[0]);
		}
		catch(NumberFormatException nfe){
			System.out.println("The specified input value unparsable");
			System.exit(NUMBER_FORMAT_ERROR);
		}
		catch (NullPointerException npe) {
			System.out.println("The specified input value seems empty");
			System.exit(EMPTY_VALUE);
		}
		
		System.out.println("Input number is : ["+args[0]+"]");
		System.out.println("Processing...");
		
		AmountToTextConverter attc;
		try {
			attc = new AmountToTextConverter(numberToConvert);

			System.out.println("==========");
			System.out.println("Result : "+ attc.getTextualResult());
			System.out.println("==========");
		} catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		
		System.exit(PROCESS_OK);
	}

}
