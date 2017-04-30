package net.tp.spring.validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ValidateXML {
	
	public ValidateXML(){
		
	}
	
	/*cette methode nous renvoie  1 si le fichier XML introduit est valide sinon 0 */
        
	public int validate_XML(String fileXSD, InputSource fileXML) throws SAXException, ParserConfigurationException, IOException{
		try{
                    //  Récupère une "factory" pour le XML Schema du W3C
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			InputStream is = this.getClass().getResourceAsStream(fileXSD);
		       
                        Schema schema = factory.newSchema((Source) new InputStreamReader(is));
			
                        //Récupère un validateur depuis le schéma
                        
                        Validator validator = (Validator) schema.newValidator();
			
                        validator.validate((Source) fileXML);
			return 1;
		}
		catch(IOException | SAXException e){
			System.out.println(e.getMessage());
			return 0;
		}
	    catch(Exception e)
	    {
	        return 1;
	    }
	}

}
