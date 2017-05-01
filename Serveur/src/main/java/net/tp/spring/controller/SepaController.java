package net.tp.spring.controller;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;

import net.tp.spring.dao.ITransactionDAO;
import net.tp.spring.model.*;
import net.tp.spring.validator.ValidateXML;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SepaController {
	
	@Autowired
	protected ITransactionDAO transactionDAO;
	
	private final SEPA sepa;
	
	private final SEPAResume resumeSepa;
	
	public SepaController(){
		sepa = new SEPA();
		resumeSepa = new SEPAResume();
		
	}
           /*on recupere  les details de la transactions avec un identifiant de paiment  id= idenPaim  sous un  flux XML  */
	@RequestMapping(value="/trx/{id}", method = RequestMethod.GET)
	public @ResponseBody DrctDbtTxInf getTransactionById(@PathVariable("id") String id) {
		return transactionDAO.get(id);
	}
	

		/* affichage de nombre de transactions et ainsi que le montant total des transactions qui sont sauvegardées  */
	@RequestMapping(value="/stats", method = RequestMethod.GET)
	public @ResponseBody Statistique getSEPAStats() {
		return transactionDAO.getStats();
	}
	
	/*on recupere le nombre on recupere la liste des transactions resumées sous un flux XML*/
	@RequestMapping(value="/resume", method = RequestMethod.GET)
	public @ResponseBody SEPAResume getSEPAInXMLResume() {
		this.resumeSepa.setTransactions(transactionDAO.listResume());
		return this.resumeSepa;
	}
	
        
        	/*on recupere la liste des transactions sous un format de flux XML */
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public @ResponseBody SEPA getSEPAInXML() {
		this.sepa.setTransactions(transactionDAO.list());
		return this.sepa;
	}
        
        
	/*Reçoit en entrée une transaction sous format d'un flux XML, afin de créer un objet correspondant a cette transaction, 
	 * et nous  retourne la valeur idPmtId*/
	@RequestMapping(value="/depot", method = RequestMethod.POST)
	public @ResponseBody Response addTransaction(@RequestBody String body) throws SAXException, ParserConfigurationException, IOException {
		
		InputSource inputSource = new InputSource(new StringReader(body));
		
		ValidateXML validator = new ValidateXML();
		
		if(validator.validate_XML("/sepa.xsd", inputSource)==0){
			return new Response("Fichier XML non valide.", null, null);
		}
		
		Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder()
	            .parse(inputSource);
		
		int id = transactionDAO.getMaxId()+1;
		
		try{
			DrctDbtTxInf drctDbtTxInf = new DrctDbtTxInf(id,Integer.toString(id),
				doc.getElementsByTagName("PmtId").item(0).getTextContent(),
				Double.parseDouble(doc.getElementsByTagName("InstdAmt").item(0).getTextContent()), 
				new DirectDebitTransaction((new MandateRelatedInformation(doc.getElementsByTagName("MndtId").item(0).getTextContent(),
						doc.getElementsByTagName("DtOfSgntr").item(0).getTextContent()))),
				new DebtorAgent(new FinalInstitutionIdentifier(doc.getElementsByTagName("BIC").item(0).getTextContent())),
				new Debiteur(doc.getElementsByTagName("Nm").item(0).getTextContent()), 
				new CompteDebiteur(new Id(doc.getElementsByTagName("IBAN").item(0).getTextContent())),
				doc.getElementsByTagName("RmtInf").item(0).getTextContent());
		
				if(transactionDAO.get(drctDbtTxInf.getIdenPaim())!=null){
					return new Response("L'identifiant de votre transaction existe déjà.", null, null);
				}
				
				transactionDAO.add(drctDbtTxInf);
				
				return new Response(null, "Transaction enregistrée.", drctDbtTxInf.getNumero());
		}
		catch(NullPointerException e){
			return new Response("Fichier XML non valide !", null, null);
		}
	}
	
	
}