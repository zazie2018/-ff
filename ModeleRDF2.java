package stanford_1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.VCARD;

public class ModeleRDF2 {
	//static String name;
 /*
	static String personURI    = "http://somewhere/";
	static String comment=null;
	static String relationCR;
	static String score;
	 public static void main (String args[]) throws IOException {
		// NounsGenerator ng = new NounsGenerator("preprocessedFile");
		// AspectsGenerator ag = new AspectsGenerator(ng.getNounsListString(), 15);

			ArrayList<String> finalAspects = new ArrayList<>();
			finalAspects.add("camera");
			finalAspects.add("colour");
			finalAspects.add("color");
			finalAspects.add("battery");
			finalAspects.add("screen");
			finalAspects.add("processor");
			finalAspects.add("price");
			finalAspects.add("apps");
			finalAspects.add("sound");
			finalAspects.add("radio");
			ag.finalizeAspects(finalAspects);
			
		 ArrayList<Aspect> ans;
			ans = ag.getAspects();
		   

		// Aspect ans=new Aspect(name);
	 Model model = ModelFactory.createDefaultModel();
	 
		Scanner fr=new Scanner(new FileReader("trial.txt"));
		//String ligne;
		String[] Line=null;
		while(fr.hasNext()){
			
			comment=fr.nextLine();
			for (Aspect aspect : prans) {
		relationCR=aspect.getAspectName();
			
			score=""+aspect.getOpinionWords().toString();}
			 Resource johnSmith 
			 = model.createResource(personURI+"/"+"sentiment")
							.addProperty( VCARD.FN, comment)
							.addProperty( VCARD.N,
								model.createResource()
								.addProperty(VCARD.LABEL,relationCR).addProperty(VCARD.NOTE,score ));
			
		Resource text=	 model.createResource(personURI+"/"+"text");
		Resource sentiment=	 model.createResource(personURI+"/"+"sentiment");
		Resource aspect=	 model.createResource(personURI+"/"+"aspect");
		Resource type=	 model.createResource(personURI+"/"+"type");
			 
			
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
 	                System.out.println(" \"" + object.toString() + "\"");
 	            }

					            
					}
 	       System.out.println(" .");
		//model.write(new FileWriter("trial.rdf"));
		  model.write(new FileWriter("trial.rdf"), "RDF/XML-ABBREV");
          //model.write(new FileWriter("trial.rdf"), "N-TRIPLE");
				 
		}

	
		//Create model
		//Insert data into the model
		//INsert into database
	*/
	 }
