package test;

import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EmployeeTest6 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);
        Employee employee = new Employee();
        employee.setName("Cihan");
        employee.setSurname("Güllü");
        employee.setSalary(5000);
        //employee.setEmails(Arrays.asList("a@b.com", "b@c.com", "d@gmail.com"));
        Map<String, String> phones = new HashMap<>();
        phones.put("HOME","216100");
        phones.put("WORK","216200");
        phones.put("MOBILE","555588");

        employee.setPhoneNumbers(phones);

        repository.save(employee);
    }
}
