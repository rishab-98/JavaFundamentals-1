package com.collection;
import com.calculate.*;
import java.util.*;

import com.calculate.SalesTax;
import com.nagarro.*;
public class Database extends SalesTax {

	/**
	 * @param args
	 */
	ArrayList<String> listItem = new ArrayList<String>();

	public void storeItemDetails(double cost) {
		listItem.add("Name: " + itemName + " Price: " + itemPrice
				+ " Sales Tax per item :" + (salesTax / itemQuantity)
				+ " Final Cost: " + (cost));
	}

	public void showItemDetails() {
		for (int i = 0; i < listItem.size(); i++) {
			System.out.println(listItem.get(i));
		}
	}
}
