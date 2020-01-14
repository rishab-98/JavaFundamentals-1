package com.nagarro;
import com.calculate.*;
import com.collection.Database;
import com.parsing.*;

import java.util.*;

public class Tax extends Parse {
	
	/**
	 * @param args
	 */

	public String itemData;
	public double totalCost;
	Database dataObj = new Database();
	private String newItem;
	boolean moreData;

	private void inputData() {

		while (true) {
			System.out.println("Enter data of items");
			Scanner value = new Scanner(System.in);
			itemData = value.nextLine();

			// validation data
			moreData = dataObj.tokenize(itemData);
			if (!moreData)
				continue;

			// calculating totalcost
			salesTax = dataObj.calculateTax(); // Fn of Sales class
			totalCost = dataObj.calculateCost(); // Fn of Sales class

			// storing data
			dataObj.storeItemDetails(totalCost); // Fn of Store class

			// checking condition for loop
			System.out.println("Do you want to enter "
					+ "details of any other item (yes/no):");

			// Scanner input = new Scanner(System.in);
			newItem = value.next();

			if (!newItem.equals("yes"))
				break;
		}
		// output data
		dataObj.showItemDetails(); // Fn of Store class

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tax taxObj = new Tax();
		taxObj.inputData();
	}
}
