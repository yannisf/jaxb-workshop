package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Company {

    @XmlElement
    private String name;

    @XmlElement(name="person")
    @XmlElementWrapper(name="persons")
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
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Company{name='" + name + '\'' + ", persons=" + persons.size() + '}';
    }

}
