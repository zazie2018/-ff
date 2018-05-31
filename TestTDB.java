package stanford_1;
import java.util.Iterator;

import org.apache.jena.query.Dataset ;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;

import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;

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

import edu.stanford.nlp.pipeline.UDFeatureAnnotator;
public class TestTDB {
	public static void main(String[] argv)
    {

        String directory = "/home/emily/workspace/Extraction_2/mydatabase2";
        Dataset dataset = TDBFactory.createDataset(directory);
       Model model = dataset.getNamedModel("emilie.rdf");
          

dataset.begin(ReadWrite.WRITE);
        try{
        	GraphStore graphStore = GraphStoreFactory.create(dataset) ;
      String us=StrUtils.strjoinNL("PREFIX : <http://example/>",
    		                   "PREFIX foaf:  <http://xmlns.com/foaf/0.1/>" ,
                               "INSERT DATA FROM { <http://dbpedia.org/resource/Smartphone>") ;
      System.out.println(us);
 // execQuery(usquery, dataset) ;
   UpdateRequest req = UpdateFactory.create(us) ;
   UpdateProcessor pro=UpdateExecutionFactory.create(req, graphStore);
   pro.execute();
   System.out.println("ligne ajoutée");
 // UpdateAction.execute(req, dataset) ;
   dataset.commit();
        }
        finally{
        dataset.close();}
    
        
        Dataset dataset2 = TDBFactory.createDataset(directory);
   dataset2.begin(ReadWrite.READ) ;
  String us2= "SELECT * FROM NAMED <http://somewhere//sentiment>{ GRAPH ?g { ?s ?p ?o } }";
                
 
       //String us2 = "SELECT *  {?s ?p ?o}" ;
       execQuery(us2, dataset2);
    }      

public static void execQuery(String us2, Dataset dataset)
   {
       Query query = QueryFactory.create(us2) ;
       QueryExecution qexec = QueryExecutionFactory.create(query, dataset) ;
       try {
           ResultSet results = qexec.execSelect() ;

           ResultSetFormatter.out(results) ;
           System.out.println(results.getRowNumber());

         } finally { qexec.close() ; }
}
}
        
        
        
  
 //  }   
        /*public static void execQuery(String us, Dataset dataset)
        {
            Query query = QueryFactory.create(us) ;
            QueryExecution qexec = QueryExecutionFactory.create(query, dataset) ;
            try {
                ResultSet results = qexec.execSelect() ;

                ResultSetFormatter.out(results) ;

              } finally { qexec.close() ; }
        }}
       /* Iterator<String> graphNames = dataset.listNames();
        while (graphNames.hasNext()) {
            String graphName = graphNames.next();
            System.out.println(graphName);*/
    
	

