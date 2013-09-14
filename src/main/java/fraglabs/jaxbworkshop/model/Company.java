package fraglabs.jaxbworkshop.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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

    @XmlElementWrapper(name = "persons")
    @XmlElement(name = "name")
    @XmlJavaTypeAdapter(value = PersonAdapter.class)
    public List<Person> getPersons() {
        System.out.println("Getter invoked");
        if (persons == null) {
            persons = new ArrayList<Person>();
        }

        return persons;
    }

    /* If setter is available, it will be used. If not jaxb will add on the list retrieved by the getter */
//    public void setPersons(List<Person> persons) {
//        System.out.println("Setter invoked");
//        this.persons = persons;
//    }

    @Override
    public String toString() {
        return "Company{name='" + name + '\'' + ", persons=" + getPersons().size() + '}';
    }

}
