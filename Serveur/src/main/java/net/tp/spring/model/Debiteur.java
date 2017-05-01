package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dbtr")
public class Debiteur {

	@XmlElement
	String Nm;

	
	public Debiteur(String name) {
		super();
		Nm = name;
	}
        
        public Debiteur() {
		
	}
    /*  on recupere le nom de débiteur  */
	public String getName() {
		return Nm;
	}
	
}