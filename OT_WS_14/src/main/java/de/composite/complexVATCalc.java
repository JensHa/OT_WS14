package de.composite;

import java.util.List;

public class complexVATCalc implements valueAddedTaxCalc {

	private final double normalPercentage;
	private final double reducedPercentage;

	public complexVATCalc(double normal, double reduced) {
		this.normalPercentage = normal;
		this.reducedPercentage = reduced;
	}

	public Money vatOfInvoice(Invoice invoice) {
		Money normal = new Money(0);
		Money reduced = new Money(0);

		List<ContainsPrice> lineItems = invoice.getLineItems();

		for (ContainsPrice item : lineItems) {
			if (((LineItem)item).getArticle().getDescription().startsWith("reduce")) {
				reduced=reduced.add(((LineItem)item).getLineSum().multiply(reducedPercentage));
			} else {
				normal=normal.add(((LineItem)item).getLineSum().multiply(normalPercentage));
			}
		}

		return normal.add(reduced);
	}

}
