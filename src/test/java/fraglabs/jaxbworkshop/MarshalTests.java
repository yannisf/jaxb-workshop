package fraglabs.jaxbworkshop;

import fraglabs.jaxbworkshop.model.Company;
import fraglabs.jaxbworkshop.model.Person;
import org.junit.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MarshalTests {

    private Company company;

    @BeforeTest
    public void setup() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Alice"));
        persons.add(new Person("Bob"));
        company = new Company("Security R US", persons);
    }

    @Test
    public void simple() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(company, System.out);
    }

}
