package net.tp.spring.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SEPA")
public class SEPA {

	@XmlElement
	Collection<DrctDbtTxInf> DrctDbtTxInf;
	
	
        public void addTransaction(DrctDbtTxInf drctDbtTxInf){
		this.DrctDbtTxInf.add(drctDbtTxInf);
	}
	public SEPA(Collection<DrctDbtTxInf> drctDbtTxInf) {
		super();
		DrctDbtTxInf = drctDbtTxInf;
	}

	public void setTransactions(Collection<DrctDbtTxInf> transaction){
		this.DrctDbtTxInf = transaction;
	}

	public Collection<DrctDbtTxInf> getTransaction(){
		return this.DrctDbtTxInf;
	}
	
	
        public SEPA() {
		this.DrctDbtTxInf = new LinkedList<>();
	}
}

