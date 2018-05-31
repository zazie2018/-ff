package stanford_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class Connection {
	
	
	  //public static void main(String[] args)
	  
	  {
	    //new Connection();
	  }
	  
	  public Connection()
	  {
	    try
	    {
	       String myUrl = "http://dbpedia.org/data/Smartphone.rdf";
	      // if your url can contain weird characters you will want to 
	      // encode it here, something like this:
	      // myUrl = URLEncoder.encode(myUrl, "UTF-8");

	      String results = doHttpUrlConnectionAction(myUrl);
	      System.out.println(results);
	    }
	    catch (Exception e)
	    {
	      // deal with the exception in your "controller"
	    }
	  }

	  /**
	   * Returns the output from the given URL.
	   * 
	   * I tried to hide some of the ugliness of the exception-handling
	   * in this method, and just return a high level Exception from here.
	   * Modi1fy this behavior as desired.
	   * 
	   * @param desiredUrl
	   * @return
	   * @throws Exception
	   */
	  private String doHttpUrlConnectionAction(String desiredUrl)
	  throws Exception
	  {
	    URL url = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;

	    try
	    {
	      // create the HttpURLConnection
	      url = new URL(desiredUrl);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      
	      // just want to do an HTTP GET here
	      connection.setRequestMethod("GET");
	      
	      // uncomment this if you want to write output to this url
	      //connection.setDoOutput(true);
	      
	      // give it 15 seconds to respond
	      connection.setReadTimeout(15*1000);
	      connection.connect();

	      // read the output from the server
	      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      stringBuilder = new StringBuilder();

	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        stringBuilder.append(line + "\n");
	      }
	      return stringBuilder.toString();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw e;
	    }
	    finally
	    {
	      // close the reader; this can throw an exception too, so
	      // wrap it in another try/catch block.
	      if (reader != null)
	      {
	        try
	        {
	          reader.close();
	        }
	        catch (IOException ioe)
	        {
	          ioe.printStackTrace();
	        }
	      }
	    }
	  }
	  /*private Source html;
	   public Boolean getElementContents(String tag) {
	        try {
	            html.fullSequentialParse();

	            //Element body = html.getElementById("body");

	            //tagだけ抜き出す
	            List<Element> tagedList = html.getAllElements(tag);
	            List<String> targetList = new ArrayList<>();

	            for (Element element : tagedList) {
	                targetList.add(element.getTextExtractor().toString());
	            }
	            return true;
	        } catch (NullPointerException e) {
	            System.err.println("\t" + e.toString());
	            return false;
	        } */
	    
/*public void getText(String texte)
{
	try{
		 URL url = new URL("http://dbpedia.org/page/Smartphone");
		  texte = (String) url.getContent();
		 System.out.println(texte);
		 }
		 catch(MalformedURLException e){
		 System.out.println(e);
		 }
		 catch(IOException e){
		 System.out.println(e);
		 }
	}*/
	
	 
	/*public static void main(String[] argv){
	 try{
	 URL url = new URL("http://dbpedia.org/page/Smartphone");
	  
	 URLConnection con=url.openConnection();
	 System.out.println(con.getContent());
	    InputStream input = con.getInputStream();
	    while(input.available()>0)
	    System.out.print((char)input.read());
	 }
	 catch(MalformedURLException e){
	 System.out.println(e);
	 }
	 catch(IOException e){
	 System.out.println(e);
	 }
		try {
		    URL myURL = new URL("http://example.com/");
		    URLConnection myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		} 
		catch (MalformedURLException e) { 
		    // new URL() failed
		    // ...
		} 
		catch (IOException e) { 
			  // openConnection() failed
		    // ...
		}
		}*/
		
		}
	 
	
	 

