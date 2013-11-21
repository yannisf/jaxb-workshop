package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PersonAdapter2 extends XmlAdapter<AdaptedPerson2, Person> {


    @Override
    public Person unmarshal(AdaptedPerson2 v) throws Exception {
        return new Person(v.getTitle() + " " + v.getFirstName() + " " + v.getLastName());
    }

    @Override
    public AdaptedPerson2 marshal(Person v) throws Exception {
        String[] name = v.getName().split("\\s");
        return new AdaptedPerson2(name[0], name[1], name[2]);
    }

}
