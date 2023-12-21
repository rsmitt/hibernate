package ru.sber.entity;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "company_address")),
            @AttributeOverride(name = "phone", column = @Column(name = "company_phone"))
    })
    private Contact contact;

    public Company() {
    }

    public Company(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
