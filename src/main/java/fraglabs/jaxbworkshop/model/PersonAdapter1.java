package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PersonAdapter1 extends XmlAdapter<AdaptedPerson1, Person> {


    @Override
    public Person unmarshal(AdaptedPerson1 v) throws Exception {
        return new Person(v.getFirstName() + " " + v.getLastName());
    }

    @Override
    public AdaptedPerson1 marshal(Person v) throws Exception {
        String[] name = v.getName().split("\\s");
        return new AdaptedPerson1(name[0], name[1]);
    }
}
