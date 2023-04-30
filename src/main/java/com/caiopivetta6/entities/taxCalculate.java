package com.caiopivetta6.entities;

public class taxCalculate {

	public static double taxCalculator(Budget budget, taxBudget tax) {
		return tax.calculateTax(budget);
	}
	
}
