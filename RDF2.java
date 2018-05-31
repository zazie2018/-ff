package stanford_1;

import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
public class RDF2 {
	Aspect asp;
	static String texteURI="http://texte/";
	static String relationURI="http://relation";
	
public void main(String [] args) throws IOException{
	
	CreateTriple cr=new CreateTriple();
	// Create an empty Model
	Model model = ModelFactory.createDefaultModel();
	 
	// Create a Resource
	Resource texte = model.createResource(texteURI+"/"+cr.getTexte());
	Resource aspect= model.createResource(texteURI+"/"+cr.getSentiments());
	Resource sentiment = model.createResource(texteURI+"/"+"sentiment");
	Resource type = model.createResource(texteURI+"/"+cr.getType());
	
	// Can also create properties directly . . .
	Property has= model.createProperty(relationURI , "has");
		
	//statement
	Statement stmt1 = model.createStatement(texte, has, type);
	Statement stmt2 = model.createStatement(texte, has, aspect);
	Statement stmt3 = model.createStatement(aspect, has, sentiment);
	
	//add statement
	model.add(stmt1);
	model.add(stmt2);
	model.add(stmt3);
}
}
