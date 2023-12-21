package ru.sber;

import ru.sber.entity.Contact;
import ru.sber.entity.Position;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@NamedQueries(
        @NamedQuery(name = "Employee.name", query = "select e from Employee e where e.name = :name")
)
@Table(
        indexes = @Index(name = "name_position_idx", columnList = "name, position", unique = true)
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Position position;

    @ElementCollection
    @CollectionTable(name = "employee_contact", joinColumns = @JoinColumn(name = "employee_id"))
    private List<Contact> contact = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "employee_skill", joinColumns = @JoinColumn(name = "employee_id"))
    @MapKeyColumn(name = "skill")
    @Column(name = "age")
    private Map<String, Integer> skills = new HashMap<>();

    public Employee() {
    }

    public Employee(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", contact=" + contact +
                ", skills=" + skills +
                '}';
    }
}
