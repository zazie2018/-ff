package stanford_1;
//package jena.examples.rdf ;

import java.io.InputStream;

import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.*;


public class ModeleRDF extends Object{
	static final String inputFileName  = "mimi.rdf";
    
    public static void main (String args[]) {
    	
    	    // some definitions
	  String personURI    = "http://somewhere/JohnSmith";
      String givenName    = "John";
      String familyName   = "Smith";
      String fullName     = givenName + " " + familyName;


    	    
    	     // public static void main (String [] args) {
    	        // create an empty model
    	        Model model = ModelFactory.createDefaultModel();

    	       // create the resource
    	        Resource johnSmith
    	        = model.createResource(personURI)
    	               .addProperty(VCARD.FN, fullName)
    	               .addProperty(VCARD.N,
    	                            model.createResource()
    	                                 .addProperty(VCARD.Given, givenName)
    	                                 .addProperty(VCARD.Family, familyName));
    	        
    	     // liste des déclarations dans le modèle
    	        StmtIterator iter = model.listStatements();

    	        // affiche l'objet, le prédicat et le sujet de chaque déclaration
    	        while (iter.hasNext()) {
    	            Statement stmt      = iter.nextStatement();  // obtenir la prochaine déclaration
    	            Resource  subject   = stmt.getSubject();     // obtenir le sujet
    	            Property  predicate = stmt.getPredicate();   // obtenir le prédicat
    	            RDFNode   object    = stmt.getObject();      // obtenir l'objet

    	            System.out.print(subject.toString());
    	            System.out.print(" " + predicate.toString() + " ");
    	            if (object instanceof Resource) {
    	               System.out.print(object.toString());
    	            } else {
    	                // l'objet est un littéral
    	                System.out.print(" \"" + object.toString() + "\"");
    	            }

    	            System.out.println(" .");
    	            model.write(System.out);
    	            model.write(System.out, "RDF/XML-ABBREV");
    	            model.write(System.out, "N-TRIPLE");
    	            
    	      }  
    	        InputStream in = FileManager.get().open( inputFileName );
    	        if (in == null) {
    	            throw new IllegalArgumentException(
    	                                         "Fichier: " + inputFileName + " non trouvé");
    	            
    	         
    	        }
    	       

    	        // lire le fichier RDF/XML
    	        model.read(in, null);

    	        // l'écrire sur la sortie standard
    	        model.write(System.out);
    
    }}
