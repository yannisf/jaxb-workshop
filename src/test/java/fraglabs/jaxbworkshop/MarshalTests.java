package fraglabs.jaxbworkshop;

import com.sun.xml.internal.ws.util.xml.ContentHandlerToXMLStreamWriter;
import fraglabs.jaxbworkshop.model.Company;
import fraglabs.jaxbworkshop.model.Person;
import fraglabs.jaxbworkshop.model.PersonAdapter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
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
    public void overrideContentHandler() throws JAXBException, IOException, XMLStreamException {
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        OutputStream outputStream = System.out;
        final XMLStreamWriter out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                new OutputStreamWriter(outputStream, "utf-8"));
        ContentHandlerToXMLStreamWriter handler = new ContentHandlerToXMLStreamWriter(out);
        marshaller.marshal(company, handler);

        out.close();

    }

    @Test
    public void printXml() throws JAXBException, UnsupportedEncodingException, XMLStreamException {
        XMLStreamWriter out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                new OutputStreamWriter(System.out, "utf-8"));

        out.writeStartDocument();
        out.writeStartElement("doc");

        out.writeStartElement("title");
        out.writeCharacters("Document Title");
        out.writeEndElement();

        out.writeEndElement();
        out.writeEndDocument();

        out.close();    }


}
