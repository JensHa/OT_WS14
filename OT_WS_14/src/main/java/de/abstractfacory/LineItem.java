package de.abstractfacory;

import de.abstractfacory.Money;

public class LineItem {
	private final String description;
	private final int quantity;
	private final Money unitPrice;
	
	public LineItem(String description, int quantity, Money unitPrice){
		this.description=description;
		this.quantity=quantity;
		this.unitPrice=unitPrice;
	}
	
	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public Money getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Calculates the value of the line.
	 * @return The value of the line
	 */
	public Money getLineSum(){
	 return unitPrice.multiply( quantity );
	}
	

	public String toString() {
		return "Description: " + description + " ; Quantity: " + quantity + " ; Unit price: " + unitPrice.getCents() + " ; Sum: " + getLineSum().getCents();
	}

}
