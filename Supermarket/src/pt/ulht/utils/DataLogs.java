package pt.ulht.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import pt.ulht.beans.Caixa;
import pt.ulht.beans.Cliente;


public class DataLogs {
	
	private static final String filePath = "testJDOM.xml";
	
	
	//Inicializar o Ficheiro de Log
	public static void initLog(String modo) {
		try {
			
			Element supermarket = new Element("supermarket");
			Document doc = new Document(supermarket);
			
			Element eModo = new Element("modo");
			eModo.addContent(modo);
			doc.getRootElement().addContent(eModo);
			
			Element eCaixas = new Element("caixas");
			doc.getRootElement().addContent(eCaixas);
			
			Element eClientes = new Element("clientes");
			doc.getRootElement().addContent(eClientes);
			
			XMLOutputter xmlOutput = new XMLOutputter();
			
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(filePath));
			
			System.out.println("Log Initialized! Mode: "+modo);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//Devolve Lista de Elements <cliente>
	public static List<Element> getClientListFromXML () {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filePath);
		
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			Element eClientes = rootNode.getChild("clientes");
			List<Element> clientList = eClientes.getChildren();
			
			return clientList;
		} catch (IOException io) {
			System.out.println("IO Exception!");
			io.printStackTrace();
		} catch (JDOMException jdex) {
			System.out.println("JDOM Exception!");
			jdex.printStackTrace();
		}
		return null;
	}
	
	//Devolve Lista de objectos Cliente existentes no Log (Continuar Execução) - Not Tested
	public static List<Cliente> buildClientListFromLog() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filePath);
		String id;
		String nProdutos;
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			Element eClientes = rootNode.getChild("clientes");
			List<Element> eClientList = eClientes.getChildren();
			
			if (eClientList != null) {
				for (int i = 0; i < eClientList.size(); i++) {
					Element eClient = eClientList.get(i);
					id = eClient.getAttribute("id").getValue();
					nProdutos = eClient.getChildText("nProdutos");
					Cliente cliente = new Cliente(Integer.parseInt(id), Integer.parseInt(nProdutos));
					listaClientes.add(cliente);
				}//End For Cycle
			return listaClientes;
			}//End IF List != null
		} catch (IOException io) {
			System.out.println("IO Exception!");
			io.printStackTrace();
		} catch (JDOMException jdex) {
			System.out.println("JDOM Exception!");
			jdex.printStackTrace();
		}
		return null;
	}
	
	//Devolve Lista de Elements <caixa>
	public static List<Element> getRegisterListFromXML () {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filePath);
		
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			Element eCaixas = rootNode.getChild("caixas");
			List<Element> registerList = eCaixas.getChildren();
			
			return registerList;
			
		} catch (IOException io) {
			System.out.println("IO Exception!");
			io.printStackTrace();
		} catch (JDOMException jdex) {
			System.out.println("JDOM Exception!");
			jdex.printStackTrace();
		}
		return null;
	}
	
	//Devolve Lista de objectos Caixa existentes no Log (Continuar Execução)
	public static List<Caixa> buildRegisterListFromLog() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filePath);
		String id;
		String nFila;
		String nAtend;
		String total;
		String medio;
		
		List<Caixa> listaCaixas = new ArrayList<Caixa>();
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			
			Element eCaixas = rootNode.getChild("caixas");
			List<Element> eRegisterList = eCaixas.getChildren();
			
			if (eRegisterList != null) {
				for (int i = 0; i < eRegisterList.size(); i++) {
					Element eCaixa = eRegisterList.get(i);
					id = eCaixa.getAttribute("id").getValue();
					nFila = eCaixa.getChildText("nFila");
					nAtend = eCaixa.getChildText("nAtend");
					total = eCaixa.getChildText("total");
					medio = eCaixa.getChildText("medio");
					Caixa caixa = new Caixa(Integer.parseInt(id),
												  Integer.parseInt(nFila),
												  Integer.parseInt(nAtend),
												  Integer.parseInt(total),
												  Integer.parseInt(medio));
					listaCaixas.add(caixa);
				}//End For Cycle
			return listaCaixas;
			}//End IF List != null
		} catch (IOException io) {
			System.out.println("IO Exception!");
			io.printStackTrace();
		} catch (JDOMException jdex) {
			System.out.println("JDOM Exception!");
			jdex.printStackTrace();
		}
		return null;
	}
	
	//Imprime os Logs com base numa "choice" - <clientes> ou <caixas>
	public static List<Element> readLog(String choice) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(filePath);

		if (!!choice.equalsIgnoreCase("clientes") || !!choice.equalsIgnoreCase("caixas")) {
			try {
				
				Document document = (Document) builder.build(xmlFile);
				Element rootNode = document.getRootElement();
				
				Element eChoice = rootNode.getChild(choice);
				List<Element> list = eChoice.getChildren();
				
				if (choice.equalsIgnoreCase("caixas")) {
					for (int i = 0; i < list.size(); i++) {
						Element node = (Element) list.get(i);
						System.out.println("Caixa ID: "+node.getAttribute("id").getValue());
						System.out.println("nFila: "+node.getChildText("nFila").toString());
						System.out.println("nAtend: "+node.getChildText("nAtend").toString());
						System.out.println("Total: "+node.getChildText("total").toString());
						System.out.println("Medio: "+node.getChildText("medio").toString());
						System.out.println("");
					}	
				} else if (choice.equalsIgnoreCase("clientes")) {
					for (int i = 0; i < list.size(); i++) {
						Element node = (Element) list.get(i);
						System.out.println("Cliente ID: "+node.getAttribute("id").getValue());
						System.out.println("nProdutos: "+node.getChildText("nProdutos").toString());
						System.out.println("");
					}
				}
				
				return list;
				
			} catch (IOException io) {
				io.printStackTrace();
			} catch (JDOMException jdomex) {
				jdomex.printStackTrace();
			}
			
		} else {
			System.out.println("Escolha Incorrecta!");
		}
		
		return null;
	}
	
	
	//Escreve um novo <cliente> no Log
	public static void writeNewClient(String id, String nProdutos) {
		try {
			
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(filePath);
			
			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();
			
			Element eClientes = rootNode.getChild("clientes");
			Element eCliente = new Element ("cliente");
					
			eCliente.setAttribute(new Attribute("id", id));
			eCliente.addContent(new Element("nProdutos").setText(nProdutos));
			
			eClientes.addContent(eCliente);
			
			XMLOutputter xmlOutput = new XMLOutputter();
			
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(filePath));
			
			System.out.println("Novo Cliente Gravado!");	
									
		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}
	
	
	//Escreve uma nova <caixa> no Log
	public static void writeNewRegister(String id, String nFila, String nAtend, String total, String medio) {
		try {
			
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(filePath);
			
			Document doc = (Document) builder.build(xmlFile);
			Element rootNode = doc.getRootElement();
			
			Element eCaixas = rootNode.getChild("caixas");
			Element eCaixa = new Element("caixa");
			
			eCaixa.setAttribute(new Attribute("id", id));
			eCaixa.addContent(new Element("nFila").setText(nFila));
			eCaixa.addContent(new Element("nAtend").setText(nAtend));
			eCaixa.addContent(new Element("total").setText(total));
			eCaixa.addContent(new Element("medio").setText(medio));
			
			eCaixas.addContent(eCaixa);
			
			XMLOutputter xmlOutput = new XMLOutputter();
			
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(filePath));
			
			System.out.println("Nova Caixa Gravada!");			
									
		} catch (IOException io) {
			io.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}

	

}

