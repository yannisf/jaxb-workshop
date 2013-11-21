package fraglabs.jaxbworkshop;

import fraglabs.jaxbworkshop.model.Company;
import fraglabs.jaxbworkshop.model.Person;
import fraglabs.jaxbworkshop.model.PersonAdapter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class MarshalTests {

    private Company company;

    @BeforeTest
    public void setup() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Alice Wonderland"));
        persons.add(new Person("Bob Marley"));
        company = new Company("Security R US", persons);
    }

    @Test
    public void simple() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(company, System.out);
    }

    @Test
    public void override() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setAdapter(new PersonAdapter(" *SET* "));
        marshaller.marshal(company, System.out);
    }


}
