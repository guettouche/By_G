package net.tp.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class Response {

	@XmlElement
	String Error;

	@XmlElement
	String success;

	@XmlElement
	String Num;
	
	public Response(String erreur, String succes, String numero) {
		super();
		Num = numero;
       		success = succes;
		Error = erreur;
	}
	
	public Response(){
		
	}
}