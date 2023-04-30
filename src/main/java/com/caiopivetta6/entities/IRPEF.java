package com.caiopivetta6.entities;

public class IRPEF implements taxBudget{

	@Override
	public Double calculateTax(Budget budget) {
		 double total = budget.getTotal()*12;
		    double taxRate;
		    
		    if (total < 15000) {
		        taxRate = 0.23;
		    } else if (total < 28000) {
		        taxRate = 0.25;
		    } else if (total < 50000) {
		        taxRate = 0.35;
		    } else {
		        taxRate = 0.43;
		    }
		    
		    double tax = (total * taxRate) / 12;
		    return (total/12) - tax ;
	}

}
