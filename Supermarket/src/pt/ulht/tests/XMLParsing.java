package pt.ulht.tests;

import pt.ulht.beans.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;
import org.xml.sax.*;


import java.io.File;

public class XMLParsing {
	
	private static final String xmlFilePath = "bin\\testFile.xml";

	@SuppressWarnings("unchecked")
	public void XMLParser() {
		//args[0] - Nº Clientes ; args[1] - Nº Caixas ??
		
		try {
			
			File xmlFile = new File(xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("staff");
			
			System.out.println("-----------------------------");
			
			for (int i = 0; i < nList.getLength(); i++) {
				System.out.println(i);
				Node nNode = nList.item(i);
				System.out.println("\n Current Element: " + nNode.getNodeName());
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					
					System.out.println("Staff id: " + element.getAttribute("id"));
					System.out.println("First Name: " + element.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name: "+ element.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name: "+ element.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary: "+ element.getElementsByTagName("salary").item(0).getTextContent());
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}

}
