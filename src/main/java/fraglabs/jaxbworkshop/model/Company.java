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
    @XmlElement(name = "person")
    @XmlJavaTypeAdapter(value = PersonAdapter1.class)
    public List<Person> getPersons() {
        System.out.println("Getter invoked");
        if (persons == null) {
            persons = new ArrayList<Person>();
        }

        return persons;
    }


    @Override
    public String toString() {
        return "Company{name='" + name + '\'' + ", persons=" + getPersons().size() + '}';
    }

}
