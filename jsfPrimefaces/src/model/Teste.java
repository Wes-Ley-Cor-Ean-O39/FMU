package model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		 Document doc;
	        try {
	            // need http protocol
	            doc = Jsoup.connect("https://solutioin.com/toth/services/cepservice/consultarcep/06401160").get();
	            Elements links = doc.getAllElements();
	            for (int i = 0; i < links.size(); i++) {
	            	if(i >=5)
	            	System.out.println("Logradouro:"+ i + links.get(i).text() );
				} 
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
				
		
	}

}
