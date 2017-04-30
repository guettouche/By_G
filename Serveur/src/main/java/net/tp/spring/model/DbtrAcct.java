package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DbtrAcct")
public class DbtrAcct {

	@XmlElement
	Id Id;

        
        
	public DbtrAcct(Id identifiant) {
		super();
		Id = identifiant;
	}
        
        
	public DbtrAcct() {
		
	}

   /*  on recupere l'identifiant de compte débiteur  */
	public Id getIdentifiant() {
		return Id;
	}
}
