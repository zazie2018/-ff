package stanford_1;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;

public class EssaiRequete {
	{

		 String directory = "/home/emily/workspace/Extraction_2/mydatabase2"; 
	        Dataset dataset = TDBFactory.createDataset(directory) ;
	        Model model = dataset.getDefaultModel();

	        dataset.begin(ReadWrite.READ) ;
	        try
	        {
	            // Do some queries
	            // sparqlQueryString1 = "SELECT (count(*) AS ?count) { ?s ?p ?o }" ;


	            String us = "SELECT *  {?s ?p ?o}" ;
	            execQuery(us, dataset);
	        } finally
	        {
	            dataset.end() ;
	        }	 
	 }
		 public static void execQuery(String us, Dataset dataset)
	        {
	            Query query = QueryFactory.create(us) ;
	            QueryExecution qexec = QueryExecutionFactory.create(query, dataset) ;
	            try {
	                ResultSet results = qexec.execSelect() ;

	                ResultSetFormatter.out(results) ;
	                System.out.println(results.getRowNumber());

	              } finally { qexec.close() ; }
	}
}
