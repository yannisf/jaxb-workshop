package fraglabs.jaxbworkshop;

import fraglabs.jaxbworkshop.model.Company;
import fraglabs.jaxbworkshop.model.Person;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UnmarshalTests {

    @Test
    public void simple() throws JAXBException, IOException {
        InputStream inputStream = getClass().getResourceAsStream("/persons.xml");
        JAXBContext context = JAXBContext.newInstance(Company.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Company company = (Company) unmarshaller.unmarshal(inputStream);
        System.out.println(company);
        IOUtils.closeQuietly(inputStream);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(company, System.out);

    }

}
