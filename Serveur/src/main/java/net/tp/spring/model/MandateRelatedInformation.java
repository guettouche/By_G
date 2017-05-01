package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MndtRltdInf")
public class MandateRelatedInformation {
	
	@XmlElement
	String MndtId;

	@XmlElement
	String DtOfSgntr;

	public MandateRelatedInformation() {
		
	}
        /*on recupere l'identifiant de mandat */
        public String getIdentMnd() {
		return MndtId;
	}
        
        /* les informations relatives au mandat*/
	public MandateRelatedInformation(String identMnd, String dateSgntr) {
		super();
		MndtId = identMnd;
		DtOfSgntr = dateSgntr;
	}
        /*in recupere la date de la signatue de la transaction */
	public String getDateSgntr() {
		return DtOfSgntr;
	}

	
	
}
