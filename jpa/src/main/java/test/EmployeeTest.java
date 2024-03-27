package test;

import domain.Employee;
import domain.EmployeeType;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class EmployeeTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();

        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);
        Employee employee = new Employee();
        employee.setName("Cihan");
        employee.setSurname("Güllü");
        employee.setSalary(5000);
        EmployeeType empType = EmployeeType.PART_TIME;
        employee.setEmployeeType(empType);
        Date today = new Date();
        employee.setStartDate(today);
        byte[] imageData = "content".getBytes();
        employee.setImage(imageData);
        repository.save(employee);

        entityManager.close();
        emf.close();
    }
}
