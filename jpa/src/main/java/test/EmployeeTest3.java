package test;

import domain.Department;
import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest3 {
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
        employee2.setSalary(5000);

        repository.save(employee);
        repository.save(employee2);

        Department department = new Department();
        department.setDeptName("IT - Dept");
        repository.insertDepartment(department);

        entityManager.getTransaction().begin();
        employee.setDepartment(department);
        employee2.setDepartment(department);
        department.getEmployees().add(employee);
        department.getEmployees().add(employee2);
        entityManager.getTransaction().commit();

        Department departmentFound = entityManager.find(Department.class, 1);
        departmentFound.getEmployees().forEach(System.out::println);
    }
}
