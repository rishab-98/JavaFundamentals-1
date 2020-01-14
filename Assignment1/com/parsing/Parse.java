package com.parsing;

import com.nagarro.InputAttributes;

public class Parse extends InputAttributes {
	protected String[] tokenString;
	public String[] token;

	public boolean tokenize(String itemData) {
		boolean exception = true;
		tokenString = itemData.split("-");

		if (tokenString.length > 5) {
			System.out.println("Please enter positive values only.");
			exception = false;
			return exception;
		}

		// Assign tokens into different variables
		for (int fields = 1; fields < tokenString.length; fields++) {
			token = tokenString[fields].split(" ");

			if (token[0].equals("name")) {
				itemName = token[1];
			} else if (token[0].equals("price")) {
				try {
					itemPrice = Double.parseDouble(token[1]);
					if(itemPrice==0)
					{
						System.out.println
						("Please enter item price greater than 0.");
						exception = false;
					}
				} catch (NumberFormatException e) {
					System.out
							.println("Please enter price in integer or double format only.");
					exception = false;
				}catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Please enter Item Price");
					exception = false;
				}
			} else if (token[0].equals("quantity")) {
				try {
					itemQuantity = Integer.parseInt(token[1]);
					if(itemQuantity==0)
					{
						System.out.println
						("Please enter item quantity greater than 0.");
						exception = false;
					}
				} catch (NumberFormatException e) {
					System.out.println
						("Please enter quantity in integer format only.");
					exception = false;
				} catch (ArithmeticException e) {
					//System.out.println("Please enter value greater than 0.");
					//exception = false;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Please enter Item Quantity");
					exception = false;
				}
			} else if (token[0].equals("type")) {
				try {
					itemType = token[1];
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Please enter item type");
					exception = false;
				}

			}

		}

		return exception;
	}

}
