package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dbtr")
public class Dbtr {

	@XmlElement
	String Nm;

	
	public Dbtr(String name) {
		super();
		Nm = name;
	}
        
        public Dbtr() {
		
	}
    /*  on recupere le nom de d�biteur  */
	public String getName() {
		return Nm;
	}
	
}