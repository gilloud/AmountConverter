package com.exercice.tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.exercice.converters.AmountToTextConverter;

public class NumberToTextConverterTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void parsingExceptionDecimals() throws Exception {
		exceptionRule.expect(com.exercice.converters.exceptions.TooManyDecimals.class);
		exceptionRule.expectMessage("existing decimals");
		AmountToTextConverter nttDoException = new AmountToTextConverter(5.512);
		assertEquals("five dot fifty-one", nttDoException.getTextualResult());
	}

	@Test
	public void parsingExceptionNegativeValue() throws Exception {
		exceptionRule.expect(com.exercice.converters.exceptions.NegativeValue.class);
		exceptionRule.expectMessage("negative value");
		AmountToTextConverter nttNegative = new AmountToTextConverter(-5.0);
		assertEquals("five", nttNegative.getTextualResult());
	}

	@Test
	public void parsingExceptionTooHighValue() throws Exception {
		exceptionRule.expect(com.exercice.converters.exceptions.TooHighValue.class);
		AmountToTextConverter nttTooHigh = new AmountToTextConverter(9999999.0);
		nttTooHigh.getTextualResult();
	}

	@Test
	public void testInvalidValues() throws Exception {
		AmountToTextConverter nttOne = new AmountToTextConverter(1.0);
		assertNotEquals("NON_VALID_VALUE", nttOne.getTextualResult());
		assertEquals("one", nttOne.getTextualResult());
	}

	@Test
	public void testIntegerValues() throws Exception {
		AmountToTextConverter nttNineTeen = new AmountToTextConverter(19.0);
		assertEquals("nineteen", nttNineTeen.getTextualResult());

		AmountToTextConverter nttTwenty = new AmountToTextConverter(20.0);
		assertEquals("twenty", nttTwenty.getTextualResult());

		AmountToTextConverter nttTwentyNine = new AmountToTextConverter(29.0);
		assertEquals("twenty-nine", nttTwentyNine.getTextualResult());

		AmountToTextConverter nttNinetyEight = new AmountToTextConverter(98.0);
		assertEquals("ninety-height", nttNinetyEight.getTextualResult());

		AmountToTextConverter nttHundred = new AmountToTextConverter(100.0);
		assertEquals("one hundred", nttHundred.getTextualResult());

		AmountToTextConverter nttHundredOne = new AmountToTextConverter(101.0);
		assertEquals("one hundred and one", nttHundredOne.getTextualResult());

		AmountToTextConverter nttHundredNinetyNine = new AmountToTextConverter(199.0);
		assertEquals("one hundred and ninety-nine", nttHundredNinetyNine.getTextualResult());

		AmountToTextConverter nttevil = new AmountToTextConverter(666.0);
		assertEquals("six hundred and sixty-six", nttevil.getTextualResult());

		AmountToTextConverter nttThousand = new AmountToTextConverter(1000.0);
		assertEquals("one thousand", nttThousand.getTextualResult());

		AmountToTextConverter nttTwoThousandthreeHundredFortyFive = new AmountToTextConverter(2345.0);
		assertEquals("two thousand three hundred and forty-five",
				nttTwoThousandthreeHundredFortyFive.getTextualResult());



		AmountToTextConverter nttZero = new AmountToTextConverter(0.0);
		assertEquals("zero", nttZero.getTextualResult());

	}

	/* Not in the v1. specifications.
	public void testDecimalValues() throws Exception {
		AmountToTextConverter nttFiveDotFiftya = new AmountToTextConverter(5.51);
		assertEquals("five dot fifty-one", nttFiveDotFiftya.getTextualResult());

		AmountToTextConverter nttZeroDotTen = new AmountToTextConverter(0.1);
		assertEquals("zero dot ten", nttZeroDotTen.getTextualResult());

		AmountToTextConverter nttZeroDotOne = new AmountToTextConverter(0.01);
		assertEquals("zero dot one", nttZeroDotOne.getTextualResult());

		AmountToTextConverter nttSixDotFive = new AmountToTextConverter(6.05);
		assertEquals("six dot five", nttSixDotFive.getTextualResult());

		AmountToTextConverter nttFiveDotFifty = new AmountToTextConverter(5.60);
		assertEquals("five dot sixty", nttFiveDotFifty.getTextualResult());
	}
	 */
}
