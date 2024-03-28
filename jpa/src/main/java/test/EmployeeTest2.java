package test;

import domain.Employee;
import domain.ParkingSpace;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeRepository repository = new EmployeeRepositoryImpl(entityManager);

        Employee employee = new Employee();
        employee.setName("Cihan");
        employee.setSurname("Güllü");
        employee.setSalary(5000);

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setFlat(-1);
        parkingSpace.setLocation("A-10");

        parkingSpace.setEmployee(employee);
        repository.insertParkingSpace(parkingSpace);

        employee.setParkingSpace(parkingSpace);
        repository.save(employee);

//        ParkingSpace foundPs = entityManager.find(ParkingSpace.class, 1);
//        System.out.println(foundPs);
    }
}
