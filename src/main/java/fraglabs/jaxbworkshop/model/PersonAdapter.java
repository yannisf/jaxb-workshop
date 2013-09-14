package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PersonAdapter extends XmlAdapter<String, Person> {

    @Override
    public Person unmarshal(String personName) {
        return new Person(personName);
    }

    @Override
    public String marshal(Person person) {
        return person.getName();
    }

}
