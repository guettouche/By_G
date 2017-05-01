package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DbtrAcct")
public class CompteDebiteur {

	@XmlElement
	Id Id;

        
        
	public CompteDebiteur(Id identifiant) {
		super();
		Id = identifiant;
	}
        
        
	public CompteDebiteur() {
		
	}

   /*  on recupere l'identifiant de compte débiteur  */
	public Id getIdentifiant() {
		return Id;
	}
}
