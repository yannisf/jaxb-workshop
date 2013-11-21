package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PersonAdapter extends XmlAdapter<AdaptedPerson, Person> {

    private String injected;


    public PersonAdapter() {  }

    public PersonAdapter(String injected) {
        this.injected = injected;
    }

    @Override
    public Person unmarshal(AdaptedPerson v) throws Exception {
        return new Person(v.getFirstName() + " " + v.getLastName());
    }

    @Override
    public AdaptedPerson marshal(Person v) throws Exception {
        String[] name = v.getName().split("\\s");
        return new AdaptedPerson(name[0], name[1] + injected);
    }
}
