
package stanford_1;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;


public class Exo {
	
	public static void main(String[] args) {
		String str="Samsung";
		
		String sparqlQueryString1 = "PREFIX dbont: <http://dbpedia.org/ontology/> " +
		        "PREFIX dbp: <http://dbpedia.org/property/>" +
		        "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>" +
		        "      select distinct ?phone ?label where"+
                "{"+
              "?phone <http://dbpedia.org/property/type> <http://dbpedia.org/resource/Smartphone>"+
               "?rdfs:label"+str+""+
               "} LIMIT 100";

		Query query = QueryFactory.create(sparqlQueryString1);
		QueryEngineHTTP qexec = QueryExecutionFactory.createServiceRequest("http://dbpedia.org/sparql", query); 
		 ResultSet results = qexec.execSelect() ;
		ResultSetFormatter.out(System.out, results, query);       

	}
}
