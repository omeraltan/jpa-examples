package test;

import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeTest10 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);

        Employee employee = new Employee();
        employee.setName("Cihan");
        employee.setSurname("Güllü");
        employee.setSalary(5000);

        Employee employee2 = new Employee();
        employee2.setName("Murat");
        employee2.setSurname("Toraman");
        employee2.setSalary(4000);

        Employee employee3 = new Employee();
        employee3.setName("Alpay");
        employee3.setSurname("Tirasoglu");
        employee3.setSalary(3000);

        repository.save(employee);
        repository.save(employee2);
        repository.save(employee3);

        System.out.println("--- test ---");
        repository.queryEmployee();

        entityManager.close();
        emf.close();
    }
}
