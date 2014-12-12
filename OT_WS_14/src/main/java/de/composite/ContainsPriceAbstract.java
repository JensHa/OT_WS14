package de.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class ContainsPriceAbstract implements ContainsPrice {

	protected ArrayList<ContainsPrice> list = new ArrayList<ContainsPrice>();
	
	public ContainsPriceAbstract(){
	}
	
	public ContainsPriceAbstract(List<? extends ContainsPrice> lineItems){
 		this.list.addAll(lineItems);
	}
	
	


	public Money getPrice(){
		Money value=new Money(0);
		for(ContainsPrice item:list){
			value=value.add(item.getPrice());
		}
		return value;
	}
}
