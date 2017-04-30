package net.tp.spring.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SEPA")
public class SEPAResume {

	@XmlElement
	Collection<DrctDbtTxInfResume> Transaction;
	
        public void addtTransaction(DrctDbtTxInfResume drctDbtTxInfResume){
		this.Transaction.add(drctDbtTxInfResume);
	}
          public void setTransactions(Collection<DrctDbtTxInfResume> transaction){
		this.Transaction = transaction;
	}
	public SEPAResume() {
		this.Transaction = new LinkedList<>();
	}

	public SEPAResume(Collection<DrctDbtTxInfResume> drctDbtTxInfResume) {
		super();
		Transaction = drctDbtTxInfResume;
	}
      
        

	public Collection<DrctDbtTxInfResume> getTransaction(){
		return this.Transaction;
	}
	
	
}

