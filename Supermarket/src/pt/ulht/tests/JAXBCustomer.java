package pt.ulht.tests;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBCustomer {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("Joao");
		customer.setAge(27);
		
		Customer customer2 = new Customer();
		customer2.setId(99);
		customer2.setName("Eu");
		customer2.setAge(10);
		
		try {
			File file = new File("testJAXB.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer2, file);
			jaxbMarshaller.marshal(customer, System.out);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
