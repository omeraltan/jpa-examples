package test;

import domain.Department;
import domain.Employee;
import domain.EmployeeType;
import domain.ParkingSpace;
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

        Department department = new Department();
        department.setDeptName("IT - Dept");

        repository.insertDepartment(department);

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setFlat(-1);
        parkingSpace.setLocation("A-10");

        repository.insertParkingSpace(parkingSpace);

        employee.setDepartment(department);
        employee.setParkingSpace(parkingSpace);
        repository.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("Murat");
        employee2.setSurname("Toraman");
        employee2.setSalary(5000);
        employee2.setEmployeeType(EmployeeType.PART_TIME);

        employee2.setDepartment(department);
        employee2.setParkingSpace(parkingSpace);
        repository.save(employee2);

        entityManager.close();
        emf.close();
    }
}
