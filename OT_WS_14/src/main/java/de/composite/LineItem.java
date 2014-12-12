package de.composite;

public class LineItem implements ContainsPrice{
	private final int quantity;
	private final Article article;
	
	public LineItem(Article article, int quantity){
		this.quantity=quantity;
		this.article=article;
	}
	

	public int getQuantity() {
		return quantity;
	}
	
	public Article getArticle(){
		return this.article;
	}


	/**
	 * Calculates the value of the line.
	 * @return The value of the line
	 */
	public Money getLineSum(){
//	 return article.getUnitPrice().multiply( quantity );
		return getPrice();
	}
	

	public String toString() {
		return "Description: " + article.getDescription() + " ; Quantity: " + quantity + " ; Unit price: " + article.getUnitPrice().getCents() + " ; Sum: " + getLineSum().getCents();
	}


	public Money getPrice() {
		return this.article.getPrice().multiply(quantity);
	}

}
