package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DrctDbtTx")
public class DirectDebitTransaction{

	@XmlElement
	MandateRelatedInformation MndtRltdInf;
	
        
        public DirectDebitTransaction(MandateRelatedInformation informMandat) {
		super();
		this.MndtRltdInf = informMandat;
	}

	public DirectDebitTransaction(){
		
	}
	
        
        /*  on recupere les informations relative au Mandat */
	
	public MandateRelatedInformation getInformMandat() {
		return MndtRltdInf;
	}
}