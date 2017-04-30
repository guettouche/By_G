package net.tp.spring.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "DrctDbtTxInf")
@XmlAccessorType(XmlAccessType.FIELD)
public class DrctDbtTxInf {

	@XmlTransient
	int id;
	
	@XmlTransient
	String Num;
	
	@XmlElement
	String PmtId;

	@XmlElement
	double InstdAmt;
	
	@XmlElement
	DrctDbtTx DrctDbtTx;
	
	@XmlElement
	DbtrAgt DbtrAgt;
	
	@XmlElement
	Dbtr Dbtr;
	
	@XmlElement
	DbtrAcct DbtrAcct;
	
	@XmlElement
	String RmtInf;

	public DrctDbtTxInf() {
		
	}

	public DrctDbtTxInf(int identifiant, String numero,String idenPaim, double montInst,DrctDbtTx transDebit,DbtrAgt agentDebit, 
			Dbtr debiteur, DbtrAcct comptDebit,String infRemise) {
		super();
		this.id = identifiant;
		Num = verifNumero(numero);
		DbtrAgt = agentDebit;
		DrctDbtTx = transDebit;
		InstdAmt = montInst;
                DbtrAcct = comptDebit;
                PmtId = idenPaim;
                RmtInf = infRemise;
                Dbtr = debiteur;
		
	}
        /*on recupere l'identifiant de la transaction*/
	public int getIdentifiant() {
		return id;
	}
        
	public String getNumero() {
		return Num;
	}
        /*on recupere le bic de la banque de  l'agent de debiteur */
        public DbtrAgt getAgentDebit() {
		return DbtrAgt;
	}
        /* on verifie si le numero est valide*/ 
	public String verifNumero(String n) {
		while(n.length()<4){
			n = "0"+n;
		}
		n = "AM"+n;
		return n;
	}
        /*on recupere les information su la transction de debit direct*/
        public DrctDbtTx getTransDebit() {
		return DrctDbtTx;
	}
        /*on recupere le montant instruit */
        public double getMontInst() {
		return InstdAmt;
	}
        /*on recupere le compte debiteur */
        public DbtrAcct getComptDebit() {
		return DbtrAcct;
	}
        /*on recupere l'identification de paiment */
	public String getIdenPaim() {
		return PmtId;
	}
        /*on recupere les informations sur les remises*/
	public String getInfRemise() {
		return RmtInf;
	}
	
	/*on recupere le nom de debiteur*/
        public Dbtr getDebiteur() {
		return Dbtr;
	}

	
	
}
