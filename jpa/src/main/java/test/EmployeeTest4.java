package test;

import domain.Employee;
import domain.Phone;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class EmployeeTest4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);

        Employee employee = new Employee();
        employee.setName("Cihan");
        employee.setSurname("Güllü");
        employee.setSalary(5000);

        Phone phone1 = new Phone("555588","MOBILE");
        Phone phone2 = new Phone("216200","HOME");
        Phone phone3 = new Phone("216100","WORK");

        repository.insertPhone(phone1);
        repository.insertPhone(phone2);
        repository.insertPhone(phone3);

        employee.getPhones().add(phone1);
        employee.getPhones().add(phone2);
        employee.getPhones().add(phone3);

        List<Phone> phones = Arrays.asList(phone1,phone2,phone3);

        repository.save(employee);
    }
}
