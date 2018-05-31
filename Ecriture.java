package stanford_1;
import java.io.*;
import java.net.*;

import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.ResourceFactory;

public class Ecriture {
	public static void main(String[] args) throws Exception {
		String service = "http://dbpedia.org/sparql";
		 ParameterizedSparqlString qs = new ParameterizedSparqlString( "" +
				 "PREFIX dbont: <http://dbpedia.org/ontology/> " +
			        "PREFIX dbp: <http://dbpedia.org/property/>" +
			        "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>" +
			        "      select distinct ?phone where"+
	                "{"+
	              "?phone <http://dbpedia.org/property/type> <http://dbpedia.org/resource/Smartphone>"+
	                "rdfs:label ?label"+
	               "} LIMIT 100");

	        Literal Samsung = ResourceFactory.createLangLiteral( "Samsung", "en" );
	        qs.setParam( "label", Samsung );

	        System.out.println( qs );

	        QueryExecution exec = QueryExecutionFactory.sparqlService( service, qs.asQuery() );

	        // Normally you'd just do results = exec.execSelect(), but I want to 
	        // use this ResultSet twice, so I'm making a copy of it.  
	        ResultSet results = ResultSetFactory.copyResults( exec.execSelect() );

	        while ( results.hasNext() ) {
	            // As RobV pointed out, don't use the `?` in the variable
	            // name here. Use *just* the name of the variable.
	            System.out.println( results.next().get( "resource" ));
	        }

	        // A simpler way of printing the results.
	        ResultSetFormatter.out( results );       
}
}