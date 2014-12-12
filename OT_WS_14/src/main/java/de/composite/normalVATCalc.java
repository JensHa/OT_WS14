package de.composite;

public class normalVATCalc implements valueAddedTaxCalc {
	private final double percent;

	public normalVATCalc(double percent) {
		this.percent = percent;
	}

	public Money vatOfInvoice(Invoice invoice) {
		return invoice.getInvoiceSum().multiply(percent);
	}

}
