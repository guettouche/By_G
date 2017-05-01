package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DbtrAgt")
public class DebtorAgent  {

	@XmlElement
	FinalInstitutionIdentifier FinInstnId;
        public DebtorAgent(FinalInstitutionIdentifier identifinst) {
		super();
		this.FinInstnId = identifinst;
	}
	public DebtorAgent() {
		
	}
	
	/*  on recupere l'identifiant de la banque BIC  */
	public FinalInstitutionIdentifier getIdentifinst() {
		return FinInstnId;
	}
}
