package stanford_1;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.update.GraphStore;
import org.apache.jena.update.GraphStoreFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;
import org.apache.jena.atlas.lib.StrUtils;
import org.apache.jena.query.Dataset ;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;

//import org.apache.jena.atlas.junit.BaseTest ;
import org.apache.jena.atlas.lib.StrUtils ;
import org.apache.jena.graph.Graph ;
import org.apache.jena.graph.NodeFactory ;
import org.apache.jena.graph.Triple ;
import org.apache.jena.query.* ;
import org.apache.jena.rdf.model.Model ;
import org.apache.jena.rdf.model.ModelFactory ;
import org.apache.jena.sparql.sse.SSE ;
import org.apache.jena.tdb.TDB ;
import org.apache.jena.tdb.TDBFactory ;
import org.apache.jena.tdb.base.file.Location ;
import org.apache.jena.update.* ;
import org.junit.Test ;

import com.hp.hpl.jena.update.*;



public class Data1 {
	String directory = "/home/emily/workspace/Extraction_2/database";
    Dataset dataset = TDBFactory.createDataset(directory);
    public static final String RDFPrefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>";
    public static final String XSDPrefix = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>";
    public static final String MYPrefix = "PREFIX myprefix: <http://www.myexample.com/mySchema#>";
	 public static void main(String... argv)
	    {
	        
	     Data1 obj = new Data1();
	        obj.createActionInstance();
	        obj.createStateInstance();

	    }

	    public static void execUpdate(String sparqlUpdateString,
	            GraphStore graphStore) {
	        UpdateRequest updateRequest = UpdateFactory.create(sparqlUpdateString);
	        UpdateProcessor proc =UpdateExecutionFactory.create(updateRequest, graphStore);
	        proc.execute();
	    }

	    private void updateTriple(String sparqlUpdateString) {

	        dataset.begin(ReadWrite.WRITE);
	        try {
	            GraphStore graphStore = GraphStoreFactory.create(dataset);
	            execUpdate(sparqlUpdateString, graphStore);
	            dataset.commit();

	        } finally {
	            dataset.end();
	        }
	    }

	    private void createActionInstance() {

	        String subject = new StringBuffer("myprefix:").append("LS_1_user")
	                .toString();
	        String predicate = "rdf:type";
	        String object = "myprefix:Action";

	        String insertString = createInsertString(subject, predicate, object);
	        String sparqlInsertString = createSparqlString(insertString);
	       // updateTriple(sparqlInsertString);
	    }

	    private void createStateInstance() {

	        String subject = new StringBuffer("myprefix:").append("LS_1_user_LicState")
	                .toString();
	        String predicate = "rdf:type";
	        String object = "myprefix:State";

	        String insertString = createInsertString(subject, predicate, object);
	        String sparqlInsertString = createSparqlString(insertString);
	        updateTriple(sparqlInsertString);
	    }

	    private String createInsertString(String subject, String predicate,
	            String object) {
	    	
	       String insertString = new StringBuffer("INSERT DATA { ")
	                .append(subject).append(" ").append(predicate).append(" ")
	                .append(object).append(" }").toString();

	        return insertString;
	    }

	    private String createSparqlString(String str) {
	        String sparqlString = StrUtils.strjoinNL(Data1.XSDPrefix,
	                Data1.RDFPrefix, Data1.MYPrefix, str);

	        System.out.println(sparqlString);
	        return sparqlString;
	    }
}