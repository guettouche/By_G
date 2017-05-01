package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FinInstnId")
public class FinalInstitutionIdentifier {

	@XmlElement
	String BIC;
	
	public FinalInstitutionIdentifier() {
		
	}

	public FinalInstitutionIdentifier(String bic) {
		super();
		this.BIC = bic;
	}

	public String getBIC() {
		return BIC;
	}
}
