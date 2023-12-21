package ru.sber.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    private String address;
    private String phone;

    public Contact() {
    }

    public Contact(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
