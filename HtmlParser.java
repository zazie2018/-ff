/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stanford_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

/**
 *
 * @author taro
 */
public class HtmlParser {
    private Source html;
    
    public HtmlParser(URL url) {
        try {
            html = new Source(url);
        } catch (FileNotFoundException e) {
            System.err.println("\tNotFound");
        } catch (Exception e) {
            

        }
        
    }
    
    public Boolean getElementContents(String word) {
        try {
            html.fullSequentialParse();

            //Element body = html.getElementById("body");

            //tagだけ抜き出す
            List<Element> tagedList = html.getAllElements(word);
            List<String> targetList = new ArrayList<>();

            for (Element element : tagedList) {
                targetList.add(element.getTextExtractor().toString());
            }
            return true;
        } catch (NullPointerException e) {
            System.err.println("\t" + e.toString());
            return false;
        } 
    }
  /*  public void getText(String texte)
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
    
    public static void main(String[] args) throws InterruptedException {
        try {
            //HtmlParser parser = new HtmlParser(new URL("http://dbpedia.org/resource/Ans"));
            DBpediaConnector connector = new DBpediaConnector(new URL("http://dbpedia.org/data/Smartphone.rdf"));
            
            HtmlParser parser = new HtmlParser(new URL(connector.getCurrentUrl()));
            
            
            if(parser.getElementContents("samsung").equals(connector))
            	System.out.println("ok");
            else
            	System.out.println("nok");
        } catch (MalformedURLException ex) {
            Logger.getLogger(HtmlParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HtmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
