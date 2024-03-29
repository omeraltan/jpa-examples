package test;

import domain.Employee;
import domain.EmployeeType;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest9 {
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

        System.out.println("Find All Employees");

        repository.findAllEmployees().forEach(System.out::println);

        System.out.println("Find All Employees Name");
        repository.findAllEmployeesName().forEach(System.out::println);

        System.out.println("Find Greater Than Salary");
        repository.findAllEmployeesNameGreaterThanSalary(3500).forEach(System.out::println);

        System.out.println("Find All Employees - Named Query");
        repository.findAllEmployeesByNamedQuery().forEach(System.out::println);

        System.out.println("Find By Id - Named Query");
        Employee foundEmployee = repository.findByIdNamedQuery(2);
        System.out.println(foundEmployee);

        entityManager.close();
        emf.close();
    }
}
