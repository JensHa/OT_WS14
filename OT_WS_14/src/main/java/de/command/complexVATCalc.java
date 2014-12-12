package de.command;

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

		List<LineItem> lineItems = invoice.getLineItems();

		for (LineItem item : lineItems) {
			if (item.getDescription().startsWith("reduce")) {
				reduced=reduced.add(item.getLineSum().multiply(reducedPercentage));
			} else {
				normal=normal.add(item.getLineSum().multiply(normalPercentage));
			}
		}

		return normal.add(reduced);
	}

}
