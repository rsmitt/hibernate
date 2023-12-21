package ru.sber;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.sber.entity.Company;
import ru.sber.entity.Contact;
import ru.sber.entity.Position;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Session session = Util.getSessionFactory().openSession();
        session.getTransaction().begin();

        Contact contact = new Contact("address1", "phone1");
        Contact contact1 = new Contact("address2", "phone2");

        Employee employee = new Employee("name1", Position.PROGRAMMER);
        employee.getSkills().put("JAVA", 5);
        employee.getSkills().put("PYTHON", 2);
        employee.getContact().add(contact);
        employee.getContact().add(contact1);

        Employee employee2 = new Employee("name2", Position.PROGRAMMER);
        employee2.getSkills().put("C", 4);
        employee2.getSkills().put("GO", 1);
        employee2.getContact().add(contact);
        employee2.getContact().add(contact1);

        Company company = new Company("company1", contact);

        session.save(employee);
        session.save(employee2);
        session.save(company);



        session.getTransaction().commit();

        session.getTransaction().begin();

        //Employee employee1 = session.get(Employee.class, 5L);
        Employee employee1 = session.load(Employee.class, 1L);
        System.out.println("Employee name: " + employee1.getName());
        session.delete(employee1);

        session.getTransaction().commit();

        session.close();
    }
}
