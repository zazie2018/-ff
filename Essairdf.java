package stanford_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.vocabulary.VCARD;

public class Essairdf {
	static String personURI    = "http://somewhere/";
	static String comment="hey";
	static String relationCR="stonzy";
	static String rank="1";
	 public static void main (String args[]) throws IOException {
	
	 
	 Model model = ModelFactory.createDefaultModel();
	 
		Scanner fr=new Scanner(new FileReader("emilie.txt"));
		String ligne;
		String[] Line=null;
		while(fr.hasNext()){
			relationCR=calculRelation();
			comment=fr.nextLine();
			rank=(""+Integer.parseInt(calculScore())*comment.length());
			 Resource johnSmith 
			 = model.createResource(personURI+"/"+relationCR)
							.addProperty((Property) VCARD.FN, relationCR)
							.addProperty((Property) VCARD.NOTE, comment)
							.addProperty((Property) VCARD.LABEL, rank);
			 
					
					}
		model.write(new FileWriter("emilie.rdf"));
				 
		}

	private static String calculScore() {
		// TODO Auto-generated method stub
		return rank;
	}

	private static String calculRelation() {
		// TODO Auto-generated method stub
		return relationCR;
	}
		
	
	}