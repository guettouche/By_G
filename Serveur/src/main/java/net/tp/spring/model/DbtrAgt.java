package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DbtrAgt")
public class DbtrAgt {

	@XmlElement
	FinInstnId FinInstnId;
        public DbtrAgt(FinInstnId identifinst) {
		super();
		this.FinInstnId = identifinst;
	}
	public DbtrAgt() {
		
	}
	
	/*  on recupere l'identifiant de la banque BIC  */
	public FinInstnId getIdentifinst() {
		return FinInstnId;
	}
}
