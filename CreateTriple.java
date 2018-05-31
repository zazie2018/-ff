package stanford_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CreateTriple {
	private String texte;
	private String type;
	private ArrayList<Aspect> asp;
	
	public CreateTriple() throws IOException{
		this.type=type;
		Scanner fr=new Scanner(new FileReader("trial.txt"));
		while(fr.hasNext()){
		texte=fr.nextLine();
		asp = new ArrayList<Aspect>();
		for(Aspect aspect:asp){
	     aspect.getAspect();
		 aspect.getSenti();
		
		}
	}
}
	
public String getTexte(){
	return texte;
}
public String getType(){
	return type;
	}
public String getSentiments(){
	return asp.toString();
}
}