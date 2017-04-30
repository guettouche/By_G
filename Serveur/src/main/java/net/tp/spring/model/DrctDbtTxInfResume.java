package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Transaction")
public class DrctDbtTxInfResume {

	@XmlElement
	String Num;
	
	@XmlElement
	String Identifiant;
	
	@XmlElement
	double Montant;
	
	@XmlElement
	String Date;
	
        
	public DrctDbtTxInfResume(){
		
	}

	public DrctDbtTxInfResume(String numero, String identifiant, double montant, String date) {
		super();
		
		Identifiant = identifiant;
		this.Num = numero;
                this.Date = date;
                this.Montant = montant;
	}
	
}
