package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Company {

    @XmlElement
    private String name;

    @XmlTransient
    private List<Person> persons;

    public Company() { }

    public Company(String name, List<Person> persons) {
        this.name = name;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        if (persons == null) {
            persons = new ArrayList<Person>();
        }

        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @XmlElementWrapper(name = "persons")
    @XmlElement(name = "name")
    public List<String> getPersonNames() {
        System.out.println("Getter invoked");
        List<String> personNames = new ArrayList<String>();
        for (Person person : getPersons()) {
            personNames.add(person.getName());
        }

        return personNames;
    }

    /* Instead of the setter, just the getter would be sufficient if there was a var to cache the added persons */
    public void setPersonNames(List<String> personNames) {
        System.out.println("Setter invoked");
        for (String personName : personNames) {
            getPersons().add(new Person(personName));
        }
    }

    @Override
    public String toString() {
        return "Company{name='" + name + '\'' + ", persons=" + getPersons().size() + '}';
    }

}
