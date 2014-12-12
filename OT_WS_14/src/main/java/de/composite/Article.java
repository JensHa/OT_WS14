package de.composite;

public class Article implements ContainsPrice{
	private final String description;
	private final Money unitPrice;
	
	public Article(String description, Money unitPrice){
		this.description=description;
		this.unitPrice=unitPrice;
	}
	
	
	public Money getUnitPrice() {
		return this.unitPrice;
	}
	public String getDescription() {
		return this.description;
	}


	public Money getPrice() {
		return this.unitPrice;
	}


}
