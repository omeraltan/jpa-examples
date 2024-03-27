package test;

import dao.EmployeeDAO;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestEmployeeDAO {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeDAO empDAO = new EmployeeDAO(entityManager);

        Employee employee1 = new Employee(1, "suleyman", "can", 5000);
        Employee employee2 = new Employee(2, "ilker", "ozdal", 10000);
        System.out.println("inserting.....");
        empDAO.saveEmployee(employee1);
        empDAO.saveEmployee(employee2);
        System.out.println("inserting... ok");
        System.out.println("finding.....");
        Employee foundEmployee = empDAO.findEmployeeById(2);
        System.out.println(foundEmployee);

        System.out.println("Get all....");
        empDAO.findAllEmployees().forEach(System.out::println);

        System.out.println("Deleting...");
        empDAO.removeEmployee(2);
        System.out.println("Updating...");
        empDAO.raiseSalary(1,3000);
        foundEmployee = empDAO.findEmployeeById(1);
        System.out.println(foundEmployee);
    }
}
