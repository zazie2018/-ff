package stanford_1;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
//import org.apache.jena.rdf.model.*;
//import org.apache.jena.vocabulary.*;
//import com.hp.hpl.jena.util.*;

public class Rdf1 {
	public static void main(String[]args)

{    
	  String str="Samsung";
      String queryString = "PREFIX dbont: <http://dbpedia.org/ontology/> " +
	        "PREFIX dbp: <http://dbpedia.org/property/>" +
	        "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>" +
	        "prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n" +
	        "PREFIX bif:<>"+
	        "SELECT ?uri ?label"+
	        		"WHERE {"+
	        		"?uri rdfs:label ?label ."+
	        		"filter(?label="+str+"@en)"+
	        		"}";
 
   Query query = QueryFactory.create(queryString);        
   QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
 
  ResultSet results = qexec.execSelect();
    while(results.hasNext())
    {
   /*QuerySolution soln = results.nextSolution();
   System.out.println(soln);
    }*/
    try {

        ResultSetFormatter.out(results) ;
        System.out.println(results.getRowNumber());

      } finally { qexec.close() ; }
 
      
      
    }}}


