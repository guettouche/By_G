package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DrctDbtTx")
public class DrctDbtTx{

	@XmlElement
	MndtRltdInf MndtRltdInf;
	
        
        public DrctDbtTx(MndtRltdInf informMandat) {
		super();
		this.MndtRltdInf = informMandat;
	}

	public DrctDbtTx(){
		
	}
	
        
        /*  on recupere les informations relative au Mandat */
	
	public MndtRltdInf getInformMandat() {
		return MndtRltdInf;
	}
}