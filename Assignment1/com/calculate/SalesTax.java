package com.calculate;

import com.parsing.Parse;

public class SalesTax extends Parse {

	/**
	 * @param args
	 */
	public double salesTax;

	public double calculateTax() {
		double itemCost = itemPrice * itemQuantity;
		if (itemType.equals("raw")) {
			salesTax = (12.5 * itemCost) / 100;
		} else if (itemType.equals("manufactured")) {
			salesTax = ((12.5 * itemCost) / 100)
					+ (2 * (itemCost + 12.5f * itemCost) / 100);
		} else {
			double importDuty = (10 * itemCost) / 100;
			double surcharge;
			if (importDuty + itemCost <= 100) {
				surcharge = 5;
			} else if (importDuty + itemCost < 200
					&& importDuty + itemCost > 100) {
				surcharge = 10;
			} else {
				surcharge = (5 * (itemCost + importDuty)) / 100;
			}
			salesTax = importDuty + surcharge;
		}
		return salesTax;
	}

	public double calculateCost() {
		double itemCost = itemPrice * itemQuantity;
		return salesTax + itemCost;
	}
}
