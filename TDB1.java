package stanford_1;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.tdb.TDBFactory;


public class TDB1 {
	public static void main(String[] args) {
        String directory = "/home/emily/workspace/Extraction_2/database"; 
        Dataset dataset = TDBFactory.createDataset(directory) ;


        dataset.begin(ReadWrite.READ) ;
        try
        {
            // Do some queries
            String sparqlQueryString1 = "SELECT (count(*) AS ?count) { ?s ?p ?o }" ;


            String sparqlQueryString2 = "SELECT * { ?s ?p ?o }" ;
            execQuery(sparqlQueryString2, dataset) ;
            execQuery(sparqlQueryString1, dataset) ;
        } finally
        {
            dataset.end() ;
        }
    }

    public static void execQuery(String sparqlQueryString, Dataset dataset)
    {
        Query query = QueryFactory.create(sparqlQueryString) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, dataset) ;
        try {
            ResultSet results = qexec.execSelect() ;

            ResultSetFormatter.out(results) ;

          } finally { qexec.close() ; }
    }}
